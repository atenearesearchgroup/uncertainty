package org.tzi.use.uml.ocl.value;

import org.tzi.use.uml.ocl.type.Type;

/**
 * <p>Abstract value for uncertainty values</p>
 * <p>
 *     This values must be comparable with UBooleans too.
 * </p>
 *
 * @author  Víctor M. Ortiz
 * @see Value
 */

public abstract class UncertainValue extends Value{

    protected UncertainValue(Type t) {
        super(t);
    }

    /**
     * Compare the value with another with uncertainty.
     *
     * @param other Value to compare.
     * @return  UBoolean with the probability of been equals.
     */

    public abstract UncertainBooleanValue uEquals(Value other);

    /**
     * Check if this value is distinct to other
     *
     * @param other  A value to compare
     * @return UBoolean with the probability of been equals.
     */

    public UncertainBooleanValue uDistinct(Value other) {
        UncertainBooleanValue equals = uEquals(other);
        UncertainBooleanValue distinct;

        distinct = equals.not();

        return distinct;
    }


}
