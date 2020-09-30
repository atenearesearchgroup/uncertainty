package org.tzi.use.uml.ocl.expr.operations;

import org.tzi.use.uml.ocl.expr.EvalContext;
import org.tzi.use.uml.ocl.expr.ExpInvalidException;
import org.tzi.use.uml.ocl.expr.ExpStdOp;
import org.tzi.use.uml.ocl.expr.Expression;
import org.tzi.use.uml.ocl.expr.ExpressionWithValue;
import org.tzi.use.uml.ocl.type.*;
import org.tzi.use.uml.ocl.type.TupleType.Part;
import org.tzi.use.uml.ocl.type.Type.VoidHandling;
import org.tzi.use.uml.ocl.value.*;
import org.tzi.use.util.Log;
import org.tzi.use.util.StringUtil;

import com.google.common.collect.Multimap;

public class StandardOperationsCollection {
	public static void registerTypeOperations(Multimap<String, OpGeneric> opmap) {
		// operations on Collection
		OpGeneric.registerOperation(new Op_collection_size(), opmap);
		OpGeneric.registerOperation(new Op_collection_includes(), opmap);
		OpGeneric.registerOperation(new Op_collection_excludes(), opmap);
		OpGeneric.registerOperation(new Op_collection_count(), opmap);
		OpGeneric.registerOperation(new Op_collection_includesAll(), opmap);
		OpGeneric.registerOperation(new Op_collection_excludesAll(), opmap);
		OpGeneric.registerOperation(new Op_collection_isEmpty(), opmap);
		OpGeneric.registerOperation(new Op_collection_notEmpty(), opmap);
		OpGeneric.registerOperation(new Op_collection_max(), opmap);
		OpGeneric.registerOperation(new Op_collection_min(), opmap);
		OpGeneric.registerOperation(new Op_collection_sum(), opmap);
		OpGeneric.registerOperation(new Op_collection_product(), opmap);
		OpGeneric.registerOperation(new Op_collection_asSet(), opmap);
		OpGeneric.registerOperation(new Op_collection_asSequence(), opmap);
		OpGeneric.registerOperation(new Op_collection_asOrderedSet(), opmap);
		OpGeneric.registerOperation(new Op_collection_asBag(), opmap);
		OpGeneric.registerOperation(new Op_collection_flatten(), opmap);

		OpGeneric.registerOperation(new Op_collection_single(), opmap); // USE specific

		// Uncertainty operations
		OpGeneric.registerOperation(new Op_collection_uCount(), opmap);
		OpGeneric.registerOperation(new Op_collection_uCountC(), opmap);
		
	}
}

// --------------------------------------------------------
//
// Collection operations.
//
// --------------------------------------------------------

/* size : Collection(T) -> Integer */
final class Op_collection_size extends OpGeneric {
	public String name() {
		return "size";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		return (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) ? TypeFactory
				.mkInteger() : null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined()) return UndefinedValue.instance;
		
		CollectionValue coll = (CollectionValue) args[0];
		return IntegerValue.valueOf(coll.size());
	}
}

// --------------------------------------------------------

/* includes : Collection(T2) x T1 -> Boolean, with T2 <= T1 */
final class Op_collection_includes extends OpGeneric {
	public String name() {
		return "includes";
	}

	// may test for undefined being an element of the collection
	public int kind() {
		return SPECIAL;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 2 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {			
			CollectionType coll = (CollectionType) params[0];
            Type elemType = params[1].getLeastCommonSupertype(coll.elemType());

            if (elemType != null)

                if (!(elemType instanceof UncertainType || params[1] instanceof UncertainValue))
				    return TypeFactory.mkBoolean();
                else
                    return TypeFactory.mkUBoolean();

		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined())
			return BooleanValue.FALSE;
		
		CollectionValue coll = (CollectionValue) args[0];

		if (resultType.isTypeOfBoolean()) {
            boolean res = coll.includes(args[1]);
            return BooleanValue.get(res);
        }
		else {
		    UBooleanValue res = coll.uIncludes(args[1]);
		    return res;
        }
	}
	
