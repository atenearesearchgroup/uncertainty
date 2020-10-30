package org.tzi.use.uml.ocl.expr.operations;

import uDataTypes.UReal;
import com.google.common.collect.Multimap;
import org.tzi.use.uml.ocl.expr.EvalContext;
import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.*;

public class StandardOperationsUReal {


    public static void registerTypeOperations(Multimap<String, OpGeneric> opmap) {
        // operations of UReal
        OpGeneric.registerOperation(new Op_ureal_abs(), opmap);
        OpGeneric.registerOperation(new Op_ureal_sin(), opmap);
        OpGeneric.registerOperation(new Op_ureal_cos(), opmap);
        OpGeneric.registerOperation(new Op_ureal_tan(), opmap);
        OpGeneric.registerOperation(new Op_ureal_asin(), opmap);
        OpGeneric.registerOperation(new Op_ureal_acos(), opmap);
        OpGeneric.registerOperation(new Op_ureal_atan(), opmap);
        OpGeneric.registerOperation(new Op_ureal_uncertainty(), opmap);
        OpGeneric.registerOperation(new Op_ureal_setUncertainty(), opmap);
        OpGeneric.registerOperation(new Op_ureal_value(), opmap);
        OpGeneric.registerOperation(new Op_ureal_setValue(), opmap);
        OpGeneric.registerOperation(new Op_ureal_neg(), opmap);
        OpGeneric.registerOperation(new Op_ureal_power(), opmap);
        OpGeneric.registerOperation(new Op_ureal_sqrt(), opmap);
        OpGeneric.registerOperation(new Op_ureal_inv(), opmap);
        OpGeneric.registerOperation(new Op_ureal_toReal(), opmap);
        OpGeneric.registerOperation(new Op_ureal_toInteger(), opmap);
        OpGeneric.registerOperation(new Op_ureal_toUInteger(), opmap);
    }

}

// --------------------------------------------------------

/* abs : UReal -> UReal */
final class Op_ureal_abs extends OpGeneric {
    @Override
    public String name() {
        return "abs";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return uRealValue.abs();
    }
}



// --------------------------------------------------------

/* inv : UReal -> UReal */
final class Op_ureal_inv extends OpGeneric {
    @Override
    public String name() {
        return "inv";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = (URealValue) args[0];
        URealValue result = uRealValue.inverse();

        // make special values resulting in undefined
        if (Double.isInfinite(result.value()) || Double.isNaN(result.value()))
            throw new ArithmeticException();

        return result;
    }
}

// --------------------------------------------------------

/* uncertainty : UReal -> Real */
final class Op_ureal_uncertainty extends OpGeneric {
    @Override
    public String name() {
        return "uncertainty";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return new RealValue(uRealValue.uncertainty());
    }
}

// --------------------------------------------------------

/* setUncertainty : UReal x (Integer + Real) -> UReal */
final class Op_ureal_setUncertainty extends OpGeneric {
    @Override
    public String name() {
        return "setUncertainty";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        Type expected = null;

        if (params.length == 2 && params[0].isTypeOfUReal() &&
                params[1].isKindOfReal(Type.VoidHandling.EXCLUDE_VOID))
            expected = TypeFactory.mkUReal();

        return expected;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        Value result = null;
        double newUncertainty;

        if (args[1].isUndefined())
            result = UndefinedValue.instance;
        else {

            if (args[1].isInteger())
                newUncertainty = ((IntegerValue) args[1]).value();
            else
                newUncertainty = ((RealValue) args[1]).value();

            result = new URealValue(uRealValue.value(), newUncertainty);
        }

        return result;
    }
}


// --------------------------------------------------------

/* - : UReal -> UReal */
final class Op_ureal_neg extends OpGeneric {
    @Override
    public String name() {
        return "neg";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return uRealValue.neg();
    }
}

// --------------------------------------------------------

/* value : UReal -> Real */
final class Op_ureal_value extends OpGeneric {
    @Override
    public String name() {
        return "value";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return new RealValue(uRealValue.value());
    }
}

// --------------------------------------------------------

/* setValue : UReal -> UReal */
final class Op_ureal_setValue extends OpGeneric {
    @Override
    public String name() {
        return "setValue";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 2 && params[0].isTypeOfUReal() &&
                params[1].isKindOfReal(Type.VoidHandling.EXCLUDE_VOID)) ?
                TypeFactory.mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        double newValue = 0;
        Value result = null;

        if (!args[1].isUndefined()) {
            if (args[1].isInteger())
                newValue = ((IntegerValue) args[1]).value();
            else if (args[1].isReal())
                newValue = ((RealValue) args[1]).value();

            result = new URealValue(newValue, uRealValue.uncertainty());
        }
        else
            result = UndefinedValue.instance;

        return result;
    }
}

// --------------------------------------------------------

