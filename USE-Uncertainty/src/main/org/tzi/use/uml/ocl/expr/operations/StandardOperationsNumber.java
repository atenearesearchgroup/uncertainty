package org.tzi.use.uml.ocl.expr.operations;

import atenearesearchgroup.uncertainty.uDataTypes.UReal;
import org.tzi.use.uml.ocl.expr.EvalContext;
import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.Type.VoidHandling;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.type.UncertainType;
import org.tzi.use.uml.ocl.value.*;

import com.google.common.collect.Multimap;

import java.util.Objects;
import java.util.Optional;

class StandardOperationsNumber {
	public static void registerTypeOperations(Multimap<String, OpGeneric> opmap) {
		// operations on Integer and Real
        OpGeneric.registerOperation(new Op_number_add(), opmap);
        OpGeneric.registerOperation(new Op_number_sub(), opmap);
        OpGeneric.registerOperation(new Op_number_mult(), opmap);
        OpGeneric.registerOperation(new Op_number_unaryminus(), opmap);
        OpGeneric.registerOperation(new Op_number_div(), opmap); 
        OpGeneric.registerOperation(new Op_number_unaryplus(), opmap); 
        OpGeneric.registerOperation(new Op_number_max(), opmap);
        OpGeneric.registerOperation(new Op_number_min(), opmap);
        OpGeneric.registerOperation(new Op_number_less(), opmap); 
        OpGeneric.registerOperation(new Op_number_greater(), opmap);
        OpGeneric.registerOperation(new Op_number_lessequal(), opmap); 
        OpGeneric.registerOperation(new Op_number_greaterequal(), opmap);
        OpGeneric.registerOperation(new Op_number_toString(), opmap);
        
        // Real
        OpGeneric.registerOperation(new Op_real_abs(), opmap);
        OpGeneric.registerOperation(new Op_real_floor(), opmap); 
        OpGeneric.registerOperation(new Op_real_round(), opmap); 
        
        // Integer
        OpGeneric.registerOperation(new Op_integer_abs(), opmap); 
        OpGeneric.registerOperation(new Op_integer_mod(), opmap); 
        OpGeneric.registerOperation(new Op_integer_idiv(), opmap);
	}
}

//--------------------------------------------------------
//
//Integer, Real and UReal operations.
//
//--------------------------------------------------------

/**
* This class is only used for +, *, -, max, min on Integers and Reals.
*/
abstract class ArithOperation extends OpGeneric {
	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public Type matches(Type params[]) {
		if (params.length == 2) {
			if (params[0].isTypeOfInteger() && params[1].isTypeOfInteger())
				return TypeFactory.mkInteger();
			else if (isArgIntegerOrReal(params[0]) && isArgIntegerOrReal(params[1]))
				return TypeFactory.mkReal();
			else if (params[0].getLeastCommonSupertype(params[1]).isTypeOfUInteger())
				return TypeFactory.mkUInteger();
			else if (params[0].isKindOfNumber(VoidHandling.INCLUDE_VOID)
					&& params[1].isKindOfNumber(VoidHandling.INCLUDE_VOID))
				return TypeFactory.mkUReal();
		}
		return null;
	}

	protected boolean isArgIntegerOrReal(Type arg) {
		return arg.isTypeOfInteger() || arg.isTypeOfReal();
	}

	protected boolean isValueIntegerOrReal(Value arg) {
		return arg.isInteger() || arg.isReal();
	}

}

//--------------------------------------------------------
/* + : Integer x Integer -> Integer */
/* + : Real x Integer -> Real */
/* + : Integer x Real -> Real */
/* + : Real x Real -> Real */
/* + : Integer x UReal -> UReal */
/* + : UReal x Integer -> UReal */
/* + : Real x UReal -> UReal */
/* + : UReal x Real -> UReal */
/* + : UReal x UReal -> UReal */
final class Op_number_add extends ArithOperation {
	@Override
	public String name() {
		return "+";
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result;

		Type common = args[0].type().getLeastCommonSupertype(args[1].type());

		if (common.isTypeOfInteger()) {
			result = evalResultInteger(args);
		}
		else if (common.isTypeOfReal()) {
			result = evalResultReal(args);
		}
		else if (common.isTypeOfUInteger()) {

			if (args[0].isUInteger())
				result = ((UIntegerValue) args[0]).add(args[1]);
			else
				result = ((UIntegerValue) args[1]).add(args[0]);
		}
		else
			result = evalResultUReal(args);

		return result;
	}