	@Override
	public String checkWarningUnrelatedTypes(Expression args[]) {
		CollectionType  col = (CollectionType) args[0].type();
		Type commonElementType = col.elemType().getLeastCommonSupertype(args[1].type());
		
		if (!(col.elemType().isTypeOfOclAny() || args[1].type().isTypeOfOclAny()) && commonElementType.isTypeOfOclAny()) {
			return "Expression " + StringUtil.inQuotes(this.stringRep(args, "")) + 
					 " will always evaluate to false, " + StringUtil.NEWLINE +
					 "because the element type " + StringUtil.inQuotes(col.elemType()) + 
					 " and the parameter type " + StringUtil.inQuotes(args[1].type()) + " are unrelated.";
		}
		
		return null;
	}
}

// --------------------------------------------------------

/* excludes : Collection(T2) x T1 -> Boolean, with T2 <= T1 */
final class Op_collection_excludes extends OpGeneric {
	public String name() {
		return "excludes";
	}

	// may test for undefined being an element of the collection
	public int kind() {
		return SPECIAL;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 2 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType coll = (CollectionType) params[0];
			Type leastCommonSupertype = params[1].getLeastCommonSupertype(coll.elemType());

			if (leastCommonSupertype != null) {

				if (leastCommonSupertype instanceof UncertainType)
					return TypeFactory.mkUBoolean();
				else
					return TypeFactory.mkBoolean();

			}
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined())
			return BooleanValue.FALSE;
		CollectionValue coll = (CollectionValue) args[0];

		if (resultType.isTypeOfBoolean()) {
			boolean res = !coll.includes(args[1]);
			return BooleanValue.get(res);
		}
		else
			return coll.uExcludes(args[1]);
	}
	
	@Override
	public String checkWarningUnrelatedTypes(Expression args[]) {
		CollectionType  col = (CollectionType) args[0].type();
		Type commonElementType = col.elemType().getLeastCommonSupertype(args[1].type());
		
		if (!(col.elemType().isTypeOfOclAny() || args[1].type().isTypeOfOclAny()) && commonElementType.isTypeOfOclAny()) {
			return "Expression " + StringUtil.inQuotes(this.stringRep(args, "")) + 
					 " will always evaluate to true, " + StringUtil.NEWLINE +
					 "because the element type " + StringUtil.inQuotes(col.elemType()) + 
					 " and the parameter type " + StringUtil.inQuotes(args[1].type()) + " are unrelated.";
		}
		
		return null;
	}
}

// --------------------------------------------------------

/* count : Collection(T) x T -> Integer */
final class Op_collection_count extends OpGeneric {
	public String name() {
		return "count";
	}

	// may count occurrences of undefined in the collection
	public int kind() {
		return SPECIAL;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 2 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType coll = (CollectionType) params[0];
			if (params[1].getLeastCommonSupertype(coll.elemType()) != null)
				return TypeFactory.mkInteger();
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined())
			return IntegerValue.valueOf(0);
		CollectionValue coll = (CollectionValue) args[0];
		int res = coll.count(args[1]);
		return IntegerValue.valueOf(res);
	}
	
	@Override
	public String checkWarningUnrelatedTypes(Expression args[]) {
		CollectionType  col = (CollectionType) args[0].type();
		Type commonElementType = col.elemType().getLeastCommonSupertype(args[1].type());
		
		if (!(col.elemType().isTypeOfOclAny() || args[1].type().isTypeOfOclAny()) && commonElementType.isTypeOfOclAny()) {
			return "Expression " + StringUtil.inQuotes(this.stringRep(args, "")) + 
					 " will always evaluate to true, " + StringUtil.NEWLINE +
					 "because the element type " + StringUtil.inQuotes(col.elemType()) + 
					 " and the parameter type " + StringUtil.inQuotes(args[1].type()) + " are unrelated.";
		}
		
		return null;
	}
}

