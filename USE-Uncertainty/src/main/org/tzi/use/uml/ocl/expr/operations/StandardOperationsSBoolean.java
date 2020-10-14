package org.tzi.use.uml.ocl.expr.operations;

import com.google.common.collect.Multimap;
import org.tzi.use.uml.ocl.expr.EvalContext;
import org.tzi.use.uml.ocl.type.Type;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.RealValue;
import org.tzi.use.uml.ocl.value.SBooleanValue;
import org.tzi.use.uml.ocl.value.StringValue;
import org.tzi.use.uml.ocl.value.Value;

public enum StandardOperationsSBoolean {

    // Projection : SBoolean -> Real
    PROYECTION(new OpGeneric() {

        @Override
        public String name() {
            return "projection";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.projection();
        }
    }),

    // belief : SBoolean -> Real
    BELIEF(new OpGeneric() {

        @Override
        public String name() {
            return "belief";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.belief();
        }
    }),

    // disbelief : SBoolean -> Real
    DISBELIEF(new OpGeneric() {

        @Override
        public String name() {
            return "disbelief";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.disbelief();
        }
    }),



    // baseRate : SBoolean -> Real
    BASE_RATE(new OpGeneric() {

        @Override
        public String name() {
            return "baseRate";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.baseRate();
        }
    }),



    // uncertainty : SBoolean -> Real
    UNCERTAINTY(new OpGeneric() {

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
        public Type matches(Type[] params) {
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.uncertainty();
        }
    }),

    // uncertaintyMaximized : SBoolean -> SBoolean
    UNCERTAINTY_MAXIMIZED(new OpGeneric() {

        @Override
        public String name() {
            return "uncertaintyMaximized";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.uncertaintyMaximized();
        }
    }),

