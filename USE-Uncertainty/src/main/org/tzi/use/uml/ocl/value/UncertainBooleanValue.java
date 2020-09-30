package org.tzi.use.uml.ocl.value;

import org.tzi.use.uml.ocl.type.Type;

public abstract class UncertainBooleanValue extends UncertainValue {

    protected UncertainBooleanValue(Type t) {
        super(t);
    }

    public abstract UncertainBooleanValue not();

}