// --------------------------------------------------------

/* uCount : Collection(T) x T -> Integer */
final class Op_collection_uCount extends OpGeneric {
	public String name() {
		return "uCount";
	}

	// may count occurrences of undefined in the collection
	public int kind() {
		return SPECIAL;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 2 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType coll = (CollectionType) params[0];
			if (params[1].getLeastCommonSupertype(coll.elemType()) != null)
				return TypeFactory.mkInteger();
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined())
			return IntegerValue.valueOf(0);
		CollectionValue coll = (CollectionValue) args[0];
		int res = coll.uCountC(args[1], 0.5);
		return IntegerValue.valueOf(res);
	}

	@Override
	public String checkWarningUnrelatedTypes(Expression args[]) {
		CollectionType  col = (CollectionType) args[0].type();
		Type commonElementType = col.elemType().getLeastCommonSupertype(args[1].type());

		if (!(col.elemType().isTypeOfOclAny() || args[1].type().isTypeOfOclAny()) && commonElementType.isTypeOfOclAny()) {
			return "Expression " + StringUtil.inQuotes(this.stringRep(args, "")) +
					" will always evaluate to true, " + StringUtil.NEWLINE +
					"because the element type " + StringUtil.inQuotes(col.elemType()) +
					" and the parameter type " + StringUtil.inQuotes(args[1].type()) + " are unrelated.";
		}

		return null;
	}
}

// --------------------------------------------------------

/* uCountC : Collection(T) x T -> Integer */
final class Op_collection_uCountC extends OpGeneric {

	public String name() {
		return "uCountC";
	}

	// may count occurrences of undefined in the collection
	public int kind() {
		return SPECIAL;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 3 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID) &&
		    params[2].isKindOfReal(VoidHandling.EXCLUDE_VOID))
		{
			CollectionType coll = (CollectionType) params[0];
			if (params[1].getLeastCommonSupertype(coll.elemType()) != null)
				return TypeFactory.mkInteger();
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		double confident;

		// get the confident...
		if (args[2] instanceof IntegerValue)
			confident = ((IntegerValue) args[2]).value();
		else
			confident = ((RealValue) args[2]).value();

		// assert confident between 0 and 1
		if (confident < 0 || confident > 1)
			throw new RuntimeException("Expression '" + name() + "' needs confident between 0 and 1, found " + confident);

		if (args[0].isUndefined())
			return IntegerValue.valueOf(0);

		CollectionValue coll = (CollectionValue) args[0];
		int res = coll.uCountC(args[1], confident);
		return IntegerValue.valueOf(res);
	}

	@Override
	public String checkWarningUnrelatedTypes(Expression args[]) {
		CollectionType  col = (CollectionType) args[0].type();
		Type commonElementType = col.elemType().getLeastCommonSupertype(args[1].type());

		if (!(col.elemType().isTypeOfOclAny() || args[1].type().isTypeOfOclAny()) && commonElementType.isTypeOfOclAny()) {
			return "Expression " + StringUtil.inQuotes(this.stringRep(args, "")) +
					" will always evaluate to true, " + StringUtil.NEWLINE +
					"because the element type " + StringUtil.inQuotes(col.elemType()) +
					" and the parameter type " + StringUtil.inQuotes(args[1].type()) + " are unrelated.";
		}

		return null;
	}
}

// --------------------------------------------------------

/* includesAll : Collection(T) x Collection(T) -> Boolean */
final class Op_collection_includesAll extends OpGeneric {
	public String name() {
		return "includesAll";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 2 && 
			params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID) && 
			params[1].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType coll1 = (CollectionType) params[0];
			CollectionType coll2 = (CollectionType) params[1];
			Type commonElementType = coll2.getLeastCommonSupertype(coll1);

