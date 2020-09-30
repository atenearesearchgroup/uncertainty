package org.tzi.use.uml.ocl.type;

import java.util.HashSet;
import java.util.Set;

public class UBooleanType extends UncertainBooleanType {

    UBooleanType() {
        super("UBoolean");
    }

    @Override
    public boolean isKindOfOclAny(VoidHandling h) {
        return true;
    }

    @Override
    public boolean isKindOfUBoolean(VoidHandling h) {
        return true;
    }

    @Override
    public boolean isKindOfSBoolean(VoidHandling h) {
        return true;
    }

    @Override
    public boolean isTypeOfUBoolean() {
        return true;
    }

    @Override
    public Set<? extends Type> allSupertypes() {
        Set<Type> res = new HashSet<>();
        res.add(TypeFactory.mkUBoolean());
        res.add(TypeFactory.mkOclAny());
        res.add(TypeFactory.mkSBoolean());

        return res;
    }

    @Override
    public boolean conformsTo(Type other) {
        return other.equals(this) || other.isTypeOfOclAny() || other.isTypeOfSBoolean();
    }
}
