package org.tzi.use.uml.ocl.type;

import java.util.HashSet;
import java.util.Set;

public class UStringType extends UncertainType {

    UStringType() {
        super("UString");
    }

    @Override
    public boolean isTypeOfUString() {
        return true;
    }

    @Override
    public boolean isKindOfUString(VoidHandling h) {
        return true;
    }

    @Override
    public Set<? extends Type> allSupertypes() {
        Set<Type> supertypes = new HashSet<>();
        supertypes.add(TypeFactory.mkUString());
        supertypes.add(TypeFactory.mkOclAny());
        return supertypes;
    }

    @Override
    public boolean conformsTo(Type other) {
        return equals(other) ||
                other.isTypeOfOclAny();
    }
}
