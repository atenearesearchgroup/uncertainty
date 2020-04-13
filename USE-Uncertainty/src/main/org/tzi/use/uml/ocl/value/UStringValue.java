package org.tzi.use.uml.ocl.value;

import atenearesearchgroup.uncertainty.uDataTypes.UString;
import org.tzi.use.uml.ocl.type.TypeFactory;

import java.util.List;

public class UStringValue extends UncertainValue {

    private UString wrapper;

    public UStringValue(UString ustring) {
        super(TypeFactory.mkUString());
        this.wrapper = ustring;
    }

    public UStringValue(String str, double uncertainty) {
        this(new UString(str, uncertainty));
    }

    /**
     * Cast the argument to UString, returns null if cannot be casted.
     * @param value
     * @return
     */

    public static UStringValue valueOf(Value value) {
        UStringValue ustring = null;

        if (value instanceof StringValue)
            ustring = new UStringValue(((StringValue) value).value(), 1);
        else if (value instanceof UStringValue)
            ustring = (UStringValue) value;

        return ustring;
    }

    /**
     * This method ensure that the value is kind of UString and return this value (casted)
     * @param value
     * @return An UString value.
     */

    private UStringValue assertKindOfUString(Value value) {
        UStringValue ustring = valueOf(value);

        if (ustring == null)
            throw new RuntimeException("A value kind of UString expected");

        return ustring;
    }

    @Override
    public UncertainBooleanValue uEquals(Value other) {
        UStringValue ustring = valueOf(other);
        UBooleanValue result = null;

        if (ustring == null)
            result = UBooleanValue.FALSE;
        else
            result = UBooleanValue.valueOf(wrapper.uEquals(ustring.wrapper));

        return result;
    }

    @Override
    public StringBuilder toString(StringBuilder sb) {
        return sb.append("UString('")
                .append(wrapper.getString()).append("', ")
                .append(wrapper.getsConf()).append(")");
    }

    @Override
    public int hashCode() {
        return wrapper.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (obj instanceof Value) {
            UStringValue ustring = valueOf((Value) obj);

            if (ustring != null)
                eq = wrapper.getString().equals(ustring.wrapper) &&
                        wrapper.getsConf() == wrapper.getsConf();

        }

        return eq;
    }

    @Override
    public int compareTo(Value o) {
        if (o == this )
            return 0;
        if (o instanceof UndefinedValue )
            return +1;
        if (! (o instanceof StringValue) )
            return toString().compareTo(o.toString());

        return wrapper.getString().compareTo(valueOf(o).toString());
    }


    //----------------------------------------------- métodos wrappper------------------------------------------------

    public String value() {
        return wrapper.getString();
    }

    public double confidence() {
        return wrapper.getsConf();
    }

    public UBooleanValue ge(Value other) {
        UStringValue ustring = assertKindOfUString(other);
        return UBooleanValue.valueOf(wrapper.ge(ustring.wrapper));
    }

    public UBooleanValue lt(Value other) {
        UStringValue ustring = assertKindOfUString(other);
        return UBooleanValue.valueOf(wrapper.lt(ustring.wrapper));
    }

    public UBooleanValue gt(Value other) {
        UStringValue ustring = assertKindOfUString(other);
        return UBooleanValue.valueOf(wrapper.gt(ustring.wrapper));
    }

    public UBooleanValue le(Value other) {
        UStringValue ustring = assertKindOfUString(other);
        return UBooleanValue.valueOf(wrapper.le(ustring.wrapper));
    }

    public StringValue at(int index) {
        return new StringValue(wrapper.at(index));
    }

    public UStringValue uAt(int index) {
        return new UStringValue(wrapper.uAt(index));
    }

    public BooleanValue toBoolean() {
        return BooleanValue.get(wrapper.toBoolean());
    }

    public IntegerValue toInteger() {
        return IntegerValue.valueOf(wrapper.toInteger());
    }

    public RealValue toReal() {
        return new RealValue(wrapper.toReal());
    }

    public StringValue uToString() {
        return new StringValue(wrapper.uToString());
    }

    public UBooleanValue toUBoolean() {
        return UBooleanValue.valueOf(wrapper.uToUBoolean());
    }

    public SequenceValue uCharacters() {
        List<UString> sequence = wrapper.uCharacters();
        Value [] result = new Value[sequence.size()];

        for (int i = 0 ; i < sequence.size() ; i++)
            result[i] = new UStringValue(sequence.get(i));

        return new SequenceValue(TypeFactory.mkUString(), result);
    }

    public UStringValue uConcat(Value other) {
        UStringValue ustring = assertKindOfUString(other);
        return new UStringValue(wrapper.uConcat(ustring.wrapper));
    }

    public UBooleanValue uEqualsIgnoreCase(Value other) {
        UStringValue ustring = assertKindOfUString(other);
        return UBooleanValue.valueOf(wrapper.uEqualsIgnoreCase(ustring.wrapper));
    }

    public UIntegerValue uSize() {
        return new UIntegerValue(wrapper.uSize());
    }

    public UStringValue uSubstring(int lower, int upper) {
        return new UStringValue(wrapper.uSubstring(lower, upper));
    }

    public UStringValue uToLowerCase() {
        return new UStringValue(wrapper.uToLowerCase());
    }

    public UStringValue uToUpperCase() {
        return new UStringValue(wrapper.uToUpperCase());
    }

    public IntegerValue indexOf(StringValue string) {
        return IntegerValue.valueOf(wrapper.indexOf(string.value()));
    }


}
