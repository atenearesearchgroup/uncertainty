package org.tzi.use.uml.ocl.expr;

import junit.framework.TestCase;
import org.tzi.use.uml.mm.ModelFactory;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.*;
import org.tzi.use.uml.sys.MSystem;
import org.tzi.use.uml.sys.MSystemState;

public class UCollectionExpOpTest extends TestCase {
    private MSystemState state;
    private Evaluator e;
    private EvalContext ctx;

    /**
     * Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}
     */
    private Expression setA;

    /**
     * Set{}
     */
    private Expression emptySet;


    protected void setUp() throws Exception {
        state = new MSystem(new ModelFactory().createModel("Test")).state();
        e = new Evaluator();
        ctx = new SimpleEvalContext(state, state, new VarBindings());

        // Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}
        Value[] args1 = new Value[]{
                new URealValue(2, 0.5),
                IntegerValue.valueOf(1),
                new RealValue(2.5),
                new RealValue(3.2),
                new URealValue(3.5, 0.25)};
        setA = new ExpressionWithValue(new SetValue(TypeFactory.mkUReal(), args1));

        // Set{}
        emptySet = new ExpressionWithValue(new SetValue(TypeFactory.mkUReal()));
    }

    /**
     * Testing includes : A non-uncertainty argument with uncertainty set must have an UBoolean result.
     */

