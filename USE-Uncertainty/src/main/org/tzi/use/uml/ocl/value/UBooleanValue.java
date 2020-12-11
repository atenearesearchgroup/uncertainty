package org.tzi.use.uml.ocl.value;

import uDataTypes.UBoolean;
import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.util.MathUtil;

/**
 * UBoolean is a supertype of Boolean that add uncertainty to its values. Thus, a UBoolean value its a pair (b, c),
 * where b its a Boolean and c its a Real number in range [0,1] that represent the probability of b.
 *
 * @author Víctor Manuel Ortiz Guardeño
 * @since 28/12/2019
 * @see org.tzi.use.uml.ocl.value.BooleanValue
 */

public class UBooleanValue extends UncertainBooleanValue {

    /**
     * Wrapped UBoolean value from Uncertainty library.
     */
    private final UBoolean uBoolean;

    /**
     * Its a UBoolean that always its true (true, 1)
     */
    public static final UBooleanValue TRUE = new UBooleanValue(true, 1);
    /**
     * Its a UBoolean that always its false (true, 0)
     */
    public static final UBooleanValue FALSE = new UBooleanValue(true, 0);


    // CONSTRUCTORS AND FACTORY METHODS

    /**
     * Create a UBoolean instance from a UBoolean of uncertainty library
     *
     * @param uBoolean  Instance of Uncertainty Boolean Library
     */

    UBooleanValue(UBoolean uBoolean) {
        super(TypeFactory.mkUBoolean());

        // TODO: Rremove "if" when It known how hanlde probabilities 0 < c or c > 1
        if (uBoolean.getC() < 0 || uBoolean.getC() > 1)
            throw new RuntimeException("Probability must be a non-uncertainty number between 0 and 1");

        this.uBoolean = uBoolean;
    }

    /**
     * Create a UBoolean from a pair (value, probability).
     *
     * @param value  A boolean represent the value of UBoolean
     * @param probability A double represent the probability. This value must be in [0, 1]
     */

    private UBooleanValue(boolean value, double probability) {
        this(new UBoolean(value, probability));
    }

    /**
     * A package protected factory method that allow to create a instance from Uboolean uncertainty library.
     *
     * Note : This method its package visibility for isolate uncertainty library clases. Its used by other clases
     * that executed methods of uncertainty library that returns Ubooleans.
     *
     * @param value Uncertainty library's Uboolean
     *
     * @return A instance of UbooleanValue
     */

    static UBooleanValue valueOf(UBoolean value) {
        UBooleanValue result;

        // Check if should create a new instance or not.
        if (value.getC() == 0)
            result = FALSE;
        else if (value.getC() == 1)
            result = TRUE;
        else
            result = new UBooleanValue(value);

        return result;
    }

    /**
     * Get a UBoolean instance from a pair (value, probability).
     *
     * @param value        A boolean value true or false.
     * @param probability  A double value that must be between 0 and 1
     * @return
     */

    public static UBooleanValue valueOf(boolean value, double probability) {
        UBooleanValue result;

        // TODO: try to elimintate this, because the invariant [0, 1] is checked in construtors.
        if (!value) {
            value = true;
            probability = 1 - probability;
        }

        if (probability == 0)
            result = FALSE;
        else if (probability == 1)
            result = TRUE;
        else
            result = new UBooleanValue(true, probability);

        return result;
    }

    /**
     * Try to get a value of UBoolean if its posible. Only it can happen when the passed value is UbooleanValue or BooleanValue.
     *
     * @param arg A value
     * @return Null if cannot be turned to UBooleanValue or an instance of UBoolean.
     */

    public static UBooleanValue valueOf(Value arg) {
        UBooleanValue result = null;

        if (arg.isUBoolean())
            result = (UBooleanValue) arg;
        else if (arg.isBoolean()) {
            boolean b = ((BooleanValue) arg).value();

            if (b)
                result = UBooleanValue.TRUE;
            else
                result = UBooleanValue.FALSE;

        }

        return result;
    }

    // METHODS

    /**
     * Access to the wrapper object UBoolean
     *
     * @return UBoolean instance
     */

    UBoolean getuBoolean() {
        return uBoolean;
    }

    /**
     * Access to the value of UBoolean instance
     *
     * @return UBoolean's value
     */

    public boolean value() {
        return uBoolean.getB();
    }

    /**
     * Access to the probability of UBoolean instance.
     *
     * @return UBoolean's probability.
     */

    public double probability() {
        return uBoolean.getC();
    }

    /**
     * Check if this value if UBoolean
     *
     * @return true.
     */

    @Override
    public boolean isUBoolean() {
        return true;
    }

    /**
     * A UBoolean value its represented by the string 'UBoolean(true, P)' where P will be a Real between 0 and 1.
     *
     * @param sb StringBuilder to append a Uboolean representation
     *
     * @return The StringBuilder passed with a UBooleanRepresentation appended.
     */