	private Value evalResultUReal(Value[] args) {
		Value result;
		URealValue a, b;

		a = URealValue.valueOf(args[0]);
		b = URealValue.valueOf(args[1]);

		return a.add(b);
	}

	private Value evalResultReal(Value[] args) {
		double d1;
		double d2;
		if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return new RealValue(d1 + d2);
	}

	private Value evalResultInteger(Value[] args) {
		int res = ((IntegerValue) args[0]).value()
				+ ((IntegerValue) args[1]).value();
		return IntegerValue.valueOf(res);
	}
}

//--------------------------------------------------------

/* - : Integer x Integer -> Integer */
/* - : Real x Integer -> Real */
/* - : Integer x Real -> Real */
/* - : Real x Real -> Real */
/* - : Integer x UReal -> UReal */
/* - : UReal x Integer -> UReal */
/* - : Real x UReal -> UReal */
/* - : UReal x Real -> UReal */
/* - : UReal x UReal -> UReal */
final class Op_number_sub extends ArithOperation {
	@Override
	public String name() {
		return "-";
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result;

		Type common = args[0].type().getLeastCommonSupertype(args[1].type());

		if (common.isTypeOfInteger()) {
			result = evalResultInteger(args);
		}
		else if (common.isTypeOfReal()) {
			result = evalResultReal(args);
		}
		else if (common.isTypeOfUInteger()) {

			if (args[0].isUInteger())
				result = ((UIntegerValue) args[0]).minus(args[1]);
			else
				result = ((UIntegerValue) args[1]).minus(args[0]).neg();
		}
		else
			result = evalResultUReal(args);

		return result;
	}

	private Value evalResultUReal(Value[] args) {
		URealValue a, b, result;

		a = URealValue.valueOf(args[0]);
		b = URealValue.valueOf(args[1]);

		return a.minus(b);
	}

	private Value evalResultReal(Value[] args) {
		double d1;
		double d2;
		if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return new RealValue(d1 - d2);
	}

	private Value evalResultInteger(Value[] args) {
		int res = ((IntegerValue) args[0]).value()
				- ((IntegerValue) args[1]).value();
		return IntegerValue.valueOf(res);
	}


}

//--------------------------------------------------------

/* * : Integer x Integer -> Integer */
/* * : Real x Integer -> Real */
/* * : Integer x Real -> Real */
/* * : Real x Real -> Real */
/* + : Integer x UReal -> UReal */
/* + : UReal x Integer -> UReal */
/* + : Real x UReal -> UReal */
/* + : UReal x Real -> UReal */
/* + : UReal x UReal -> UReal */
final class Op_number_mult extends ArithOperation {
	@Override
	public String name() {
		return "*";
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result;

		Type common = args[0].type().getLeastCommonSupertype(args[1].type());

		if (common.isTypeOfInteger()) {
			result = evalResultInteger(args);
		}
		else if (common.isTypeOfReal()) {
			result = evalResultReal(args);
		}
		else if (common.isTypeOfUInteger()) {

			if (args[0].isUInteger())
				result = ((UIntegerValue) args[0]).mult(args[1]);
			else
				result = ((UIntegerValue) args[1]).mult(args[0]);
		}
		else
			result = evalResultUReal(args);

		return result;
	}

	private Value evalResultUReal(Value[] args) {
		Value result;
		URealValue a, b;

		a = URealValue.valueOf(args[0]);
		b = URealValue.valueOf(args[1]);

		return a.mult(b);
	}

	private Value evalResultReal(Value[] args) {
		double d1;
		double d2;
		if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return new RealValue(d1 * d2);
	}

	private Value evalResultInteger(Value[] args) {
		int res = ((IntegerValue) args[0]).value()
				* ((IntegerValue) args[1]).value();
		return IntegerValue.valueOf(res);
	}
}

// --------------------------------------------------------