			if (commonElementType != null) {
				Type elemType = ((CollectionType) commonElementType).elemType();

				if (!(elemType instanceof UncertainType))
					return TypeFactory.mkBoolean();
				else
					return TypeFactory.mkUBoolean();
			}
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue coll1 = (CollectionValue) args[0];
		CollectionValue coll2 = (CollectionValue) args[1];
		Value result = null;

		if (resultType.isTypeOfBoolean()) {
			boolean res = coll1.includesAll(coll2);
			result = BooleanValue.get(res);
		}
		else
			result = coll1.uIncludesAll(coll2);

		return result;
	}
	
	@Override
	public String checkWarningUnrelatedTypes(Expression args[]) {
		CollectionType col1 = (CollectionType) args[0].type();
		CollectionType col2 = (CollectionType) args[1].type();
		
		Type elemType1 = col1.elemType();
		Type elemType2 = col2.elemType();
		
		Type commonElementType = elemType1.getLeastCommonSupertype(elemType2);
		
		if (!(elemType1.isTypeOfOclAny() || elemType2.isTypeOfOclAny()) && commonElementType.isTypeOfOclAny()) {
			return "Expression " + StringUtil.inQuotes(this.stringRep(args, "")) + 
					 " will always evaluate to false, " + StringUtil.NEWLINE +
					 "because the element types " + StringUtil.inQuotes(elemType1) + 
					 " and " + StringUtil.inQuotes(elemType2) + " are unrelated.";
		}
		
		return null;
	}
}

// --------------------------------------------------------

/* excludesAll : Collection(T) x Collection(T) -> Boolean */
final class Op_collection_excludesAll extends OpGeneric {
	public String name() {
		return "excludesAll";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 2 && 
			params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID) &&
			params[1].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			
			CollectionType coll1 = (CollectionType) params[0];
			CollectionType coll2 = (CollectionType) params[1];
			Type leastCommonSupertype = coll2.getLeastCommonSupertype(coll1);

			if (leastCommonSupertype != null) {
				Type elemType = ((CollectionType) leastCommonSupertype).elemType();

				if (!(elemType instanceof UncertainType))
					return TypeFactory.mkBoolean();
				else
					return TypeFactory.mkUBoolean();
			}
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue coll1 = (CollectionValue) args[0];
		CollectionValue coll2 = (CollectionValue) args[1];

		if (resultType.isTypeOfBoolean()) {
			boolean res = coll1.excludesAll(coll2);
			return BooleanValue.get(res);
		}
		else
			return coll1.uExcludesAll(coll2);
	}
	
	@Override
	public String checkWarningUnrelatedTypes(Expression args[]) {
		CollectionType col1 = (CollectionType) args[0].type();
		CollectionType col2 = (CollectionType) args[1].type();
		
		Type elemType1 = col1.elemType();
		Type elemType2 = col2.elemType();
		
		Type commonElementType = elemType1.getLeastCommonSupertype(elemType2);
		
		if (!(elemType1.isTypeOfOclAny() || elemType2.isTypeOfOclAny()) && commonElementType.isTypeOfOclAny()) {
			return "Expression " + StringUtil.inQuotes(this.stringRep(args, "")) + 
					 " will always evaluate to true, " + StringUtil.NEWLINE +
					 "because the element type " + StringUtil.inQuotes(elemType1) + 
					 " and the parameter type " + StringUtil.inQuotes(elemType2) + " are unrelated.";
		}
		
		return null;
	}
}

// --------------------------------------------------------

/* isEmpty : Collection(T) -> Boolean */
final class Op_collection_isEmpty extends OpGeneric {
	public String name() {
		return "isEmpty";
	}

	public int kind() {
		return SPECIAL;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		return (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) ? TypeFactory
				.mkBoolean() : null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined()) return UndefinedValue.instance;
		
		CollectionValue coll = (CollectionValue) args[0];
		return BooleanValue.get(coll.isEmpty());
	}
}

// --------------------------------------------------------

/* notEmpty : Collection(T) -> Boolean */
final class Op_collection_notEmpty extends OpGeneric {
	public String name() {
		return "notEmpty";
	}

