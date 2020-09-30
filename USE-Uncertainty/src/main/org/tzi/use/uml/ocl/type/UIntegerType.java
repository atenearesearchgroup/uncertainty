package org.tzi.use.uml.ocl.type;

import java.util.HashSet;
import java.util.Set;

/**
 * The OCL Integer with uncertainty.
 *
 * @author Víctor M. Ortiz
 */

public class UIntegerType extends UncertainType {

    public UIntegerType() {
        super("UInteger");
    }

    @Override
    public boolean isKindOfNumber(VoidHandling h) {
        return true;
    }

    @Override
    public boolean isTypeOfUInteger() {
        return true;
    }

    @Override
    public boolean isKindOfUReal(VoidHandling h) {
        return true;
    }

    @Override
    public boolean isKindOfUInteger(VoidHandling h) {
        return true;
    }

    @Override
    public Set<? extends Type> allSupertypes() {
        Set<Type> res = new HashSet<Type>(3);
        res.add(TypeFactory.mkOclAny());
        res.add(TypeFactory.mkUReal());
        res.add(this);
        return res;
    }

    @Override
    public boolean conformsTo(Type other) {
        return other.isTypeOfUInteger() ||
                other.isTypeOfUReal() ||
                other.isTypeOfOclAny();
    }
}