/* / : Number x Number -> Real */
/*     Number x UReal -> UReal */
final class Op_number_div extends OpGeneric {
	@Override
	public String name() {
		return "/";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		Type type = null;
		boolean bothNumerical = false;
		boolean someOfThemIsUncertainty = false;

		if (params.length == 2) {
			bothNumerical = params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID) && params[1].isKindOfNumber(VoidHandling.EXCLUDE_VOID);
			someOfThemIsUncertainty = params[0] instanceof UncertainType || params[1] instanceof UncertainType;

			if (bothNumerical)

				if (someOfThemIsUncertainty)
					type = TypeFactory.mkUReal();
				else
					type = TypeFactory.mkReal();

		}

		return type;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result;

		if (resultType.isTypeOfUReal()) {
			Type common = args[0].type().getLeastCommonSupertype(args[1].type());

			if (common.isTypeOfUInteger())
				result = evalUIntegerResult(args);
			else
				result = evalURealResult(args);

		}
		else
			result = evalRealResult(args);

		return result;
	}

	private Value evalUIntegerResult(Value [] args) {
		URealValue result = null;

		result = UIntegerValue.valueOf(args[0]).divideByR(args[1]);

		if (Double.isInfinite(result.value()) || Double.isNaN(result.value()))
			throw new ArithmeticException();

		if (Double.isInfinite(result.uncertainty()) || Double.isNaN(result.uncertainty()))
			throw new ArithmeticException();

		return result;
	}

	private Value evalURealResult(Value[] args) {
		URealValue a, b;
		URealValue result;

		a = URealValue.valueOf(args[0]);
		b = URealValue.valueOf(args[1]);
		result = a.divideBy(b);

		if (Double.isInfinite(result.value()) || Double.isNaN(result.value()))
			throw new ArithmeticException();

		if (Double.isInfinite(result.uncertainty()) || Double.isNaN(result.uncertainty()))
			throw new ArithmeticException();

		return result;
	}

	private Value evalRealResult(Value[] args) {
		double d1;
		double d2;
		if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		double res = d1 / d2;
		// make special values resulting in undefined
		if (Double.isNaN(res) || Double.isInfinite(res))
			throw new ArithmeticException();
		return new RealValue(res);
	}
}

// --------------------------------------------------------

/* abs : Real -> Real */
final class Op_real_abs extends OpGeneric {
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
		return (params.length == 1 && params[0].isTypeOfReal()) ? TypeFactory
				.mkReal() : null;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		double d1 = ((RealValue) args[0]).value();
		return new RealValue(Math.abs(d1));
	}
}

// --------------------------------------------------------

/* abs : Integer -> Integer */
final class Op_integer_abs extends OpGeneric {
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
		return (params.length == 1 && params[0].isTypeOfInteger()) ? TypeFactory
				.mkInteger() : null;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		int i1 = ((IntegerValue) args[0]).value();
		return IntegerValue.valueOf(Math.abs(i1));
	}
}




// --------------------------------------------------------

/* - : Number -> Number */
final class Op_number_unaryminus extends OpGeneric {
	@Override
	public String name() {
		return "-";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		return (params.length == 1 && params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID)) ? params[0] : null;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value res;

		if (args[0].isInteger()) {
			int i = ((IntegerValue) args[0]).value();
			res = IntegerValue.valueOf(-i);
		}
		else if (args[0].isReal()) {
			double d = ((RealValue) args[0]).value();
			res = new RealValue(-d);
		}
		else if (args[0].isUInteger()) {
			res = ((UIntegerValue) args[0]).neg();
		}
		else {
			URealValue ur = (URealValue) args[0];
			res = ur.neg();
		}

		return res;
	}
}

// --------------------------------------------------------

/* + : Number -> Number */
final class Op_number_unaryplus extends OpGeneric {
	@Override
	public String name() {
		return "+";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		return (params.length == 1 && params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID)) ? params[0] : null;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		// nop
		return args[0];
	}
}

// --------------------------------------------------------

/* floor : Real -> Integer */
/* floor : Integer -> Integer */
/* floor : UReal -> UReal */
final class Op_real_floor extends OpGeneric {
	@Override
	public String name() {
		return "floor";
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
		Type result = null;

		if (params.length == 1) {

			if (params[0].isTypeOfUReal())
				result = TypeFactory.mkUReal();
			else if (params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID))
				result = TypeFactory.mkInteger();

		}

