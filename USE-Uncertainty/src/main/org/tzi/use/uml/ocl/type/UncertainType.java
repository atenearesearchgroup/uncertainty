package org.tzi.use.uml.ocl.type;

/**
 * Abstract base class for basic types (Integer, Real, Boolean, and String).
 *
 * @version $TFG: 0.1.1.0
 * @author  Víctor Manuel Ortiz Guardeño
 */

public abstract class UncertainType extends BasicType {

    protected UncertainType(String t) {
        super(t);
    }

}