	public int kind() {
		return SPECIAL;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		return (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) ? TypeFactory
				.mkBoolean() : null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined()) return UndefinedValue.instance;
		CollectionValue coll = (CollectionValue) args[0];
		return BooleanValue.get(!coll.isEmpty());
	}
}

// --------------------------------------------------------

/* sum : Collection(T) -> T */
final class Op_collection_sum extends OpGeneric {
	public String name() {
		return "sum";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType c = (CollectionType) params[0];
			if (c.elemType().isTypeOfInteger())
				return TypeFactory.mkInteger();
			else if (c.elemType().isTypeOfReal())
				return TypeFactory.mkReal();
			else if (c.elemType().isTypeOfUInteger())
				return TypeFactory.mkUInteger();
			else if (c.elemType().isTypeOfUReal())
				return TypeFactory.mkUReal();
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue coll = (CollectionValue) args[0];
		Value result = null;

		if (resultType.isTypeOfInteger())
			result = evalIntegerResult(coll);
		else if (resultType.isTypeOfReal())
			result = evalRealResult(coll);
		else if (resultType.isTypeOfUInteger())
			result = evalUIntegerResult(coll);
		else
			result = evalURealResult(coll);

		return result;
	}

	private Value evalUIntegerResult(CollectionValue coll) {
		UIntegerValue uisum = new UIntegerValue(0, 0);
		UIntegerValue aux;

		for (Value v : coll) {

			if (v.isUndefined())
				return UndefinedValue.instance;
			else {
				aux = UIntegerValue.valueOf(v);
				uisum = new UIntegerValue(uisum.getuInteger().add(aux.getuInteger()));
			}
		}

		return uisum;
	}

	private Value evalURealResult(CollectionValue coll) {
		URealValue ursum = new URealValue(0, 0);
		URealValue aux;

		for (Value v : coll) {

			if (v.isUndefined())
				return UndefinedValue.instance;
			else
				ursum = ursum.add(v);

		}

		return ursum;
	}

	private Value evalRealResult(CollectionValue coll) {
		double rsum = 0.0;

		for (Value v : coll) {
			if (v.isUndefined())
				return UndefinedValue.instance;
			if (v.isInteger())
				rsum += ((IntegerValue) v).value();
			else
				rsum += ((RealValue) v).value();
		}
		return new RealValue(rsum);
	}

	private Value evalIntegerResult(CollectionValue coll) {
		int isum = 0;
		for (Value v : coll) {
			if (v.isUndefined())
				return UndefinedValue.instance;
			isum += ((IntegerValue) v).value();
		}
		return IntegerValue.valueOf(isum);
	}
}

/* product : Collection(T) x Collection(T2) -> Set(Tuple(first: T, second : T2)) */
final class Op_collection_product extends OpGeneric {
	public String name() {
		return "product";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 2 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)
				&& params[1].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType c = (CollectionType) params[0];
			CollectionType c2 = (CollectionType) params[1];

			Part[] parts = new Part[2];
			parts[0] = new Part(0, "first", c.elemType());
			parts[1] = new Part(1, "second", c2.elemType());

			TupleType tupleType = TypeFactory.mkTuple(parts);
			return TypeFactory.mkSet(tupleType);
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		if (args[0].isUndefined() || args[1].isUndefined())
			return UndefinedValue.instance;

		CollectionValue col1 = (CollectionValue) args[0];
		CollectionValue col2 = (CollectionValue) args[1];

		return col1.product(col2);
	}
}

// --------------------------------------------------------

/* flatten : C1(C2(T)) -> C1(T) */
final class Op_collection_flatten extends OpGeneric {
	public String name() {
		return "flatten";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType c1 = (CollectionType) params[0];
			if (c1.elemType().isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
				CollectionType c2 = (CollectionType) c1.elemType();
				return c1.createCollectionType(c2.elemType());
			} else {
				return c1;
			}
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue coll = (CollectionValue) args[0];
		return coll.flatten(resultType);
	}
}

