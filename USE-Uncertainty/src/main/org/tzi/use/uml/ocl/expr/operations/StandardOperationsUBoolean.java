package org.tzi.use.uml.ocl.expr.operations;

import com.google.common.collect.Multimap;
import org.tzi.use.uml.ocl.expr.EvalContext;
import org.tzi.use.uml.ocl.expr.Expression;
import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.*;

public class StandardOperationsUBoolean {

    public static void registerTypeOperations(Multimap<String, OpGeneric> opmap) {
        // operations on UBoolean
        OpGeneric.registerOperation(new Op_uBoolean_toBoolean(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_toString(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_value(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_confidence(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_setValue(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_equalsC(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_and(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_or(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_not(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_implies(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_toBooleanC(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_setUncertainty(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_xor(), opmap);
        OpGeneric.registerOperation(new Op_uBoolean_equivalent(), opmap);
    }
}
// --------------------------------------------------------
//
// UBoolean operations.
//
// --------------------------------------------------------

// toBoolean : UBoolean -> Boolean
final class Op_uBoolean_toBoolean extends OpGeneric {

    @Override
    public String name() {
        return "toBoolean";
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
    public Type matches(Type[] params) {
        return params.length == 1 && params[0].isTypeOfUBoolean() ?
                TypeFactory.mkBoolean() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        Value result = null;

        // In context of Set(UBoolean), a Boolean may be applied an UBoolean operation (like an expression
        // witch can be either Boolean or UBoolean). Then, has to be casted to UBoolean.
        if (args[0].isUBoolean()) {
            UBooleanValue ub = (UBooleanValue) args[0];
            result = ub.toBoolean();
        }
        else if (args[0].isBoolean()) {
            result = UBooleanValue.valueOf(((BooleanValue) args[0]).value(), 1);
        }
        else
            result = UndefinedValue.instance;

        return result;
    }
}

// toString : UBoolean -> String
final class Op_uBoolean_toString extends OpGeneric {

    @Override
    public String name() {
        return "toString";
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
    public Type matches(Type[] params) {
        return params.length == 1 && params[0].isTypeOfUBoolean() ?
                TypeFactory.mkString() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {

        StringBuilder sb = new StringBuilder("UBoolean(");
        double probability = UBooleanValue.valueOf(args[0]).probability();

        if (probability < 0.5)
            sb.append("false, ").append(1 - probability).append(")");
        else
            sb.append("true, ").append(probability).append(")");

        return new StringValue(sb.toString());
    }
}

// toBoolean : UBoolean -> Boolean
// toBooleanC : UBoolean -> Boolean
final class Op_uBoolean_toBooleanC extends OpGeneric {

    @Override
    public String name() {
        return "toBooleanC";
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
    public Type matches(Type[] params) {
        return params.length == 2 && params[0].isTypeOfUBoolean() && params[1].isKindOfReal(Type.VoidHandling.EXCLUDE_VOID) ?
                TypeFactory.mkBoolean() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        Value result = BooleanValue.FALSE; // Pre-set result
        double confience;
        UBooleanValue left = UBooleanValue.valueOf(args[0]);

        if (args[1].isReal())
            confience = ((RealValue) args[1]).value();
        else
            confience = ((IntegerValue) args[1]).value();

        if (confience < 0 || confience > 1)
            result = UndefinedValue.instance;
        else if (left.probability() >= confience)
            result = BooleanValue.TRUE;

        return result;
    }
}

// value : UBoolean -> Real
final class Op_uBoolean_value extends OpGeneric {

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
    public Type matches(Type[] params) {
        return params.length == 1 && params[0].isTypeOfUBoolean() ?
                TypeFactory.mkBoolean() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        return BooleanValue.TRUE;
    }
}



// setValue : UBoolean -> Real
final class Op_uBoolean_setValue extends OpGeneric {

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
    public Type matches(Type[] params) {
        return params.length == 2 && params[0].isTypeOfUBoolean() &&
                params[1].isTypeOfBoolean() ?
                TypeFactory.mkUBoolean() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        UBooleanValue ub = (UBooleanValue) args[0];
        BooleanValue b = (BooleanValue) args[1];

        return UBooleanValue.valueOf(b.value(), ub.probability());
    }
}


// confidence : UBoolean -> Real
final class Op_uBoolean_confidence extends OpGeneric {

    @Override
    public String name() {
        return "confidence";
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
    public Type matches(Type[] params) {
        return params.length == 1 && params[0].isTypeOfUBoolean() ?
                TypeFactory.mkReal() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        UBooleanValue ub = UBooleanValue.valueOf(args[0]);
        return new RealValue(ub.probability());
    }
}
// setConfidence : UBoolean x Real -> UBoolean
final class Op_uBoolean_setUncertainty extends OpGeneric {

    @Override
    public String name() {
        return "setConfidence";
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
    public Type matches(Type[] params) {
        return params.length == 2 && params[0].isTypeOfUBoolean() &&
                params[1].isKindOfReal(Type.VoidHandling.EXCLUDE_VOID)?
                TypeFactory.mkUBoolean() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        UBooleanValue ub = UBooleanValue.valueOf(args[0]);
        double uncertainty;
        Value result;

        if (args[1].isReal())
            uncertainty = ((RealValue) args[1]).value();
        else
            uncertainty = ((IntegerValue) args[1]).value();

        if (uncertainty >= 0 && uncertainty <= 1)
            result = UBooleanValue.valueOf(ub.value(), uncertainty);
        else
            result = UndefinedValue.instance;

        return result;
    }
}

// equalsC : UBoolean x UBoolean x (Integer + Real) -> Boolean
final class Op_uBoolean_equalsC extends OpGeneric {

    @Override
    public String name() {
        return "equalsC";
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
    public Type matches(Type[] params) {
        return params.length == 3 && params[0].isTypeOfUBoolean() &&
                params[1].isKindOfUBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                params[2].isKindOfReal(Type.VoidHandling.EXCLUDE_VOID) ?
                TypeFactory.mkBoolean() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        UBooleanValue left, right;
        double c;
        Value result;

        left = UBooleanValue.valueOf(args[0]);

        if (args[2].isReal())
            c = ((RealValue) args[2]).value();
        else
            c = ((IntegerValue) args[2]).value();

        if (c >= 0 && c <= 1)
            result = left.equalsC(args[1], c);
        else
            result = UndefinedValue.instance;

        return result;
    }
}


// and : UBoolean x UBoolean -> UBoolean
final class Op_uBoolean_and extends BooleanOperation {

    @Override
    public String name() {
        return "and";
    }

    @Override
    public boolean isInfixOrPrefix() {
        return true;
    }

    @Override
    public Type matches(Type[] params) {
        return params.length == 2 && params[0].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) &&
                params[1].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) ?
                TypeFactory.mkUBoolean() : null;
    }

    @Override
    public Value eval(EvalContext ctx, Value[] args, Type resultType) {
        throw new RuntimeException("Use evalWithArgs insteed");
    }

    @Override
    public Value evalWithArgs(EvalContext ctx, Expression[] args) {
        Value result = UndefinedValue.instance;
        Value v1 = args[0].eval(ctx), v2 = null;
        UBooleanValue ub1,ub2;

        if (ctx.isEnableEvalTree())
            v2 = args[1].eval(ctx);

        if (v1.isDefined()) {
            ub1 = UBooleanValue.valueOf(v1);

            if (ub1.probability() == 0)
                result = ub1;
            else {
                if (!ctx.isEnableEvalTree())
                    v2 = args[1].eval(ctx);

                ub2 = UBooleanValue.valueOf(v2);

                if (ub2 != null && ub2.probability() == 0)
                    result = ub2;
                else if (ub2 != null)
                    result = ub1.and(ub2);

            }
        }
        else {
            if (!ctx.isEnableEvalTree())
                v2 = args[1].eval(ctx);

            if (v2.isDefined()) {
                ub2 = UBooleanValue.valueOf(v2);

                if (ub2.probability() == 0)
                    result = ub2;

            }
        }



        return result;
    }
}

// or : UBoolean x UBoolean -> UBoolean
final class Op_uBoolean_or extends BooleanOperation {

    @Override
    public String name() {
        return "or";
    }
    @Override
    public boolean isInfixOrPrefix() {
        return true;
    }

    @Override
    public Type matches(Type[] params) {
        return params.length == 2 &&
                params[0].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) &&
                params[1].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) ?
                TypeFactory.mkUBoolean() : null;
    }

    @Override
    public Value evalWithArgs(EvalContext ctx, Expression[] args) {
        Value v1 = args[0].eval(ctx);
        Value v2 = null, result = UndefinedValue.instance;
        UBooleanValue ub1, ub2;

        if (ctx.isEnableEvalTree())
            v2 = args[1].eval(ctx);

        if (v1.isDefined()) {
            ub1 = UBooleanValue.valueOf(v1);

            if (ub1.probability() == 1)
                result = ub1;
            else {
                if (!ctx.isEnableEvalTree())
                    v2 = args[1].eval(ctx);

                ub2 = UBooleanValue.valueOf(v2);

                if (ub2 != null)
                    result = ub1.or(ub2);
            }
        }
        else {
            if (!ctx.isEnableEvalTree())
                v2 = args[1].eval(ctx);

            ub2 = UBooleanValue.valueOf(v2);

            if (ub2.probability() == 1)
                result = ub2;
        }

        return result;
    }
}

// not : UBoolean -> UBoolean
final class Op_uBoolean_not extends BooleanOperation {

    @Override
    public Value evalWithArgs(EvalContext ctx, Expression[] args) {
        Value value = args[0].eval(ctx);
        Value result = UndefinedValue.instance;
        UBooleanValue ub;

        if (value.isDefined()) {
            ub = UBooleanValue.valueOf(value);
            result = ub.not();
        }

        return result;
    }

    @Override
    public String name() {
        return "not";
    }

    @Override
    public boolean isInfixOrPrefix() {
        return true;
    }

    @Override
    public Type matches(Type[] params) {
        return params.length == 1 && params[0].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) ?
                TypeFactory.mkUBoolean() : null;
    }
}

// implies : UBoolean x UBoolean -> UBoolean
final class Op_uBoolean_implies extends BooleanOperation {

    @Override
    public Value evalWithArgs(EvalContext ctx, Expression[] args) {
        Value v1 = args[0].eval(ctx);
        Value v2 = null;
        Value result = UndefinedValue.instance;
        UBooleanValue ub1, ub2;

        if (ctx.isEnableEvalTree())
            v2 = args[1].eval(ctx);

        if (v1.isDefined()) {
            ub1 = UBooleanValue.valueOf(v1);

            // If false, then the result will be UBoolean(true, 1.0).
            if (ub1.probability() == 0)
                result = UBooleanValue.TRUE;
            else {
                if (!ctx.isEnableEvalTree())
                    v2 = args[1].eval(ctx);

                ub2 = UBooleanValue.valueOf(v2);

                if (ub2 != null)
                    result = ub1.implies(ub2);
                // else, result = undefined by default.
            }
        }
        else {
            if (!ctx.isEnableEvalTree())
                v2 = args[1].eval(ctx);

            if (v2.isDefined()) {
                ub2 = UBooleanValue.valueOf(v2);

                if (ub2.probability() == 1)
                    result = ub2;
                // else, result = undefined by default

            }
            // else, result = undefined by default

        }

        return result;
    }

    @Override
    public String name() {
        return "implies";
    }

    @Override
    public boolean isInfixOrPrefix() {
        return true;
    }

    @Override
    public Type matches(Type[] params) {
        return params.length == 2 &&
                params[0].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) &&
                params[1].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) ?
                TypeFactory.mkUBoolean() : null;
    }
}

// xor : UBoolean x UBoolean -> UBoolean
final class Op_uBoolean_xor extends BooleanOperation {


    @Override
    public Value evalWithArgs(EvalContext ctx, Expression[] args) {
        Value result = null;
        UBooleanValue left, right;

        left  = UBooleanValue.valueOf(args[0].eval(ctx));
        right = UBooleanValue.valueOf(args[1].eval(ctx));

        if (left != null && right != null)
            result = left.xor(right);
        else
            result = UndefinedValue.instance;

        return result;
    }

    @Override
    public String name() {
        return "xor";
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type[] params) {
        return params.length == 2 &&
                params[0].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) &&
                params[1].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) ?
                TypeFactory.mkUBoolean() : null;
    }
}

// equivalent : UBoolean x UBoolean -> UBoolean
final class Op_uBoolean_equivalent extends BooleanOperation {


    @Override
    public Value evalWithArgs(EvalContext ctx, Expression[] args) {
        Value result = null;
        UBooleanValue left, right;
        Value a, b;
        boolean resultBoolean;

        a = args[0].eval(ctx);
        b = args[1].eval(ctx);

        resultBoolean = a.isBoolean() && b.isBoolean();
        left  = UBooleanValue.valueOf(args[0].eval(ctx));
        right = UBooleanValue.valueOf(args[1].eval(ctx));

        if (left != null && right != null) {
            result = left.equivalent(right);

            if (resultBoolean)
                result = ((UBooleanValue) result).toBoolean();

        }
        else
            result = UndefinedValue.instance;

        return result;
    }

    @Override
    public String name() {
        return "equivalent";
    }

    @Override
    public boolean isInfixOrPrefix() {
        return false;
    }

    @Override
    public Type matches(Type[] params) {
        Type result = null;

        // There are two argument and they're kind of UBoolean
        if (params.length == 2 &&
                params[0].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) &&
                params[1].isKindOfUBoolean(Type.VoidHandling.INCLUDE_VOID) ) {

            // If both of them are boolean, then the result would be boolean.
            if (params[0].isTypeOfBoolean() && params[1].isTypeOfBoolean())
                result = TypeFactory.mkBoolean();
            else
                result = TypeFactory.mkUBoolean();

        }

        return result;
    }
}