    @Override
    public StringBuilder toString(StringBuilder sb) {
        return sb.append(type().toString())
                .append("(")
                .append(value())
                .append(", ")
                .append(MathUtil.round(probability(), 3))
                .append(")");
    }

    /**
     * The hashcode of UBoolean
     *
     * @return UBoolean's hashcode
     */

    @Override
    public int hashCode() {
        // NOTE: This is an library implemetation.
        // TODO: check if hash( UB(true, 0) ) = hash( B(false) ) and hash( UB(true, 1)) = hash( U(true) )
        return uBoolean.hashCode();
    }

    /**
     * Two Ubooleans A and B are equals if A.value = B.value and A.probability = B.probability with 10 of precision. A
     * UBoolean A can be equals to a Boolean B if A its (true, 0) or (true, 1) and B false or true respectively.
     *
     * @param obj A objecto to check if equals.
     *
     * @return True if equals and false if not.
     */

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;

        if (obj == this)
            return true;

        if (obj instanceof BooleanValue) {
            BooleanValue other = (BooleanValue) obj;

            equals = (other.isTrue() && this.probability() == 1 && this.value() ) ||
                     (other.isFalse() && this.probability() == 0 && !this.value());

        }
        else if (obj instanceof UBooleanValue) {
            UBooleanValue other = (UBooleanValue) obj;

            equals = MathUtil.round(other.probability(), 10) == MathUtil.round(this.probability(), 10) &&
                     this.value() == other.value();
        }

        return equals;
    }

    // Note: there is no information about how it will be compare two UBooleans in the documentations. So, this implementations
    // its a adaptation of Boolean.

    @Override
    public int compareTo(Value o) {
        if (o == this )
            return 0;
        if (o instanceof UndefinedValue )
            return +1;
        if (! (o instanceof BooleanValue || o instanceof UBooleanValue) )
            return toString().compareTo(o.toString());

        boolean b;

        if (o instanceof BooleanValue)
            b = ((BooleanValue) o).value();
        else
            b = ((UBooleanValue) o ).value();

        if (uBoolean.toBoolean() == b )
            return 0;
        else if (uBoolean.toBoolean() )
            return 1;
        else
            return -1;
    }

    @Override
    public UncertainBooleanValue uEquals(Value other) {
        UBooleanValue result = FALSE;

        if (other.type().isKindOfUBoolean(Type.VoidHandling.EXCLUDE_VOID)) {
            UBooleanValue aux = valueOf(other);
            result = valueOf(uBoolean.equivalent(aux.uBoolean));
        }

        return result;
    }

    /**
     * Try to cast a UBoolean from the  value passed as argument. If couldn't be posible, the method will throw a
     * ClassCastException.
     *
     * @param value The value to be casted as UBoolean
     * @return An UBoolean if could be casted, an exception if not.
     * @throws ClassCastException
     */

    private UBooleanValue assertKindOfUBoolean(Value value) {
        UBooleanValue uBool = valueOf(value);

        if (uBool == null)
            throw new ClassCastException("A value kind of UBoolean expected");

        return uBool;
    }

    // ----------------------------------------------- Wrapper methods -------------------------------------------------

    /**
     * Allow to get the UBoolean from a Boolean
     *
     * @return A Boolean.
     */

    public BooleanValue toBoolean() {
        return BooleanValue.get(uBoolean.toBoolean());
    }

    @Override
    public UncertainBooleanValue not() {
        return valueOf(uBoolean.not());
    }

    public UBooleanValue and(Value other) {
        UBooleanValue uBooleanValue = assertKindOfUBoolean(other);
        return valueOf(uBoolean.and(uBooleanValue.uBoolean));
    }

    public UBooleanValue or(Value other) {
        UBooleanValue uBooleanValue = assertKindOfUBoolean(other);
        return valueOf(uBoolean.or(uBooleanValue.uBoolean));
    }

    public UBooleanValue xor(Value other) {
        UBooleanValue uBooleanValue = assertKindOfUBoolean(other);
        return valueOf(uBoolean.xor(uBooleanValue.uBoolean));
    }

    public UBooleanValue equivalent(Value other) {
        UBooleanValue uBooleanValue = assertKindOfUBoolean(other);
        return valueOf(uBoolean.equivalent(uBooleanValue.uBoolean));
    }

    public UBooleanValue implies(Value other) {
        UBooleanValue uBooleanValue = assertKindOfUBoolean(other);
        return valueOf(uBoolean.implies(uBooleanValue.uBoolean));
    }

    public BooleanValue equalsC(Value other, double c) {
        UBooleanValue uBooleanValue = assertKindOfUBoolean(other);
        return BooleanValue.get(uBoolean.equalsC(uBooleanValue.uBoolean, c));
    }

}