		return result;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value value;

		if (args[0].isUReal()) {
			URealValue uRealValue = ((URealValue) args[0]);
			value = uRealValue.floor();
		}
		else {
			double d1;
			if (args[0].isInteger())
				d1 = ((IntegerValue) args[0]).value();
			else
				d1 = ((RealValue) args[0]).value();

			value = IntegerValue.valueOf((int) Math.floor(d1));
		}

		return value;
	}
}

// --------------------------------------------------------

/* round : Real -> Integer */
/* round : Integer -> Integer */
/* round : UReal -> UReal */
final class Op_real_round extends OpGeneric {
	@Override
	public String name() {
		return "round";
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
		Type result = null;

		if (params.length == 1) {


			if (params[0].isTypeOfUReal())
				result = TypeFactory.mkUReal();
			else if (params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID))
				result = TypeFactory.mkInteger();

		}

		return result;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result;

		if (args[0].isUReal()) {
			URealValue uRealValue = (URealValue) args[0];
			result = uRealValue.round();
		}
		else {
			double d1;
			if (args[0].isInteger())
				d1 = ((IntegerValue) args[0]).value();
			else
				d1 = ((RealValue) args[0]).value();

			result = IntegerValue.valueOf((int) Math.round(d1));
		}

		return result;
	}
}

// --------------------------------------------------------

/* max : Integer x Integer -> Integer */
/* max : Integer x Real -> Real */
/* max : Integer x UReal -> UReal */
/* max : Real x Integer -> Real */
/* max : Real x Real -> Real */
/* max : Real x UReal -> UReal */
/* max : UReal x UReal -> UReal */
/* max : UReal x Real -> UReal */
/* max : UReal x Integer -> UReal */
/* max : UReal x Real -> UReal */
final class Op_number_max extends ArithOperation {
	@Override
	public String name() {
		return "max";
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
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value value = null;

		if (args[0].isInteger() && args[1].isInteger()) {
			value = evalIntegerResult(args);
		}
		else if (isValueIntegerOrReal(args[0]) && isValueIntegerOrReal(args[1])){
			value = evalRealResult(args);
		}
		else { // UReal x (Integer + Real + UReal) or (Integer + Real + UReal) x UReal
			value = evalURealResult(args);
		}

		return value;
	}

	private Value evalURealResult(Value[] args) {
		URealValue result, ur1, ur2;

		ur1 = URealValue.valueOf(args[0]);
		ur2 = URealValue.valueOf(args[1]);

		return ur1.max(ur2);
	}

	private Value evalRealResult(Value[] args) {
		double d1;
		double d2;
		if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return new RealValue(Math.max(d1, d2));
	}

	private Value evalIntegerResult(Value[] args) {
		int res = Math.max(((IntegerValue) args[0]).value(),
				((IntegerValue) args[1]).value());
		return IntegerValue.valueOf(res);
	}
}

// --------------------------------------------------------

/* min : Integer x Integer -> Integer */
/* min : Integer x Real -> Real */
/* min : Integer x UReal -> UReal */
/* min : Real x Integer -> Real */
/* min : Real x Real -> Real */
/* min : Real x UReal -> UReal */
/* min : UReal x UReal -> UReal */
/* min : UReal x Real -> UReal */
/* min : UReal x Integer -> UReal */
/* min : UReal x Real -> UReal */
final class Op_number_min extends ArithOperation {
	@Override
	public String name() {
		return "min";
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
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value value = null;

		if (args[0].isInteger() && args[1].isInteger()) {
			value = evalIntegerResult(args);
		}
		else if (isValueIntegerOrReal(args[0]) && isValueIntegerOrReal(args[1])){
			value = evalRealResult(args);
		}
		else { // UReal x (Integer + Real + UReal) or (Integer + Real + UReal) x UReal
			value = evalURealResult(args);
		}

		return value;
	}

	private Value evalURealResult(Value[] args) {
		URealValue result, ur1, ur2;

		ur1 = URealValue.valueOf(args[0]);
		ur2 = URealValue.valueOf(args[1]);

		return ur1.min(ur2);
	}