    public void testIncludeArgNonUncertainty() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                setA,
                new ExpConstReal(2.5)
        };
        Expression op = ExpStdOp.create("includes", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));
    }

    /**
     * Testing includes : A uncertainty argument with uncertainty set must have an UBolean result.
     * @throws ExpInvalidException
     */

    public void testIncludeArgUncertainty() throws ExpInvalidException {
        Expression [] args = new Expression [] {
                setA, new ExpConstUReal(new ExpConstReal(2), new ExpConstReal(0.2))
        };
        Expression op = ExpStdOp.create("includes", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5850213691), e.eval(op, state));
    }

    /**
     * Testing includes : If there are multiple values that overlap the argument in the set, the result must be an
     *                    Uboolean with the highest probability.
     * @throws ExpInvalidException
     */

    public void testIncludeElemWithMultipleUncertaintyMatch() throws ExpInvalidException {
        Expression expSet = new ExpressionWithValue(
                new SetValue(TypeFactory.mkUReal(),
                        new Value [] {
                                new URealValue(2, 0.35),
                                new URealValue(2, 0.3)
                        }));
        Expression [] args = new Expression [] {
                expSet, new ExpConstUReal(
                                new ExpConstReal(2),
                                new ExpConstReal(0.29))};
        Expression op = ExpStdOp.create("includes", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.9835952315), e.eval(op, state));
    }

    /**
     * Testing includesAll : Set{}->includesAll(UReal(2, 0.2)) -> UBoolean(false, 0)
     * @throws ExpInvalidException
     */

    public void testIncludesAllEmptySet() throws ExpInvalidException {
        Expression expSetArg = new ExpressionWithValue(
                new SetValue(TypeFactory.mkUReal(), new Value [] { new URealValue(2, 0.2)})
        );
        Expression [] args = new Expression[]{ emptySet, expSetArg };
        Expression op = ExpStdOp.create("includesAll", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));
    }

    /**
     * Testing includesAll : Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}->includesAll(Set{2.5, UReal(3.5, 0.25)})
     *                       -> UBoolean(true, 1) : UBoolean
     * @throws ExpInvalidException
     */

    public void testIncludesAllContainingAllElements() throws ExpInvalidException {
        Expression expSetArg = new ExpressionWithValue(
                new SetValue(
                        TypeFactory.mkUReal(),
                        new Value [] {
                                new URealValue(3.5, 0.25),
                                new RealValue(2.5)
                        }
                )
        );
        Expression [] args = new Expression[] {
                setA, expSetArg
        };
        Expression op = ExpStdOp.create("includesAll", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));
    }

    /**
     * Testing includesAll : Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}->includesAll(Set{2.5, UReal(3.5, 0.15)})
     *                       -> UBoolean(true, 0.5745923526) : UBoolean
     * @throws ExpInvalidException
     */
    public void testIncludesAllWithOverlappingElements() throws ExpInvalidException {
        Expression expSetArg = new ExpressionWithValue(
                new SetValue(
                        TypeFactory.mkUReal(),
                        new Value [] {
                                new URealValue(3.5, 0.15),
                                new URealValue(2, 0.3)
                        }
                )
        );
        Expression [] args = new Expression[] {
                setA, expSetArg
        };
        Expression op = ExpStdOp.create("includesAll", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5745923526), e.eval(op, state));
    }

    /**
     * Testing excludes : Set{}->excludes(x) always UBoolean(true, 1)
     * @throws ExpInvalidException
     */

    public void testExcludesEmptyCollection() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                emptySet,
                new ExpressionWithValue(
                        new URealValue(2, 3)
                )
        };
        Expression op = ExpStdOp.create("excludes", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));
    }

    /**
     * Testing excludes : Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}->excludes(UReal(59,2)
     *                    -> UBoolean(true, 1.0) : UBoolean
     * @throws ExpInvalidException
     */

    public void testExcludesNonExistingValue() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                setA, new ExpressionWithValue(new URealValue(59, 2))
        };
        Expression op = ExpStdOp.create("excludes", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));
    }

    /**
     * Testing excludes : Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}->excludes(UReal(3.5,0.25)
     *                    -> UBoolean(true, 0.0) : UBoolean
     * @throws ExpInvalidException
     */
    public void testExcludesExistingValue() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                setA, new ExpressionWithValue(new URealValue(3.5, 0.25))
        };
        Expression op = ExpStdOp.create("excludes", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));
    }

    /**
     * Testing excludes : Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}->excludes(UReal(3,2)
     *                    -> UBoolean(true, 0.4746189139) : UBoolean
     * @throws ExpInvalidException
     */

    public void testExcludesOverlappingValue() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                setA, new ExpressionWithValue(new URealValue(3, 2))
        };
        Expression op = ExpStdOp.create("excludes", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.4746189139), e.eval(op, state));
    }

    /**
     * Testing excludesAll : Set{}->excludesAll(Set{UReal(2,3)})
     *                       -> UBoolean(true, 1.0)
     * @throws ExpInvalidException
     */


    public void testExcludesAllEmptySet() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                emptySet,
                new ExpressionWithValue(new SetValue(TypeFactory.mkUReal(),
                        new Value[] {
                                new URealValue(2, 3)
                        }
                ))
        };
        Expression op = ExpStdOp.create("excludesAll", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));
    }

    /**
     * Testing excludesAll : Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}->excludesAll(Set{UReal(59,3), UReal(-310,9)}
     *                       -> UBoolean(true, 1.0)
     * @throws ExpInvalidException
     */

    public void testExcludesAllSetDifferents() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                setA,
                new ExpressionWithValue(new SetValue(TypeFactory.mkUReal(),
                        new Value[] {
                                new URealValue(59, 3),
                                new URealValue(-310, 9)
                        }
                ))
        };
        Expression op = ExpStdOp.create("excludesAll", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));
    }

    /**
     * Testing excludesAll : Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}->excludesAll(Set{UReal(3.5, 0.25),1.2})
     *                       -> UBoolean(false, 1)
     * @throws ExpInvalidException
     */

    public void testExcludesAllArgumentIsASubset() throws ExpInvalidException {
        Expression [] args = new Expression[] {
                setA,
                new ExpressionWithValue(new SetValue(TypeFactory.mkUReal(),
                        new Value[] {
                                new URealValue(3.5, 0.25),
                                new RealValue(1.2)
                        }
                ))
        };
        Expression op = ExpStdOp.create("excludesAll", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));
    }


    public void testUCount() throws ExpInvalidException {
        Expression [] args = new Expression[]{
                new ExpressionWithValue(new SetValue(TypeFactory.mkUReal(),
                        new Value[] {
                                new RealValue(2),
                                new URealValue(2, 3)
                        })),
                new ExpressionWithValue(new URealValue(2, 3))
        };
        Expression op = ExpStdOp.create("uCount", args);
        Value v = e.eval(op, state);
    }

}
