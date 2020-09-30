package org.tzi.use.uml.ocl.type;

import java.util.HashSet;
import java.util.Set;

public class URealType extends UncertainType {

    protected URealType() {
        super("UReal");
    }

    @Override
    public boolean conformsTo(Type t) {
        return equals(t) || t.isTypeOfOclAny();
    }

    @Override
    public boolean isTypeOfUReal() {
        return true;
    }

    @Override
    public boolean isKindOfUReal(VoidHandling h) {
        return true;
    }

    @Override
    public boolean isKindOfNumber(VoidHandling h) {
        return true;
    }

    @Override
    public Set<? extends Type> allSupertypes() {
        Set<Type> supertypes = new HashSet<>();
        supertypes.add(this);
        supertypes.add(TypeFactory.mkOclAny());
        return supertypes;
    }
}