	private Value evalRealResult(Value[] args) {
		double d1;
		double d2;
		if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return new RealValue(Math.min(d1, d2));
	}

	private Value evalIntegerResult(Value[] args) {
		int res = Math.min(((IntegerValue) args[0]).value(),
				((IntegerValue) args[1]).value());
		return IntegerValue.valueOf(res);
	}
}

// --------------------------------------------------------

/* mod : Integer x Integer -> Integer */
final class Op_integer_mod extends OpGeneric {
	@Override
	public String name() {
		return "mod";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		return (params.length == 2 && params[0].isTypeOfInteger() && params[1]
				.isTypeOfInteger()) ? TypeFactory.mkInteger() : null;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		int i1 = ((IntegerValue) args[0]).value();
		int i2 = ((IntegerValue) args[1]).value();
		return IntegerValue.valueOf(i1 % i2);
	}
}

// --------------------------------------------------------

/* idiv : Integer x Integer -> Integer */
final class Op_integer_idiv extends OpGeneric {
	@Override
	public String name() {
		return "div";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		return (params.length == 2 && params[0].isTypeOfInteger() && params[1]
				.isTypeOfInteger()) ? TypeFactory.mkInteger() : null;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		int i1 = ((IntegerValue) args[0]).value();
		int i2 = ((IntegerValue) args[1]).value();
		return IntegerValue.valueOf(i1 / i2);
	}
}

// --------------------------------------------------------

/* < : Number x Number -> Boolean */
/* < : Number x UncertaintyNumber -> UBoolean */
final class Op_number_less extends OpGeneric {
	@Override
	public String name() {
		return "<";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		boolean bothKindOfNumber = false;
		boolean someOfthemUncertainty = false;
		Type result = null;

		if (params.length == 2) {
			bothKindOfNumber = params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID) && params[1].isKindOfNumber(VoidHandling.EXCLUDE_VOID);
			someOfthemUncertainty = params[0] instanceof UncertainType || params[1] instanceof UncertainType;

			if (bothKindOfNumber && someOfthemUncertainty)
				result = TypeFactory.mkUBoolean();
			else if (bothKindOfNumber)
				result = TypeFactory.mkBoolean();

		}

		return result;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result = null;

		if (resultType.isTypeOfBoolean())
			result = evalBooleanResult(args);
		else
			result = evalUBooleanResult(args);

		return result;
	}

	public UBooleanValue evalUBooleanResult(Value [] args) {
		URealValue a = URealValue.valueOf(args[0]);

		return a.lt(args[1]);
	}

	public BooleanValue evalBooleanResult(Value [] args) {
		double d1;
		double d2;

		if (args[0].isUnlimitedNatural())
			d1 = ((UnlimitedNaturalValue) args[0]).value();
		else if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isUnlimitedNatural())
			d2 = ((UnlimitedNaturalValue) args[1]).value();
		else if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return BooleanValue.get(d1 < d2);
	}
}

// --------------------------------------------------------

/* > : Number x Number -> Boolean */
final class Op_number_greater extends OpGeneric {
	@Override
	public String name() {
		return ">";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		boolean bothKindOfNumber = false;
		boolean someOfthemUncertainty = false;
		Type result = null;

		if (params.length == 2) {
			bothKindOfNumber = params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID) && params[1].isKindOfNumber(VoidHandling.EXCLUDE_VOID);
			someOfthemUncertainty = params[0] instanceof UncertainType || params[1] instanceof UncertainType;

			if (bothKindOfNumber && someOfthemUncertainty)
				result = TypeFactory.mkUBoolean();
			else if (bothKindOfNumber)
				result = TypeFactory.mkBoolean();

		}

		return result;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result = null;

		if (resultType.isTypeOfBoolean())
			result = evalBooleanResult(args);
		else
			result = evalUBooleanResult(args);

		return result;
	}

	public UBooleanValue evalUBooleanResult(Value [] args) {
		URealValue a = URealValue.valueOf(args[0]);

		return a.gt(args[1]);
	}

	public BooleanValue evalBooleanResult(Value [] args) {
		double d1;
		double d2;
		if (args[0].isUnlimitedNatural())
			d1 = ((UnlimitedNaturalValue) args[0]).value();
		else if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isUnlimitedNatural())
			d2 = ((UnlimitedNaturalValue) args[1]).value();
		else if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return BooleanValue.get(d1 > d2);
	}
}

