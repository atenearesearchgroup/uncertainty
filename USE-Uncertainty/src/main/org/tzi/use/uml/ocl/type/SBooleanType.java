package org.tzi.use.uml.ocl.type;

import java.util.HashSet;
import java.util.Set;

public class SBooleanType extends UncertainBooleanType {

    SBooleanType() {
        super("SBoolean");
    }

    @Override
    public boolean isTypeOfSBoolean() {
        return true;
    }

    @Override
    public boolean isKindOfSBoolean(VoidHandling h) {
        return true;
    }

    @Override
    public Set<? extends Type> allSupertypes() {
        Set<Type> res = new HashSet<>();
        res.add(TypeFactory.mkOclAny());
        res.add(TypeFactory.mkSBoolean());

        return res;
    }

    @Override
    public boolean conformsTo(Type other) {
        return other.isTypeOfSBoolean() ||
                other.isTypeOfOclAny();
    }
}
