package org.tzi.use.uml.ocl.value;

import uDataTypes.UBoolean;
import uDataTypes.UReal;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.util.MathUtil;

/**
 * URealValue is a wrapper of the real UReal witch is in the library of atenearesearchgroup.
 *
 * @author Víctor Manuel Ortiz Guardeño
 */

public class URealValue extends UncertainValue {

    private UReal uReal;

    public URealValue(double value, double uncertainty) {
        super(TypeFactory.mkUReal());
        uReal = new UReal(value, uncertainty);
    }

    public URealValue(UReal uReal) {
        super(TypeFactory.mkUReal());
        this.uReal = uReal;
    }

    public double value() {
        return uReal.getX();
    }

    public double uncertainty() {
        return uReal.getU();
    }

    @Override
    public boolean isUReal() {
        return true;
    }

    @Override
    public StringBuilder toString(StringBuilder sb) {
        // Sometimes Java set a negative zero to a double. This produces
        // a "-0.00", and for fix this, have to wrote the next line.
        double valueCorrected = value() == 0 ? 0 : value();
        sb.append(type())
                .append("(")
                .append(MathUtil.round(valueCorrected, 10))
                .append(", ")
                .append(MathUtil.round(uncertainty(), 10))
                .append(")");
        return sb;
    }

    @Override
    public int hashCode() {
        //return uReal.hashCode();
        int hash = Double.hashCode(value());

        if (uncertainty() != 0)
            hash = hash * 7 + Double.hashCode(uncertainty());

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if (obj instanceof Value) {

            if (obj instanceof URealValue) {
                // Avoiding the double precision, I have to round the values
                double thisValue = value(), otherValue = ((URealValue) obj).value();
                double thisUncertainty = uncertainty(), otherUncertainty = ((URealValue)obj).uncertainty();

                thisValue = MathUtil.round(thisValue, 10);
                otherValue = MathUtil.round(otherValue, 10);
                thisUncertainty = MathUtil.round(thisUncertainty, 10);
                otherUncertainty = MathUtil.round(otherUncertainty, 10);

                eq = thisValue == otherValue && thisUncertainty == otherUncertainty;
            }
            else if (obj instanceof IntegerValue)
                eq = value() == ((IntegerValue) obj).value() && uncertainty() == 0;
            else if (obj instanceof RealValue)
                eq = value() == (((RealValue) obj).value()) && uncertainty() == 0;

        }

        return eq;
    }

    @Override
    public int compareTo(Value o) {
        int res = 0;

        if (o instanceof URealValue)
            res = uReal.compareTo(((URealValue) o).uReal);
        else if (o instanceof RealValue)
            res = uReal.compareTo(new UReal(((RealValue) o).value()));
        else if (o instanceof IntegerValue)
            res = uReal.compareTo(new UReal(((IntegerValue) o).value()));
        else if (o instanceof URealValue) {
            URealValue uReal = (URealValue) o;
            res = uReal.compareTo(new UIntegerValue((int) uReal.value(), uReal.uncertainty()));
        }

        return res;
    }

    public static URealValue valueOf(Value value) {
        URealValue ur1;

        if (value.isReal())
            ur1 = new URealValue(((RealValue) value).value(), 0);
        else if (value.isInteger())
            ur1 = new URealValue(((IntegerValue) value).value(), 0);
        else if (value.isUInteger())
            ur1 = ((UIntegerValue) value).toUReal();
        else if (value.isUReal())
            ur1 = (URealValue) value;
        else
            ur1 = null;

        return ur1;
    }

    /**
     * TODO: better description
     *
     * @param other Value to compare.
     * @return
     */

    @Override
    public UncertainBooleanValue uEquals(Value other) {

        URealValue uRealOther = valueOf(other);
        UBoolean result = null;

        if (uRealOther == null)
            result = new UBoolean(false, 1);
        else
            result = uReal.uEquals(uRealOther.uReal);

        return UBooleanValue.valueOf(result);
    }

    /**
     * This method ensure that the value is kind of UReal and return this value (casted)
     * @param value
     * @return An UReal value.
     */

    private URealValue assertKindOfUReal(Value value) {
        URealValue uReal = valueOf(value);

        if (uReal == null)
            throw new RuntimeException("A value kind of UReal expected");

        return uReal;
    }


    // ----------------------------------------------- Wrapped method --------------------------------------------------

    public URealValue add(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return new URealValue(uReal.add(castedOther.uReal));
    }

    public URealValue minus(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return new URealValue(uReal.minus(castedOther.uReal));
    }

    public URealValue divideBy(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return new URealValue(uReal.divideBy(castedOther.uReal));
    }

    public URealValue mult(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return new URealValue(uReal.mult(castedOther.uReal));
    }

    public URealValue min(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return new URealValue(uReal.min(castedOther.uReal));
    }

    public URealValue max(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return new URealValue(uReal.max(castedOther.uReal));
    }

    public URealValue sin() {
        return new URealValue(uReal.sin());
    }

    public URealValue cos() {
        return new URealValue(uReal.cos());
    }

    public URealValue tan() {
        return new URealValue(uReal.tan());
    }

    public URealValue asin() {
        return new URealValue(uReal.asin());
    }

    public URealValue acos() {
        return new URealValue(uReal.acos());
    }

    public URealValue atan() {
        return new URealValue(uReal.atan());
    }

    public URealValue inverse() {
        return new URealValue(uReal.inverse());
    }

    public URealValue floor() {
        return new URealValue(uReal.floor());
    }

    public URealValue round() {
        return new URealValue(uReal.round());
    }

    public URealValue abs() {
        return new URealValue(uReal.abs());
    }

    public URealValue neg() {
        return new URealValue(uReal.neg());
    }

    public URealValue sqrt() {
        return new URealValue(uReal.sqrt());
    }

    public URealValue power(float value) {
        return new URealValue(uReal.power(value));
    }

    public RealValue toReal() {
        return new RealValue(uReal.toReal());
    }

    public IntegerValue toInteger() {
        return IntegerValue.valueOf(uReal.toInteger());
    }

    public UIntegerValue toUInteger() {
        return new UIntegerValue((int) value(), uncertainty());
    }

    public UBooleanValue lt(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return UBooleanValue.valueOf(uReal.lt(castedOther.uReal));
    }

    public UBooleanValue gt(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return UBooleanValue.valueOf(uReal.gt(castedOther.uReal));
    }

    public UBooleanValue le(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return UBooleanValue.valueOf(uReal.le(castedOther.uReal));
    }

    public UBooleanValue ge(Value other) {
        URealValue castedOther = assertKindOfUReal(other);
        return UBooleanValue.valueOf(uReal.ge(castedOther.uReal));
    }
}