/* toReal : UReal -> Real */
final class Op_ureal_toReal extends OpGeneric {
    @Override
    public String name() {
        return "toReal";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return uRealValue.toReal();
    }
}

// --------------------------------------------------------

/* toInteger : UReal -> Integer */
final class Op_ureal_toInteger extends OpGeneric {
    @Override
    public String name() {
        return "toInteger";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkInteger() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return uRealValue.toInteger();
    }
}


// --------------------------------------------------------

/* toUInteger : UReal -> UInteger */
final class Op_ureal_toUInteger extends OpGeneric {
    @Override
    public String name() {
        return "toUInteger";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUInteger() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return uRealValue.toUInteger();
    }
}

// --------------------------------------------------------

/* power : UReal x Integer -> UReal */
/* power : UReal x Real -> UReal */
final class Op_ureal_power extends OpGeneric {
    @Override
    public String name() {
        return "power";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        Type expected = null;

        if (params.length == 2 && ( params[0].isTypeOfUReal() ) &&
                (params[1].isTypeOfInteger() || params[1].isTypeOfReal()))
            expected = TypeFactory.mkUReal();

        return expected;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        URealValue result = null;
        float exponent;

        if (args[1].isInteger())
            exponent = ((IntegerValue) args[1]).value();
        else // Real
            exponent = (float) ((RealValue) args[1]).value();

        result = uRealValue.power(exponent);

        if (Double.isNaN(result.value()) || Double.isInfinite(result.value()))
            throw new ArithmeticException();

        if (Double.isNaN(result.uncertainty()) || Double.isInfinite(result.uncertainty()))
            throw new ArithmeticException();

        return result;
    }
}



// --------------------------------------------------------

/* sqrt : UReal -> UReal */
final class Op_ureal_sqrt extends OpGeneric {
    @Override
    public String name() {
        return "sqrt";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        URealValue result = uRealValue.sqrt();

        if (Double.isNaN(result.value()) || Double.isInfinite(result.uncertainty()))
            throw new ArithmeticException();

        if (Double.isNaN(result.uncertainty()) || Double.isInfinite(result.uncertainty()))
            throw new ArithmeticException();

        return result;
    }
}

// --------------------------------------------------------

/* atan : UReal -> UReal */
final class Op_ureal_atan extends OpGeneric {
    @Override
    public String name() {
        return "atan";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        URealValue result = uRealValue.atan();

        if (Double.isNaN(result.value()) || Double.isInfinite(result.value()))
            throw new ArithmeticException();

        if (Double.isNaN(result.uncertainty()) || Double.isInfinite(result.uncertainty()))
            throw new ArithmeticException();

        return result;
    }
}

// --------------------------------------------------------

/* sin : UReal -> UReal */
final class Op_ureal_sin extends OpGeneric {
    @Override
    public String name() {
        return "sin";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return uRealValue.sin();
    }
}


/* cos : UReal -> UReal */
final class Op_ureal_cos extends OpGeneric {
    @Override
    public String name() {
        return "cos";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        return uRealValue.cos();
    }
}

// --------------------------------------------------------

/* tan : UReal -> UReal */
final class Op_ureal_tan extends OpGeneric {
    @Override
    public String name() {
        return "tan";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        URealValue result = uRealValue.tan();

        // FIXME: refractorize after studing better the case.
        if (Double.isNaN(result.value()) || Double.isInfinite(result.value()))
            throw new ArithmeticException();

        if (Double.isNaN(result.uncertainty()) || Double.isInfinite(result.uncertainty()))
            throw new ArithmeticException();

        return result;
    }
}

// --------------------------------------------------------

/* asin : UReal -> UReal */
final class Op_ureal_asin extends OpGeneric {
    @Override
    public String name() {
        return "asin";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        URealValue result = uRealValue.asin();

        if (Double.isNaN(result.value()) || Double.isInfinite(result.value()))
            throw new ArithmeticException();

        if (Double.isNaN(result.uncertainty()) || Double.isInfinite(result.uncertainty()))
            throw new ArithmeticException();

        return result;
    }
}

// --------------------------------------------------------

/* acos : UReal -> UReal */
final class Op_ureal_acos extends OpGeneric {
    @Override
    public String name() {
        return "acos";
    }

    @Override
    public int kind() {
        return OPERATION;
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type params[]) {
        return (params.length == 1 && params[0].isTypeOfUReal()) ? TypeFactory
                .mkUReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        URealValue uRealValue = URealValue.valueOf(args[0]);
        URealValue result = uRealValue.acos();

        if (Double.isNaN(result.value()) || Double.isInfinite(result.value()))
            throw new ArithmeticException();

        if (Double.isNaN(result.uncertainty()) || Double.isInfinite(result.uncertainty()))
            throw new ArithmeticException();

        return result;
    }
}