    // projectiveDistance : SBoolean x SBoolean -> SBoolean
    PROJECTIVE_DISTANCE(new OpGeneric() {

        @Override
        public String name() {
            return "projectiveDistance";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID)
                    && params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.projectiveDistance(sboolB);
        }
    }),

    // conjuntiveCertainty: SBoolean x SBoolean -> SBoolean
    CONJUNCTIVE_CERTAINTY(new OpGeneric() {

        @Override
        public String name() {
            return "conjunctiveCertainty";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID)
                    && params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.conjunctiveCertainty(sboolB);
        }
    }),

    // degreeOfConflict: SBoolean x SBoolean -> SBoolean
    DEGREE_OF_CONFLICT(new OpGeneric() {

        @Override
        public String name() {
            return "degreeOfConflict";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID)
                    && params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.degreeOfConflict(sboolB);
        }
    }),

    // deduceY: SBoolean x SBoolean x SBoolean -> SBoolean
    DEDUCE_Y(new OpGeneric() {

        @Override
        public String name() {
            return "deduceY";
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
            return params.length == 3 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID)
                    && params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID)
                    && params[2].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            SBooleanValue sboolC = SBooleanValue.valueOf(args[2]);
            return sboolA.deduceY(sboolB, sboolC);
        }
    }),

    // toUBoolean: SBoolean -> UBoolean
    TO_UBOOLEAN(new OpGeneric() {

        @Override
        public String name() {
            return "toUBoolean";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkUBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.toUBoolean();
        }
    }),

    // toString: SBoolean -> String
    TO_STRING(new OpGeneric() {

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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkString() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return new StringValue(sbool.toString());
        }
    }),

    // not: SBoolean -> SBoolean
    NOT(new OpGeneric() {

        @Override
        public String name() {
            return "not";
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
        public Type matches(Type[] params) {
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.not();
        }
    }),

    // and: SBoolean x SBoolean -> SBoolean
    AND(new OpGeneric() {

        @Override
        public String name() {
            return "and";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.and(sboolB);
        }
    }),

    // or: SBoolean x SBoolean -> SBoolean
    OR(new OpGeneric() {

        @Override
        public String name() {
            return "or";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.or(sboolB);
        }
    }),

    // or: SBoolean x SBoolean -> SBoolean
    XOR(new OpGeneric() {

        @Override
        public String name() {
            return "xor";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.xor(sboolB);
        }
    }),

    // or: SBoolean x SBoolean -> SBoolean
    EQUIVALENT(new OpGeneric() {

        @Override
        public String name() {
            return "equivalent";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.equivalent(sboolB);
        }
    }),

    // implies: SBoolean x SBoolean -> SBoolean
    IMPLIES(new OpGeneric() {

        @Override
        public String name() {
            return "implies";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.implies(sboolB);
        }
    }),
    
    
 // getRelativeWeight : SBoolean -> Real
    GETRELATIVEWEIGHT(new OpGeneric() {

        @Override
        public String name() {
            return "getRelativeWeight";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.getRelativeWeight();
        }
    }),
    
    // isAbsolute : SBoolean -> Boolean
    ISABSOLUTE(new OpGeneric() {

        @Override
        public String name() {
            return "isAbsolute";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.isAbsolute();
        }
    }),
    
    // isVacuous : SBoolean -> Boolean
    ISVACUOUS(new OpGeneric() {

        @Override
        public String name() {
            return "isVacuous";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.isVacuous();
        }
    }),
    
    // isCertain : SBoolean x Real -> Boolean
    ISCERTAIN(new OpGeneric() {

        @Override
        public String name() {
            return "isCertain";
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
            return params.length == 2 &&
            	params[0].isTypeOfSBoolean() &&
            	params[1].isKindOfReal(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            RealValue threshold = RealValue.valueOf(args[1]);
            return sbool.isCertain(threshold);
        }
    }), 
    
    // isDogmatic : SBoolean -> Boolean
    ISDOGMATIC(new OpGeneric() {

        @Override
        public String name() {
            return "isDogmatic";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.isDogmatic();
        }
    }),
    
    // isMaximizedUncertainty : SBoolean -> Boolean
    ISMAXIMIZEDUNCERTAINTY(new OpGeneric() {

        @Override
        public String name() {
            return "isMaximizedUncertainty";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.isMaximizedUncertainty();
        }
    }),
    
    // isUncertain : SBoolean -> Boolean
    ISUNCERTAIN(new OpGeneric() {

        @Override
        public String name() {
            return "isUncertain";
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
            return params.length == 2 &&
            	params[0].isTypeOfSBoolean() &&
            	params[1].isKindOfReal(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            RealValue threshold = RealValue.valueOf(args[1]);
            return sbool.isUncertain(threshold);
        }
    }),
    
    // uncertainOpinion : SBoolean -> SBoolean
    UNCERTAINOPINION(new OpGeneric() {

        @Override
        public String name() {
            return "uncertainOpinion";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.uncertainOpinion();
        }
    }),
    
    // certainty : SBoolean -> Real
    CERTAINTY(new OpGeneric() {

        @Override
        public String name() {
            return "certainty";
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
            return params.length == 1 && params[0].isTypeOfSBoolean() ?
                    TypeFactory.mkReal() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sbool = SBooleanValue.valueOf(args[0]);
            return sbool.certainty();
        }
    }),
    
    // minimumBeliefFusion : SBoolean x SBoolean -> SBoolean
    MINIMUMBELIEFFUSION(new OpGeneric() {

        @Override
        public String name() {
            return "minimumBeliefFusion";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.minimumBeliefFusion(sboolB);
        }
    }),
    
    
    // majorityBeliefFusion : SBoolean x SBoolean -> SBoolean
    MAJORITYBELIEFFUSION(new OpGeneric() {

        @Override
        public String name() {
            return "majorityBeliefFusion";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.majorityBeliefFusion(sboolB);
        }
    }),
    
    // averageBeliefFusion : SBoolean x SBoolean -> SBoolean
    AVERAGEBELIEFFUSION(new OpGeneric() {

        @Override
        public String name() {
            return "averageBeliefFusion";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.averageBeliefFusion(sboolB);
        }
    }),
    
    
    // cumulativeBeliefFusion : SBoolean x SBoolean -> SBoolean
    CUMULATIVEBELIEFFUSION(new OpGeneric() {

        @Override
        public String name() {
            return "cumulativeBeliefFusion";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.cumulativeBeliefFusion(sboolB);
        }
    }),
    
    // epistemicCumulativeBeliefFusion : SBoolean x SBoolean -> SBoolean
    EPISTEMICCUMULATIVEBELIEFFUSION(new OpGeneric() {

        @Override
        public String name() {
            return "epistemicCumulativeBeliefFusion";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.epistemicCumulativeBeliefFusion(sboolB);
        }
    }),
    
    // weightedBeliefFusion : SBoolean x SBoolean -> SBoolean
    WEIGHTEDBELIEFFUSION(new OpGeneric() {

        @Override
        public String name() {
            return "weightedBeliefFusion";
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
            return params.length == 2 && params[0].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) &&
                    params[1].isKindOfSBoolean(Type.VoidHandling.EXCLUDE_VOID) ?
                    TypeFactory.mkSBoolean() : null;
        }

        @Override
        public Value eval(EvalContext ctx, Value[] args, Type resultType) {
            SBooleanValue sboolA = SBooleanValue.valueOf(args[0]);
            SBooleanValue sboolB = SBooleanValue.valueOf(args[1]);
            return sboolA.weightedBeliefFusion(sboolB);
        }
    }),
    
    ;


    // Stuff
    private OpGeneric op;

    StandardOperationsSBoolean(OpGeneric op) {
        this.op = op;
    }

    public OpGeneric getOp() {
        return op;
    }

    public static void registerTypeOperations(Multimap<String, OpGeneric> opmap) {

        for (StandardOperationsSBoolean op : StandardOperationsSBoolean.values())
            OpGeneric.registerOperation(op.getOp(), opmap);

    }

}
