package org.tzi.use.uml.ocl.expr;

import junit.framework.TestCase;
import org.tzi.use.uml.mm.ModelFactory;
import org.tzi.use.uml.ocl.value.BooleanValue;
import org.tzi.use.uml.ocl.value.RealValue;
import org.tzi.use.uml.ocl.value.UBooleanValue;
import org.tzi.use.uml.ocl.value.UndefinedValue;
import org.tzi.use.uml.ocl.value.UndefinedValue;
import org.tzi.use.uml.ocl.value.UBooleanValue;
import org.tzi.use.uml.ocl.value.StringValue;
import org.tzi.use.uml.ocl.value.*;
import org.tzi.use.uml.sys.MSystem;
import org.tzi.use.uml.sys.MSystemState;

public class UBooleanExpOpsTest extends TestCase {
    private MSystemState state;
    private Evaluator e;

    protected void setUp() throws Exception {
        state = new MSystem(new ModelFactory().createModel("Test")).state();
        e = new Evaluator();
    }

    public void testToBoolean() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // UBoolean(true, 0) -> false : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("toBoolean", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // UBoolean(true, 0.49) -> false : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.49)
                )
        };
        op = ExpStdOp.create("toBoolean", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));


        // UBoolean(true, 0.5) -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("toBoolean", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));


        // UBoolean(true, 1) -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("toBoolean", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

    }

    /**
     * Test uncertainty : UBoolaen -> Real
     */

    public void testConfidence() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // UBoolean(true, 0).confidence() -> 0.0 : Real
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("confidence", args);
        assertEquals(op.toString(), new RealValue(0), e.eval(op, state));

        // UBoolean(true, 0.5).confidence() -> 0.5 : Real
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("confidence", args);
        assertEquals(op.toString(), new RealValue(0.5), e.eval(op, state));

        // UBoolean(true, 1).confidence() -> 1.0 : Real
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("confidence", args);
        assertEquals(op.toString(), new RealValue(1), e.eval(op, state));

    }

    /**
     * Test setUncertainty
     */

    public void testSetConfidence() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(true, 0.5).setConfidence(0.5) -> UBoolean(true, 0.5) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstReal(0.5)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5), e.eval(op, state));

        // UBoolean(true, 0.5).setConfidence(0.2) -> UBoolean(true, 0.2) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstReal(0.2)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.2), e.eval(op, state));

        // UBoolean(true, 0.6).setConfidence(0.75) -> UBoolean(true, 0.75) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.6)
                ),
                new ExpConstReal(0.75)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.75), e.eval(op, state));

        // UBoolean(true, 0.6).setConfidence(1) -> UBoolean(true, 1.0) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.6)
                ),
                new ExpConstInteger(1)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

        // UBoolean(false, 0.3).setConfidence(0.4) -> UBoolean(true, 0.4) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.3)
                ),
                new ExpConstReal(0.4)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.4), e.eval(op, state));

        // UBoolean(false, 0.6).setConfidence(0.4) -> UBoolean(true, 0.4) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.6)
                ),
                new ExpConstReal(0.4)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.4), e.eval(op, state));

        // UBoolean(true, 0.5).setConfidence(2) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstInteger(2)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UBoolean(true, 0.5).setConfidence(-5) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstInteger(-5)
        };
        op = ExpStdOp.create("setConfidence", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UBoolean(true, 0.5).setConfidence('testing') -> Undefined operation UBoolean.setConfidence(String)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstString("testing")
        };
        try {
            op = ExpStdOp.create("setConfidence", args);
            fail("ExpInvalidException expected");
        }
        catch(ExpInvalidException ex) {
            // Success
        }
        catch (Exception ex) {
            fail("ExpInvalidException expected");
        }
    }

    public void testValue() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;


        // UBoolean(true, 0.2).value() -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.55).value() -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.55)
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.9).value() -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.9)
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));
    }

    public void testEqualsCBetweenUBooleans() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // UBoolean(true, 0.5).equalsC(UBoolean(true, 0.2), 0.4)
        // -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0.4)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.5).equalsC(UBoolean(true, 0.2), 0.2)
        // -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0.2)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.5).equalsC(UBoolean(true, 0.5), 0)
        // -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstInteger(0)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.5).equalsC(UBoolean(false, 0.4), 0.9)
        // -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.4)
                ),
                new ExpConstReal(0.9)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(false, 0.5).equalsC(UBoolean(true, 0.6), 0.95)
        // -> false : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.5)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.6)
                ),
                new ExpConstReal(0.95)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

    }

    public void testEqualsCUBooleanxBoolean() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // UBoolean(true, 0.5).equalsC(true, 0.9)
        // -> false : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstBoolean(true),
                new ExpConstReal(0.9)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // UBoolean(true, 0.5).equalsC(true, 0.5)
        // -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstBoolean(true),
                new ExpConstReal(0.5)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.5).equalsC(false, 0.9)
        // -> false : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstBoolean(false),
                new ExpConstReal(0.9)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // UBoolean(true, 0.5).equalsC(false, 0.5)
        // -> true : Boolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstBoolean(false),
                new ExpConstReal(0.5)

        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));
    }

    public void testEqualsWrongConfidence() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // UBoolean(true, 0.5).equals(true, 2.0)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstBoolean(true),
                new ExpConstReal(2.0)
        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), UndefinedValue.instance , e.eval(op, state));

        // UBoolean(true, 0.5).equals(true, -0.1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstBoolean(true),
                new ExpConstReal(-0.1)
        };
        op = ExpStdOp.create("equalsC", args);
        assertEquals(op.toString(), UndefinedValue.instance , e.eval(op, state));

    }


    // TESTING AND

    /**
     * Testing and with UBoolean values.
     */
    public void testAndWithUBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(false, 0.5) and UBoolean(false, 0.2) -> UBoolean(true, 0.4)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.5)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.4), e.eval(op, state));

        // UBoolean(false, 0.9) and UBoolean(true, 0.8) -> UBoolean(true, 0.08)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.9)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.8)
                )
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.08), e.eval(op, state));

        // UBoolean(false, 0.55) and UBoolean(true, 0.49) -> UBoolean(true, 0.2695)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.55)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.49)
                )
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.2695), e.eval(op, state));
    }

    /**
     * Testing and with Boolean
     */

    public void testAndWithBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // true and false -> true
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // false and UBoolean(false, 0.49) -> UBoolean(true, 0)
        args = new Expression[] {
                new ExpConstBoolean(false),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.49)
                )
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));


        // UBoolean(false, 0.79) and false -> UBoolean(true, 0)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));


        // UBoolean(false, 0.79) and true -> UBoolean(true, 0.21)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.21), e.eval(op, state));


        // UBoolean(true, 0.79) and true -> UBoolean(true, 0.79)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.79), e.eval(op, state));


    }

    /**
     * Testing and with Undefined
     */

    public void testAndWithUndefined() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // Undefined and Undefined
        args = new Expression[] {
                new ExpUndefined(),
                new ExpUndefined()
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UBoolean(true, 0.9) and Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.9)
                ) ,
                new ExpUndefined()
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // true and Undefined
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpUndefined()
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined and UBoolean(false, 0.9)
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.9)
                )
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined and false
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // Undefined and UBoolean(true, 0) -> UBoolean(true, 0)
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));

        // UBoolean(false, 1) and Undefined -> UBoolean(true, 0)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0)
                ),
                new ExpUndefined()
        };
        op = ExpStdOp.create("and", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));

    }

    /**
     * Test OR operation
     */

    public void testOrWithBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(false, 0.45) or UBoolean(false, 0.76) -> UBoolean(true, 0.658)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.45)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.76)
                )
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.658), e.eval(op, state));

        // UBoolean(false, 0.45) or UBoolean(true, 0.37) -> UBoolean(true, 0.7165)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.45)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.37)
                )
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.7165), e.eval(op, state));

        // UBoolean(true, 0.45) or UBoolean(true, 0.76) -> UBoolean(true, 0.868)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.45)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.76)
                )
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.868), e.eval(op, state));

    }

    public void testORWithBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // true or false -> true
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // false or UBoolean(false, 0.49) -> UBoolean(true, 0.51)
        args = new Expression[] {
                new ExpConstBoolean(false),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.49)
                )
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.51), e.eval(op, state));


        // UBoolean(false, 0.79) or false -> UBoolean(true, 0.21)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.21), e.eval(op, state));


        // UBoolean(true, 0.79) or true -> UBoolean(true, 1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

    }

    public void testORWithUndefined() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // Undefined or Undefined
        args = new Expression[] {
                new ExpUndefined(),
                new ExpUndefined()
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UBoolean(true, 0.9) or Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.9)
                ) ,
                new ExpUndefined()
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // true or Undefined
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpUndefined()
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // Undefined or UBoolean(false, 0.9)
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.9)
                )
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined or false
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined or UBoolean(true, 1)
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

        // UBoolean(false, 1) or Undefined -> UBoolean(true, 1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(1)
                ),
                new ExpUndefined()
        };
        op = ExpStdOp.create("or", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

    }

    /**
     * Test XOR
     */

    public void testXORWithUBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(false, 0.4) xor UBoolean(false, 0.2) -> UBoolean(true, 0.2) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.4)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.2), e.eval(op, state));

        // UBoolean(false, 0.2) xor UBoolean(true, 0.3) -> UBoolean(true, 0.5) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.3)
                )
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5), e.eval(op, state));

        // UBoolean(true, 0.1) xor UBoolean(true, 0.1) -> UBoolean(true, 0.0) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.1)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.1)
                )
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.0), e.eval(op, state));

        // UBoolean(false, 0) xor UBoolean(false, 1) -> UBoolean(true, 1.0) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

    }

    public void testXORWithBoolean() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // true xor false -> true : Boolean
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // false xor UBoolean(false, 0.5) -> UBoolean(true, 0.5) : UBoolean
        args = new Expression[] {
                new ExpConstBoolean(false),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5), e.eval(op, state));

        // UBoolean(false, 0.2) xor false -> UBoolean(true, 0.8) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.8), e.eval(op, state));

        // UBoolean(false, 0.6) xor true  -> UBoolean(true, 0.6) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.6)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.6), e.eval(op, state));

        // UBoolean(true,  0.3) xor true  -> UBoolean(true, 0.7) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.3)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.7), e.eval(op, state));

        // UBoolean(true,  0.0) xor true -> UBoolean(true, 1.0) : UBoolean
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("xor", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));


    }

    public void testXORWithUndefined() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // Undefined xor Undefined -> Undefined : OclVoid
        args = new Expression[] {
                new ExpUndefined(),
                new ExpUndefined()
        };
        op = ExpStdOp.create("xor", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());

        // UBoolean(true, 0.5) xor Undefined -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)),
                new ExpUndefined()
        };
        op = ExpStdOp.create("xor", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());

        // Undefined xor UBoolean(false, 0.4) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.4))
        };
        op = ExpStdOp.create("xor", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());

    }

    /**
     * Test NOT
     */

    public void testNot() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // not Undefined
        args = new Expression[] {
                new ExpUndefined()
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // not UBoolean(true, 0) -> UBoolean(true, 1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

        // not UBoolean(true, 1) -> UBoolean(true, 0)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));

        // not UBoolean(true, 0.2) -> UBoolean(true, 0.8)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.8), e.eval(op, state));

        // not UBoolean(true, 0.5) -> UBoolean(true, 0.5)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5), e.eval(op, state));

        // not UBoolean(true, 0.8) -> UBoolean(true, 0.2)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.8)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.2), e.eval(op, state));

        // not UBoolean(false, 0) -> UBoolean(true, 0)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.FALSE, e.eval(op, state));

        // not UBoolean(false, 1) -> UBoolean(true, 1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

        // not UBoolean(false, 0.2) -> UBoolean(true, 0.2)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.2), e.eval(op, state));

        // not UBoolean(false, 0.5) -> UBoolean(true, 0.5)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5), e.eval(op, state));

        // not UBoolean(false, 0.8) -> UBoolean(true, 0.8)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.8)
                )
        };
        op = ExpStdOp.create("not", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.8), e.eval(op, state));
    }

    /**
     * Test implies
     */

    public void testImpliesWithUBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(false, 0.5) or UBoolean(false, 0.2) -> UBoolean(true, 0.6)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.5)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.9), e.eval(op, state));

        // UBoolean(true, 0.4) implies UBoolean(false, 0.8) -> UBoolean(true, 0.68)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.4)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.8)
                )
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.68), e.eval(op, state));

        // UBoolean(true, 0.39) implies UBoolean(true, 0.67) -> UBoolean(true, 0.8713)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.39)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.67)
                )
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.8713), e.eval(op, state));
    }

    public void testImpliesWithBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // true implies false -> false
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // false implies UBoolean(false, 0.49) -> UBoolean(true, 1.0)
        args = new Expression[] {
                new ExpConstBoolean(false),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.49)
                )
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));


        // UBoolean(false, 0.79) implies false -> UBoolean(true, 0.79)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.79), e.eval(op, state));


        // UBoolean(true, 0.79) implies true -> UBoolean(true, 1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

    }


    public void testImpliesWithUndefined() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // Undefined implies Undefined
        args = new Expression[] {
                new ExpUndefined(),
                new ExpUndefined()
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UBoolean(true, 0.9) implies Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.9)
                ) ,
                new ExpUndefined()
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // true implies Undefined
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpUndefined()
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined implies UBoolean(false, 0.9)
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.9)
                )
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined implies false
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined implies UBoolean(true, 1)
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

        // UBoolean(false, 1) implies Undefined -> UBoolean(true, 1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(1)
                ),
                new ExpUndefined()
        };
        op = ExpStdOp.create("implies", args);
        assertEquals(op.toString(), UBooleanValue.TRUE, e.eval(op, state));

    }

    /**
     * Test Equivalent
     */

    public void testEquivalentWithUBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(false, 0.2).equivalent(UBoolean(false, 0.4)) -> UBoolean(true, 0.8) : UBoolean
        args = new Expression [] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.4)
                )
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.8), e.eval(op, state));

        // UBoolean(false, 0.8).equivalent(UBoolean(true, 0.5)) -> UBoolean(true, 0.7) : UBoolean
        args = new Expression [] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.8)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.7), e.eval(op, state));

        // UBoolean(true, 0.34).equivalent(UBoolean(true, 0.56)) -> UBoolean(true, 0.78) : UBoolean
        args = new Expression [] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.34)
                ),
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.56)
                )
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.78), e.eval(op, state));
    }

    public void testEquivalentWithBoolean() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;


        // true.equivalent(false) -> false : Boolean
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // true.equivalent(true) -> true : Boolean
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // false.equivalent(true) -> false : Boolean
        args = new Expression[] {
                new ExpConstBoolean(false),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // false.equivalent(false) -> true : Boolean
        args = new Expression[] {
                new ExpConstBoolean(false),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // false.equivalent(UBoolean(false, 0.49)) -> UBoolean(true, 0.49)
        args = new Expression[] {
                new ExpConstBoolean(false),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.49)
                )
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.49), e.eval(op, state));


        // UBoolean(false, 0.79).equivalent(false) -> UBoolean(true, 0.79)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.79), e.eval(op, state));


        // UBoolean(true, 0.79).equivalent( true ) -> UBoolean(true, 1)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.79)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.79), e.eval(op, state));

    }

    public void testEquivalentWithUndefined() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // Undefined.equivalent(Undefined) : OclVoid
        args = new Expression[] {
                new ExpUndefined(),
                new ExpUndefined()
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UBoolean(true, 0.9).equivalent(Undefined) : OclVoid
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.9)
                ) ,
                new ExpUndefined()
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // true.equivalent(Undefined) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstBoolean(true),
                new ExpUndefined()
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined.equivalent(UBoolean(false, 0.9)) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.9)
                )
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // Undefined.equivalent(false) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpUndefined(),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("equivalent", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));
    }

    /**
     * Test for toBooleanC
     */

    public void testToBooleanC() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(true, 0.2).toBooleanC(0.0) -> true
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.2).toBooleanC(0.2) -> true
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0.2)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(true, 0.2).toBooleanC(0.3) -> true
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0.2)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(false, 0.2).toBooleanC(0.3) -> true
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0.3)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(false, 0.2).toBooleanC(0.8) -> true
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0.8)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

        // UBoolean(false, 0.2).toBooleanC(0.9) -> false
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(0.9)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // UBoolean(false, 0.2).toBooleanC(1) -> false
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstInteger(1)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.FALSE, e.eval(op, state));

        // UBoolean(false, 0.2).toBooleanC(0) -> true
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstInteger(0)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertEquals(op.toString(), BooleanValue.TRUE, e.eval(op, state));

    }

    public void testToBooleanC_invalidConfidence() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // UBoolean(false, 0.2).toBooleanC(-0.2) -> Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(-0.2)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());

        // UBoolean(false, 0.2).toBooleanC(1.1) -> Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstReal(1.1)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());

        // UBoolean(false, 0.2).toBooleanC(2) -> Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstInteger(2)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());

        // UBoolean(false, 0.2).toBooleanC(-2) -> Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstInteger(-2)
        };
        op = ExpStdOp.create("toBooleanC", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());

        // UBoolean(false, 0.2).toBooleanC('Testing') -> Compilation error
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.2)
                ),
                new ExpConstString("Testing")
        };
        try {
            op = ExpStdOp.create("toBooleanC", args);
            e.eval(op, state);
            fail("Compilation error expected");
        }
        catch (ExpInvalidException ex) {
            // Success
        }
        catch (Exception ex) {
            fail("Compilation error expected");

        }
    }

    /**
     * Test for setValue
     */

    public void testSetValue() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UBoolean(true, 0.5).setValue(true) -> UBoolean(true, 0.5)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                ),
                new ExpConstBoolean(true)
        };
        op = ExpStdOp.create("setValue", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(true, 0.5), e.eval(op, state));

        // UBoolean(true, 0.7).setValue(false) -> UBoolean(true, 0.3)
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.7)
                ),
                new ExpConstBoolean(false)
        };
        op = ExpStdOp.create("setValue", args);
        assertEquals(op.toString(), UBooleanValue.valueOf(false, 0.7), e.eval(op, state));

        // UBoolean(true, 0.4).setValue('testing') -> Error de compilación
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.4)
                ),
                new ExpConstString("testing")
        };
        try {
            op = ExpStdOp.create("setValue", args);
            e.eval(op, state);
            fail("ExpInvalidException expected!");
        }
        catch (ExpInvalidException ex) {
            // success
        }
        catch (Exception ex) {
            fail("ExpInvalidException expected!");
        }
    }

    /**
     * Test toString : UBoolean -> String
     */

    public void testToString() throws ExpInvalidException {
        Expression[] args;
        ExpStdOp op;

        // UBoolean(true, 0.0).toString() -> 'UBoolean(false, 1.0)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(false, 1.0)"), e.eval(op, state));

        // UBoolean(true, 0.3).toString() -> 'UBoolean(false, 0.7)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.3)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(false, 0.7)"), e.eval(op, state));

        // UBoolean(true, 0.5).toString() -> 'UBoolean(true, 0.5)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(true, 0.5)"), e.eval(op, state));

        // UBoolean(true, 0.8).toString() -> 'UBoolean(true, 0.8)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(0.8)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(true, 0.8)"), e.eval(op, state));

        // UBoolean(true, 1).toString() -> 'UBoolean(true, 1.0)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(true),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(true, 1.0)"), e.eval(op, state));



        // UBoolean(false, 0.0).toString() -> 'UBoolean(true, 1.0)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(true, 1.0)"), e.eval(op, state));

        // UBoolean(false, 0.3).toString() -> 'UBoolean(true, 0.7)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.3)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(true, 0.7)"), e.eval(op, state));

        // UBoolean(false, 0.5).toString() -> 'UBoolean(true, 0.5)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(true, 0.5)"), e.eval(op, state));

        // UBoolean(false, 0.8).toString() -> 'UBoolean(false, 0.8)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(0.8)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(false, 0.8)"), e.eval(op, state));

        // UBoolean(false, 1).toString() -> 'UBoolean(false, 1.0)'
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(1)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UBoolean(false, 1.0)"), e.eval(op, state));



        // UBoolean(false, 5).toString() -> Undefined
        args = new Expression[] {
                new ExpConstUBoolean(
                        new ExpConstBoolean(false),
                        new ExpConstReal(5)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertTrue(op.toString(), e.eval(op, state).isUndefined());
    }


}