// --------------------------------------------------------

/* <= : Number x Number -> Boolean */
final class Op_number_lessequal extends OpGeneric {
	@Override
	public String name() {
		return "<=";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		boolean bothKindOfNumber = false;
		boolean someOfthemUncertainty = false;
		Type result = null;

		if (params.length == 2) {
			bothKindOfNumber = params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID) && params[1].isKindOfNumber(VoidHandling.EXCLUDE_VOID);
			someOfthemUncertainty = params[0] instanceof UncertainType || params[1] instanceof UncertainType;

			if (bothKindOfNumber && someOfthemUncertainty)
				result = TypeFactory.mkUBoolean();
			else if (bothKindOfNumber)
				result = TypeFactory.mkBoolean();

		}

		return result;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result = null;

		if (resultType.isTypeOfBoolean())
			result = evalBooleanResult(args);
		else
			result = evalUBooleanResult(args);

		return result;
	}

	public UBooleanValue evalUBooleanResult(Value [] args) {
		URealValue a = URealValue.valueOf(args[0]);

		return a.le(args[1]);
	}

	public BooleanValue evalBooleanResult(Value [] args) {
		double d1;
		double d2;

		if (args[0].isUnlimitedNatural())
			d1 = ((UnlimitedNaturalValue) args[0]).value();
		else if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isUnlimitedNatural())
			d2 = ((UnlimitedNaturalValue) args[1]).value();
		else if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return BooleanValue.get(d1 <= d2);
	}
}

// --------------------------------------------------------

/* >= : Number x Number -> Boolean */
final class Op_number_greaterequal extends OpGeneric {
	@Override
	public String name() {
		return ">=";
	}

	@Override
	public int kind() {
		return OPERATION;
	}

	@Override
	public boolean isInfixOrPrefix() {
		return true;
	}

	@Override
	public Type matches(Type params[]) {
		boolean bothKindOfNumber = false;
		boolean someOfthemUncertainty = false;
		Type result = null;

		if (params.length == 2) {
			bothKindOfNumber = params[0].isKindOfNumber(VoidHandling.EXCLUDE_VOID) && params[1].isKindOfNumber(VoidHandling.EXCLUDE_VOID);
			someOfthemUncertainty = params[0] instanceof UncertainType || params[1] instanceof UncertainType;

			if (bothKindOfNumber && someOfthemUncertainty)
				result = TypeFactory.mkUBoolean();
			else if (bothKindOfNumber)
				result = TypeFactory.mkBoolean();

		}

		return result;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		Value result = null;

		if (resultType.isTypeOfBoolean())
			result = evalBooleanResult(args);
		else
			result = evalUBooleanResult(args);

		return result;
	}

	public UBooleanValue evalUBooleanResult(Value [] args) {
		URealValue a = URealValue.valueOf(args[0]);

		return a.ge(args[1]);
	}

	public BooleanValue evalBooleanResult(Value [] args) {
		double d1;
		double d2;

		if (args[0].isUnlimitedNatural())
			d1 = ((UnlimitedNaturalValue) args[0]).value();
		else if (args[0].isInteger())
			d1 = ((IntegerValue) args[0]).value();
		else
			d1 = ((RealValue) args[0]).value();

		if (args[1].isUnlimitedNatural())
			d2 = ((UnlimitedNaturalValue) args[1]).value();
		else if (args[1].isInteger())
			d2 = ((IntegerValue) args[1]).value();
		else
			d2 = ((RealValue) args[1]).value();
		return BooleanValue.get(d1 >= d2);
	}
}

/* toString : Number -> String */
final class Op_number_toString extends OpGeneric {
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
	public Type matches(Type params[]) {
		return (params.length == 1 && params[0]
				.isKindOfNumber(VoidHandling.EXCLUDE_VOID)) ? TypeFactory
				.mkString() : null;
	}

	@Override
	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		return new StringValue(args[0].toString());
	}
}