/* asBag : Collection(T) -> Bag(T) */
final class Op_collection_asBag extends OpGeneric {
	public String name() {
		return "asBag";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType col = (CollectionType) params[0];
			return TypeFactory.mkBag(col.elemType());
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue col = (CollectionValue) args[0];
		return col.asBag();
	}
}

/* asSet : Collection(T) -> Set(T) */
final class Op_collection_asSet extends OpGeneric {
	public String name() {
		return "asSet";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType col = (CollectionType) params[0];
			return TypeFactory.mkSet(col.elemType());
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue col = (CollectionValue) args[0];
		return col.asSet();
	}
}

/* asSequence : Collection(T) -> Sequence(T) */
final class Op_collection_asSequence extends OpGeneric {
	public String name() {
		return "asSequence";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType col = (CollectionType) params[0];
			return TypeFactory.mkSequence(col.elemType());
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue col = (CollectionValue) args[0];
		return col.asSequence();
	}
}

/* asOrderedSet : Collection(T) -> OrderedSet(T) */
final class Op_collection_asOrderedSet extends OpGeneric {
	public String name() {
		return "asOrderedSet";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType col = (CollectionType) params[0];
			return TypeFactory.mkOrderedSet(col.elemType());
		}
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue col = (CollectionValue) args[0];
		return col.asOrderedSet();
	}
}

/* max : Collection(T) -> T */
final class Op_collection_max extends OpGeneric {
	public String name() {
		return "max";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType t = (CollectionType)params[0];

			// Check if basic type supports max operation
			if (ExpStdOp.exists("max", new Type[]{t.elemType(), t.elemType()}))
				return t.elemType();
		}
		
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue col = (CollectionValue) args[0];
		
		Value max = UndefinedValue.instance;
		boolean first = true;
		
		for (Value v : col) {
			if (first) {
				max = v;
				first = false;
			} else {
				try {
					ExpStdOp op = ExpStdOp.create("max", 
							new Expression[]{new ExpressionWithValue(max), new ExpressionWithValue(v)});
					max = op.eval(ctx);
				} catch (ExpInvalidException e) {
					Log.error(e);
					return UndefinedValue.instance;
				}
			}
		}
		
		return max;
	}
}

/* min : Collection(T) -> T */
final class Op_collection_min extends OpGeneric {
	public String name() {
		return "min";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType t = (CollectionType)params[0];

			// Check if basic type supports min operation
			if (ExpStdOp.exists("min", new Type[]{t.elemType(), t.elemType()}))
				return t.elemType();
		}
		
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue col = (CollectionValue) args[0];
		
		Value max = UndefinedValue.instance;
		boolean first = true;
		
		for (Value v : col) {
			if (first) {
				max = v;
				first = false;
			} else {
				try {
					ExpStdOp op = ExpStdOp.create("min", 
							new Expression[]{new ExpressionWithValue(max), new ExpressionWithValue(v)});
					max = op.eval(ctx);
				} catch (ExpInvalidException e) {
					Log.error(e);
					return UndefinedValue.instance;
				}
			}
		}
		
		return max;
	}	
}
/* single : Collection(T) -> T */
final class Op_collection_single extends OpGeneric {
	public String name() {
		return "single";
	}

	public int kind() {
		return OPERATION;
	}

	public boolean isInfixOrPrefix() {
		return false;
	}

	public Type matches(Type params[]) {
		if (params.length == 1 && params[0].isKindOfCollection(VoidHandling.EXCLUDE_VOID)) {
			CollectionType t = (CollectionType)params[0];
			return t.elemType();
		}
		
		return null;
	}

	public Value eval(EvalContext ctx, Value[] args, Type resultType) {
		CollectionValue col = (CollectionValue) args[0];
		
		Value res = UndefinedValue.instance;
		
		if (col.size() == 1) {
			res = col.collection().iterator().next();
		}
		
		return res;
	}
}