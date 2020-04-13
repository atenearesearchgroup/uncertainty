package org.tzi.use.uml.ocl.expr;

import com.ximpleware.Expr;
import junit.framework.TestCase;
import org.tzi.use.uml.mm.ModelFactory;
import org.tzi.use.uml.ocl.type.UncertainType;
import org.tzi.use.uml.ocl.value.*;
import org.tzi.use.uml.sys.MSystem;
import org.tzi.use.uml.sys.MSystemState;

public class UIntegerExpOpsTest extends TestCase {
    private MSystemState state;
    private Evaluator e;
    private EvalContext ctx;

    protected void setUp() throws Exception {
        state = new MSystem(new ModelFactory().createModel("Test")).state();
        e = new Evaluator();
        ctx = new SimpleEvalContext(state, state, new VarBindings());
    }

    public void testConstWithValidValues() throws ExpInvalidException {
        Expression value, uncertainty, eUInteger;

        // UInteger(-5, 0.0) -> UInteger(-5, 0.0) : UInteger
        value = new ExpConstInteger(-5);
        uncertainty = new ExpConstReal(0);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(-5, 0.0)", eUInteger.toString());
        assertEquals(eUInteger.toString(), new UIntegerValue(-5, 0), eUInteger.eval(ctx));

        // UInteger(-5, 0.5) -> UInteger(-5, 0.5) : UInteger
        value = new ExpConstInteger(-5);
        uncertainty = new ExpConstReal(0.5);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(-5, 0.5)", eUInteger.toString());
        assertEquals(eUInteger.toString(), new UIntegerValue(-5, 0.5), eUInteger.eval(ctx));

        // UInteger(-5, -0.5) -> UInteger(-5, 0.5) : UInteger
        value = new ExpConstInteger(-5);
        uncertainty = new ExpConstReal(-0.5);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(-5, -0.5)", eUInteger.toString());
        assertEquals(eUInteger.toString(), new UIntegerValue(-5, 0.5), eUInteger.eval(ctx));

        // UInteger(-5, 2) -> UInteger(-5, 2) : UInteger
        value = new ExpConstInteger(-5);
        uncertainty = new ExpConstInteger(2);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(-5, 2)", eUInteger.toString());
        assertEquals(eUInteger.toString(), new UIntegerValue(-5, 2), eUInteger.eval(ctx));

        // UInteger(-5, -5) -> UInteger(-5, 5) : UInteger
        value = new ExpConstInteger(-5);
        uncertainty = new ExpConstInteger(-5);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(-5, -5)", eUInteger.toString());
        assertEquals(eUInteger.toString(), new UIntegerValue(-5, 5), eUInteger.eval(ctx));

        // UInteger(3, 39) -> UInteger(3, 39) : UInteger
        value = new ExpConstInteger(3);
        uncertainty = new ExpConstInteger(39);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(3, 39)", eUInteger.toString());
        assertEquals(eUInteger.toString(), new UIntegerValue(3, 39), eUInteger.eval(ctx));

        // UInteger(0, 0) -> UInteger(0, 0) : UInteger
        value = new ExpConstInteger(0);
        uncertainty = new ExpConstInteger(0);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(0, 0)", eUInteger.toString());
        assertEquals(eUInteger.toString(), new UIntegerValue(0, 0), eUInteger.eval(ctx));
    }

    public void testConstWithUndefined() throws ExpInvalidException {
        Expression value, uncertainty, eUInteger;

        // UInteger(Undefined, Undefined) -> Undefined : OclVoid
        value = new ExpUndefined();
        uncertainty = new ExpUndefined();
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(null, null)", eUInteger.toString());
        assertEquals(eUInteger.toString(), UndefinedValue.instance, eUInteger.eval(ctx));

        // UInteger(Undefined, 0.34) -> Undefined : OclVoid
        value = new ExpUndefined();
        uncertainty = new ExpConstReal(0.34);
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(null, 0.34)", eUInteger.toString());
        assertEquals(eUInteger.toString(), UndefinedValue.instance, eUInteger.eval(ctx));

        // UInteger(5, Undefined) -> Undefined : OclVoid
        value = new ExpConstInteger(5);
        uncertainty = new ExpUndefined();
        eUInteger = new ExpConstUInteger(value, uncertainty);
        assertEquals(eUInteger.toString() + ".toString()", "UInteger(5, null)", eUInteger.toString());
        assertEquals(eUInteger.toString(), UndefinedValue.instance, eUInteger.eval(ctx));
    }

    public void testConstWithWrongValues() {
        Expression value, uncertainty, eUInteger;

        // UInteger(32.03, 5.3)
        value = new ExpConstReal(32.03);
        uncertainty = new ExpConstReal(5.3);
        try {
            new ExpConstUInteger(value, uncertainty);
            fail("Exception expected");
        }
        catch (ExpInvalidException ex) {
            assertEquals("Value must be Integer", ex.getMessage());
        }
        catch (Exception ex) {
            fail("Exception expected");
        }

        // UInteger('testing', 0.3)
        value = new ExpConstString("testing");
        uncertainty = new ExpConstReal(0.3);
        try {
            new ExpConstUInteger(value, uncertainty);
            fail("Exception expected");
        }
        catch (ExpInvalidException ex) {
            assertEquals("Value must be Integer", ex.getMessage());
        }
        catch (Exception ex) {
            fail("Exception expected");
        }

        // UInteger(3, 'testing')
        value = new ExpConstInteger(3);
        uncertainty = new ExpConstString("testing");
        try {
            new ExpConstUInteger(value, uncertainty);
            fail("Exception expected");
        }
        catch (ExpInvalidException ex) {
            assertEquals("Uncertainty must be Integer or Real", ex.getMessage());
        }
        catch (Exception ex) {
            fail("Exception expected");
        }
    }


    public void testOpValue() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(3, 3.5).value() -> 3 : Integer
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstReal(3.5)
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), IntegerValue.valueOf(3), e.eval(op, state));

        // UInteger(0, 2.3).value() -> 0 : Integer
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstReal(2.3)
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), IntegerValue.valueOf(0), e.eval(op, state));

        // UInteger(-5, 0.2).value() -> -5 : Integer
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(-5),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), IntegerValue.valueOf(-5), e.eval(op, state));
    }

    public void testOpValueUndefined() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(null, null).value() -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpUndefined(),
                        new ExpUndefined()
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(3, null).value() -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpUndefined()
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(null, 3).value() -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpUndefined(),
                        new ExpConstInteger(3)
                )
        };
        op = ExpStdOp.create("value", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));
    }

    public void testOpSetValue() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(3, 5).setValue(2) -> UInteger(2, 5.0) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstInteger(5)
                ),
                new ExpConstInteger(2)
        };
        op = ExpStdOp.create("setValue", args);
        assertEquals(op.toString(), new UIntegerValue(2, 5), e.eval(op, state));

        // UInteger(-2, 4).setValue(0) -> UInteger(0, 4.0) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(-2),
                        new ExpConstInteger(4)
                ),
                new ExpConstInteger(0)
        };
        op = ExpStdOp.create("setValue", args);
        assertEquals(op.toString(), new UIntegerValue(0, 4), e.eval(op, state));

        // UInteger(0, 3).setValue(-55) -> UInteger(-55, 3.0) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstInteger(-55)
        };
        op = ExpStdOp.create("setValue", args);
        assertEquals(op.toString(), new UIntegerValue(-55, 3), e.eval(op, state));
    }

    public void testOpSetValueWrongValue() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(3, 5).setValue(Undefined)
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstInteger(5)
                ),
                new ExpUndefined()
        };
        try {
            op = ExpStdOp.create("setValue", args);
            fail("Exception expected!");
        }
        catch (ExpInvalidException ex) {
            // Success
        }
        catch (Exception ex) {
            fail("Exception expected!");
        }

        // UInteger(3, 5).setValue(2.5)
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstInteger(5)
                ),
                new ExpConstReal(2.5)
        };
        try {
            op = ExpStdOp.create("setValue", args);
            fail("Exception expected!");
        }
        catch (ExpInvalidException ex) {
            // Success
        }
        catch (Exception ex) {
            fail("Exception expected!");
        }

        // UInteger(3, 5).setValue('testing')
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstInteger(5)
                ),
                new ExpConstString("testing")
        };
        try {
            op = ExpStdOp.create("setValue", args);
            fail("Exception expected!");
        }
        catch (ExpInvalidException ex) {
            // Success
        }
        catch (Exception ex) {
            fail("Exception expected!");
        }
    }




    public void testOpUncertainty() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(3, 3.5).value() -> 3.5 : Real
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstReal(3.5)
                )
        };
        op = ExpStdOp.create("uncertainty", args);
        assertEquals(op.toString(), new RealValue(3.5), e.eval(op, state));

        // UInteger(0, 0).value() -> 0 : Real
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("uncertainty", args);
        assertEquals(op.toString(), new RealValue(0), e.eval(op, state));

        // UInteger(-5, 0.2).value() -> 0.2 : Real
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(-5),
                        new ExpConstReal(0.2)
                )
        };
        op = ExpStdOp.create("uncertainty", args);
        assertEquals(op.toString(), new RealValue(0.2), e.eval(op, state));
    }

    public void testOpUncertaintyUndefined() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(null, null).value() -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpUndefined(),
                        new ExpUndefined()
                )
        };
        op = ExpStdOp.create("uncertainty", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(3, null).value() -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpUndefined()
                )
        };
        op = ExpStdOp.create("uncertainty", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(null, 3).value() -> Undefined : OclVoid
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpUndefined(),
                        new ExpConstInteger(3)
                )
        };
        op = ExpStdOp.create("uncertainty", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));
    }

    public void testOpSetUncertainty() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(0, 3).setUncertainty(-5) -> UInteger(0, 5.0) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstInteger(-5)
        };
        op = ExpStdOp.create("setUncertainty", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5), e.eval(op, state));

        // UInteger(5, 2).setUncertainty(0) -> UInteger(5, 0.0) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(5),
                        new ExpConstInteger(2)
                ),
                new ExpConstInteger(0)
        };
        op = ExpStdOp.create("setUncertainty", args);
        assertEquals(op.toString(), new UIntegerValue(5, 0), e.eval(op, state));

        // UInteger(0, 3).setUncertainty(5) -> UInteger(0, 5.0) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstInteger(5)
        };
        op = ExpStdOp.create("setUncertainty", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5), e.eval(op, state));

        // UInteger(0, 3).setUncertainty(5.3) -> UInteger(0, 5.3) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstReal(5.3)
        };
        op = ExpStdOp.create("setUncertainty", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5.3), e.eval(op, state));

        // UInteger(0, 3).setUncertainty(0.2) -> UInteger(0, 0.2) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstReal(0.2)
        };
        op = ExpStdOp.create("setUncertainty", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.2), e.eval(op, state));

        // UInteger(0, 3).setUncertainty(-0.3) -> UInteger(0, 0.3) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstReal(-0.3)
        };
        op = ExpStdOp.create("setUncertainty", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.3), e.eval(op, state));

        // UInteger(0, 3).setUncertainty(0.0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstReal(0.0)
        };
        op = ExpStdOp.create("setUncertainty", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

    }

    public void testOpSetUncertaintyWithWrongArgs() throws ExpInvalidException {
        Expression [] args;

        // UInteger(0, 3).setUncertainty('testing')
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpConstString("testing")
        };
        try {
            ExpStdOp.create("setUncertainty", args);
            fail("Exception expected");
        }
        catch (ExpInvalidException ex) {
            // Success
        }
        catch (Exception ex) {
            fail("Exception expected");
        }
        // UInteger(5, 2).setUncertainty(Undefined)
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstInteger(3)
                ),
                new ExpUndefined()
        };
        try {
            ExpStdOp.create("setUncertainty", args);
            fail("Exception expected");
        }
        catch (ExpInvalidException ex) {
            // Success
        }
        catch (Exception ex) {
            fail("Exception expected");
        }

    }

    public void testToInteger() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(3, 0.3).toInteger() -> 3 : Integer
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstReal(0.3)
                )
        };
        op = ExpStdOp.create("toInteger", args);
        assertEquals(op.toString(), IntegerValue.valueOf(3), e.eval(op, state));

        // UInteger(0, 4).toInteger() -> 0 : Integer
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstReal(4)
                )
        };
        op = ExpStdOp.create("toInteger", args);
        assertEquals(op.toString(), IntegerValue.valueOf(0), e.eval(op, state));

        // UInteger(-5, 5).toInteger() -> -5 : Integer
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(-5),
                        new ExpConstReal(5)
                )
        };
        op = ExpStdOp.create("toInteger", args);
        assertEquals(op.toString(), IntegerValue.valueOf(-5), e.eval(op, state));

    }

    public void testToUReal() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(3, 0.5).toUReal() -> UReal(3.0, 0.5) : UReal
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("toUReal", args);
        assertEquals(op.toString(), new URealValue(3, 0.5), e.eval(op, state));

        // UInteger(3, -0.5).toUReal() -> UReal(3.0, 0.5) : UReal
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstReal(-0.5)
                )
        };
        op = ExpStdOp.create("toUReal", args);
        assertEquals(op.toString(), new URealValue(3, 0.5), e.eval(op, state));

        // UInteger(0, 0).toUReal() -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstReal(0)
                )
        };
        op = ExpStdOp.create("toUReal", args);
        assertEquals(op.toString(), new URealValue(0, 0), e.eval(op, state));

        // UInteger(-53, 5).toUReal() -> UReal(-53.0, 5.0) : UReal
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(-53),
                        new ExpConstReal(5)
                )
        };
        op = ExpStdOp.create("toUReal", args);
        assertEquals(op.toString(), new URealValue(-53, 5), e.eval(op, state));
    }

    public void testToReal() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(3, 0.3).toReal() -> 3.0 : Real
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(3),
                        new ExpConstReal(0.3)
                )
        };
        op = ExpStdOp.create("toReal", args);
        assertEquals(op.toString(), new RealValue(3), e.eval(op, state));

        // UInteger(0, 0.5).toReal() -> 0.0 : Real
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(0),
                        new ExpConstReal(0.5)
                )
        };
        op = ExpStdOp.create("toReal", args);
        assertEquals(op.toString(), new RealValue(0), e.eval(op, state));

        // UInteger(-3, -0.5).toReal() -> -3.0 : Real
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(-3),
                        new ExpConstReal(-0.5)
                )
        };
        op = ExpStdOp.create("toReal", args);
        assertEquals(op.toString(), new RealValue(-3), e.eval(op, state));
    }

    public void testToString() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;

        // UInteger(5, 0.3).toString() -> 'UInteger(5, 0.3)' : String
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(5),
                        new ExpConstReal(0.3)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UInteger(5, 0.3)"), e.eval(op, state));

        // UInteger(5, -0.3).toString() -> 'UInteger(5, 0.3)' : String
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(5),
                        new ExpConstReal(-0.3)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UInteger(5, 0.3)"), e.eval(op, state));

        // UInteger(-5, 0.3).toString() -> 'UInteger(-5, 0.3)' : String
        args = new Expression[] {
                new ExpConstUInteger(
                        new ExpConstInteger(-5),
                        new ExpConstReal(0.3)
                )
        };
        op = ExpStdOp.create("toString", args);
        assertEquals(op.toString(), new StringValue("UInteger(-5, 0.3)"), e.eval(op, state));

    }

    // Test UInteger.add

    public void testAddBetweenUInteger() throws ExpInvalidException {
        Expression [] args;
        ExpStdOp op;
        // UInteger(-9, 0) + UInteger(-9, 0) -> UInteger(-18, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-18, 0), e.eval(op, state));


        // UInteger(-7, 0) + UInteger(-7, 8) -> UInteger(-14, 8) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-7, 0)),
                new ExpressionWithValue(new UIntegerValue(-7, 8))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-14, 8), e.eval(op, state));


        // UInteger(-10, 0) + UInteger(0, 0) -> UInteger(-10, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-10, 0), e.eval(op, state));


        // UInteger(-8, 0) + UInteger(3, 5) -> UInteger(-5, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 0)),
                new ExpressionWithValue(new UIntegerValue(3, 5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-5, 5), e.eval(op, state));


        // UInteger(-6, 8) + UInteger(-6, 0) -> UInteger(-12, 8) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 8)),
                new ExpressionWithValue(new UIntegerValue(-6, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-12, 8), e.eval(op, state));


        // UInteger(-9, 3) + UInteger(-9, 4) -> UInteger(-18, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 3)),
                new ExpressionWithValue(new UIntegerValue(-9, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-18, 5), e.eval(op, state));


        // UInteger(-9, 8) + UInteger(4, 0) -> UInteger(-5, 8) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 8)),
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-5, 8), e.eval(op, state));


        // UInteger(-3, 3) + UInteger(4, 4) -> UInteger(1, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 3)),
                new ExpressionWithValue(new UIntegerValue(4, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(1, 5), e.eval(op, state));


        // UInteger(0, 0) + UInteger(0, 0) -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));


        // UInteger(0, 0) + UInteger(0, 0) -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));


        // UInteger(0, 0) + UInteger(9, 0) -> UInteger(9, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(9, 0), e.eval(op, state));


        // UInteger(0, 0) + UInteger(8, 4) -> UInteger(8, 4) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(8, 4), e.eval(op, state));


        // UInteger(0, 8) + UInteger(0, 0) -> UInteger(0, 8) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 8)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(0, 8), e.eval(op, state));


        // UInteger(0, 3) + UInteger(0, 4) -> UInteger(0, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new UIntegerValue(0, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5), e.eval(op, state));


        // UInteger(0, 6) + UInteger(8, 0) -> UInteger(8, 6) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 6)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(8, 6), e.eval(op, state));


        // UInteger(0, 3) + UInteger(5, 4) -> UInteger(5, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new UIntegerValue(5, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(5, 5), e.eval(op, state));


        // UInteger(9, 0) + UInteger(9, 0) -> UInteger(18, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(18, 0), e.eval(op, state));


        // UInteger(7, 0) + UInteger(7, 0) -> UInteger(14, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 0)),
                new ExpressionWithValue(new UIntegerValue(7, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(14, 0), e.eval(op, state));


        // UInteger(10, 0) + UInteger(8, 0) -> UInteger(18, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(18, 0), e.eval(op, state));


        // UInteger(8, 0) + UInteger(8, 7) -> UInteger(16, 7) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(8, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 7))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(16, 7), e.eval(op, state));


        // UInteger(6, 5) + UInteger(6, 0) -> UInteger(12, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 5)),
                new ExpressionWithValue(new UIntegerValue(6, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(12, 5), e.eval(op, state));


        // UInteger(9, 3) + UInteger(9, 4) -> UInteger(18, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 3)),
                new ExpressionWithValue(new UIntegerValue(9, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(18, 5), e.eval(op, state));


        // UInteger(9, 1) + UInteger(8, 0) -> UInteger(17, 1) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 1)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(17, 1), e.eval(op, state));


        // UInteger(3, 3) + UInteger(4, 4) -> UInteger(7, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 3)),
                new ExpressionWithValue(new UIntegerValue(4, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(7, 5), e.eval(op, state));
    }

    public void testAddWithUReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0) + UReal(-9, 0) -> UInteger(-18, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new URealValue(-9, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-18, 0.0), e.eval(op, state));

        // UInteger(-7, 0) + UReal(-7, 8) -> UInteger(-14, 8.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-7, 0)),
                new ExpressionWithValue(new URealValue(-7, 8))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-14, 8.0), e.eval(op, state));

        // UInteger(-10, 0) + UReal(0, 0) -> UInteger(-10, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-10, 0.0), e.eval(op, state));

        // UInteger(-8, 0) + UReal(3, 5) -> UInteger(-5, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 0)),
                new ExpressionWithValue(new URealValue(3, 5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-5, 5.0), e.eval(op, state));

        // UInteger(-6, 8) + UReal(-6, 0) -> UInteger(-12, 8.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 8)),
                new ExpressionWithValue(new URealValue(-6, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-12, 8.0), e.eval(op, state));

        // UInteger(-9, 3) + UReal(-9, 4) -> UInteger(-18, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 3)),
                new ExpressionWithValue(new URealValue(-9, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-18, 5.0), e.eval(op, state));

        // UInteger(-9, 8) + UReal(4, 0) -> UInteger(-5, 8.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 8)),
                new ExpressionWithValue(new URealValue(4, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-5, 8.0), e.eval(op, state));

        // UInteger(-3, 3) + UReal(4, 4) -> UInteger(1, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 3)),
                new ExpressionWithValue(new URealValue(4, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(1, 5.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(0, 0) -> UInteger(0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(0, 0) -> UInteger(0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(9, 0) -> UInteger(9, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(9, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(9, 0.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(8, 4) -> UInteger(8, 4.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(8, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(8, 4.0), e.eval(op, state));

        // UInteger(0, 8) + UReal(0, 0) -> UInteger(0, 8.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 8)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(0, 8.0), e.eval(op, state));

        // UInteger(0, 3) + UReal(0, 4) -> UInteger(0, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new URealValue(0, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(0, 5.0), e.eval(op, state));

        // UInteger(0, 6) + UReal(8, 0) -> UInteger(8, 6.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 6)),
                new ExpressionWithValue(new URealValue(8, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(8, 6.0), e.eval(op, state));

        // UInteger(0, 3) + UReal(5, 4) -> UInteger(5, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new URealValue(5, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(5, 5.0), e.eval(op, state));

        // UInteger(9, 0) + UReal(9, 0) -> UInteger(18, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new URealValue(9, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(18, 0.0), e.eval(op, state));

        // UInteger(7, 0) + UReal(7, 0) -> UInteger(14, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 0)),
                new ExpressionWithValue(new URealValue(7, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(14, 0.0), e.eval(op, state));

        // UInteger(10, 0) + UReal(8, 0) -> UInteger(18, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new URealValue(8, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(18, 0.0), e.eval(op, state));

        // UInteger(8, 0) + UReal(8, 7) -> UInteger(16, 7.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(8, 0)),
                new ExpressionWithValue(new URealValue(8, 7))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(16, 7.0), e.eval(op, state));

        // UInteger(6, 5) + UReal(6, 0) -> UInteger(12, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 5)),
                new ExpressionWithValue(new URealValue(6, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(12, 5.0), e.eval(op, state));

        // UInteger(9, 3) + UReal(9, 4) -> UInteger(18, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 3)),
                new ExpressionWithValue(new URealValue(9, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(18, 5.0), e.eval(op, state));

        // UInteger(9, 1) + UReal(8, 0) -> UInteger(17, 1.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 1)),
                new ExpressionWithValue(new URealValue(8, 0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(17, 1.0), e.eval(op, state));

        // UInteger(3, 3) + UReal(4, 4) -> UInteger(7, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 3)),
                new ExpressionWithValue(new URealValue(4, 4))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(7, 5.0), e.eval(op, state));

    }

    public void testAddWithReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) + -3 -> UReal(-6, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(new RealValue(-3))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-6, 0.0), e.eval(op, state));

        // UInteger(-6, 0) + -1.2 -> UReal(-7.2, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(new RealValue(-1.2))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-7.2, 0.0), e.eval(op, state));

        // UInteger(-5, 3) + -5 -> UReal(-10, 3.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(new RealValue(-5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-10, 3.0), e.eval(op, state));

        // UInteger(-8, 5) + -2 -> UReal(-10, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(new RealValue(-2))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-10, 5.0), e.eval(op, state));

        // UInteger(0, 0) + 0 -> UReal(0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) + 3 -> UReal(3, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(3))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(3, 0.0), e.eval(op, state));

        // UInteger(0, 3) + 0 -> UReal(0, 3.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new RealValue(0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(0, 3.0), e.eval(op, state));

        // UInteger(0, 5) + -5 -> UReal(-5, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(new RealValue(-5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(-5, 5.0), e.eval(op, state));

        // UInteger(5, 0) + 5 -> UReal(10, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new RealValue(5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(10, 0.0), e.eval(op, state));

        // UInteger(3, 0) + 0.6 -> UReal(3.6, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(new RealValue(0.6))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(3.6, 0.0), e.eval(op, state));

        // UInteger(7, 3) + 7 -> UReal(14, 3.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(new RealValue(7))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(14, 3.0), e.eval(op, state));

        // UInteger(2, 5) + 0.5 -> UReal(2.5, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(new RealValue(0.5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new URealValue(2.5, 5.0), e.eval(op, state));
    }

    public void testAddWithInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) + -3 -> UReal(-6, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-3))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-6, 0.0), e.eval(op, state));

        // UInteger(-6, 0) + -12 -> UReal(-18, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-12))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-18, 0.0), e.eval(op, state));

        // UInteger(-5, 3) + -5 -> UReal(-10, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-10, 3.0), e.eval(op, state));

        // UInteger(-8, 5) + -2 -> UReal(-10, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-2))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-10, 5.0), e.eval(op, state));

        // UInteger(0, 0) + 0 -> UReal(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) + 3 -> UReal(3, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(3))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(3, 0.0), e.eval(op, state));

        // UInteger(0, 3) + 0 -> UReal(0, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(0, 3.0), e.eval(op, state));

        // UInteger(0, 5) + -5 -> UReal(-5, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(-5, 5.0), e.eval(op, state));

        // UInteger(5, 0) + 5 -> UReal(10, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(5))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(10, 0.0), e.eval(op, state));

        // UInteger(3, 0) + 56 -> UReal(59, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(56))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(59, 0.0), e.eval(op, state));

        // UInteger(7, 3) + 7 -> UReal(14, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(7))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(14, 3.0), e.eval(op, state));

        // UInteger(2, 5) + 65 -> UReal(67, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(65))
        };
        op = ExpStdOp.create("+", args);
        assertEquals(op.toString(), new UIntegerValue(67, 5.0), e.eval(op, state));
    }

    public void testNeg() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(3, 2.3).neg() -> UInteger(-3, 2.3) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 2.3))
        };
        op = ExpStdOp.create("neg", args);
        assertEquals(op.toString(), new UIntegerValue(-3, 2.3), e.eval(op, state));

        // UInteger(0, 2.3).neg() -> UInteger(0, 2.3) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 2.3))
        };
        op = ExpStdOp.create("neg", args);
        assertEquals(op.toString(), new UIntegerValue(0, 2.3), e.eval(op, state));

        // UInteger(-3, 2.3).neg() -> UInteger(3, 2.3) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 2.3))
        };
        op = ExpStdOp.create("neg", args);
        assertEquals(op.toString(), new UIntegerValue(3, 2.3), e.eval(op, state));
    }

    // Testing Sqrt
    public void testSQRT() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 2.3).sqrt() -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 2.3))
        };
        op = ExpStdOp.create("sqrt", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0.0).sqrt() -> UInteger(0, 0) : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("sqrt", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(4, 0.0).sqrt() -> UInteger(2, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("sqrt", args);
        assertEquals(op.toString(), new UIntegerValue(2, 0), e.eval(op, state));

        // UInteger(4, 2).sqrt() -> UInteger(2, 0.5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 2))
        };
        op = ExpStdOp.create("sqrt", args);
        assertEquals(op.toString(), new UIntegerValue(2, 0.5), e.eval(op, state));

    }


    // Testing operator ABS()

    public void testABS() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(2, 3).abs() -> UInteger(2.0, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3))
        };
        op = ExpStdOp.create("abs", args);
        assertEquals(op.toString(), new UIntegerValue(2, 3), e.eval(op, state));

        // UInteger(0, 3).abs() -> UInteger(0, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3))
        };
        op = ExpStdOp.create("abs", args);
        assertEquals(op.toString(), new UIntegerValue(0, 3), e.eval(op, state));

        // UInteger(-2, 3).abs() -> UInteger(2, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3))
        };
        op = ExpStdOp.create("abs", args);
        assertEquals(op.toString(), new UIntegerValue(2, 3), e.eval(op, state));
    }



    // Minus operation.

    public void testMinusBetweenUInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0) + UInteger(-9, 0) -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(-5, 0) + UInteger(-5, 3) -> UInteger(0, 3) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new UIntegerValue(-5, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 3), e.eval(op, state));

        // UInteger(-4, 0) + UInteger(2, 0) -> UInteger(-6, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new UIntegerValue(2, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-6, 0), e.eval(op, state));

        // UInteger(-10, 0) + UInteger(4, 1) -> UInteger(-14, 1) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new UIntegerValue(4, 1))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-14, 1), e.eval(op, state));

        // UInteger(-9, 9) + UInteger(-9, 0) -> UInteger(0, 9) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 9), e.eval(op, state));

        // UInteger(-2, 3) + UInteger(-2, 4) -> UInteger(0, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(-2, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5), e.eval(op, state));

        // UInteger(-6, 2) + UInteger(5, 0) -> UInteger(-11, 2) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new UIntegerValue(5, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-11, 2), e.eval(op, state));

        // UInteger(-2, 3) + UInteger(4, 4) -> UInteger(-6, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(4, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-6, 5), e.eval(op, state));

        // UInteger(0, 0) + UInteger(0, 0) -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(0, 0) + UInteger(0, 4) -> UInteger(0, 4) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 4), e.eval(op, state));

        // UInteger(0, 0) + UInteger(6, 0) -> UInteger(-6, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(6, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-6, 0), e.eval(op, state));

        // UInteger(0, 0) + UInteger(7, 3) -> UInteger(-7, 3) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(7, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-7, 3), e.eval(op, state));

        // UInteger(0, 4) + UInteger(0, 0) -> UInteger(0, 4) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 4), e.eval(op, state));

        // UInteger(0, 4) + UInteger(0, 3) -> UInteger(0, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5), e.eval(op, state));

        // UInteger(0, 4) + UInteger(1, 0) -> UInteger(-1, 4) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(1, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-1, 4), e.eval(op, state));

        // UInteger(0, 4) + UInteger(2, 3) -> UInteger(-2, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(2, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-2, 5), e.eval(op, state));

        // UInteger(9, 0) + UInteger(9, 0) -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(5, 0) + UInteger(5, 3) -> UInteger(0, 3) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new UIntegerValue(5, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 3), e.eval(op, state));

        // UInteger(4, 0) + UInteger(8, 0) -> UInteger(-4, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-4, 0), e.eval(op, state));

        // UInteger(10, 0) + UInteger(10, 12) -> UInteger(0, 12) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new UIntegerValue(10, 12))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 12), e.eval(op, state));

        // UInteger(9, 5) + UInteger(9, 0) -> UInteger(0, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5), e.eval(op, state));

        // UInteger(2, 3) + UInteger(2, 4) -> UInteger(0, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 5), e.eval(op, state));

        // UInteger(6, 1) + UInteger(4, 0) -> UInteger(2, 1) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(2, 1), e.eval(op, state));

        // UInteger(2, 3) + UInteger(5, 4) -> UInteger(-3, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(5, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-3, 5), e.eval(op, state));
    }

    public void testMinusUReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0) + UReal(-9, 0) -> UReal(0.0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new URealValue(-9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(-5, 0) + UReal(-5, 3) -> UReal(0.0, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new URealValue(-5, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 3.0), e.eval(op, state));

        // UInteger(-4, 0) + UReal(2, 0) -> UReal(-6.0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new URealValue(2, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-6.0, 0.0), e.eval(op, state));

        // UInteger(-10, 0) + UReal(4, 1) -> UReal(-14.0, 1.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new URealValue(4, 1))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-14.0, 1.0), e.eval(op, state));

        // UInteger(-9, 9) + UReal(-9, 0) -> UReal(0.0, 9.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new URealValue(-9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 9.0), e.eval(op, state));

        // UInteger(-2, 3) + UReal(-2, 4) -> UReal(0.0, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new URealValue(-2, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 5.0), e.eval(op, state));

        // UInteger(-6, 2) + UReal(5, 0) -> UReal(-11.0, 2.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new URealValue(5, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-11.0, 2.0), e.eval(op, state));

        // UInteger(-2, 3) + UReal(4, 4) -> UReal(-6.0, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new URealValue(4, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-6.0, 5.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(0, 0) -> UReal(0.0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(0, 4) -> UReal(0.0, 4.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(0, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 4.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(6, 0) -> UReal(-6.0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(6, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-6.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) + UReal(7, 3) -> UReal(-7.0, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(7, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-7.0, 3.0), e.eval(op, state));

        // UInteger(0, 4) + UReal(0, 0) -> UReal(0.0, 4.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 4.0), e.eval(op, state));

        // UInteger(0, 4) + UReal(0, 3) -> UReal(0.0, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(0, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 5.0), e.eval(op, state));

        // UInteger(0, 4) + UReal(1, 0) -> UReal(-1.0, 4.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(1, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-1.0, 4.0), e.eval(op, state));

        // UInteger(0, 4) + UReal(2, 3) -> UReal(-2.0, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(2, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-2.0, 5.0), e.eval(op, state));

        // UInteger(9, 0) + UReal(9, 0) -> UReal(0.0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new URealValue(9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(5, 0) + UReal(5, 3) -> UReal(0.0, 3.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new URealValue(5, 3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 3.0), e.eval(op, state));

        // UInteger(4, 0) + UReal(8, 0) -> UReal(-4.0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new URealValue(8, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-4.0, 0.0), e.eval(op, state));

        // UInteger(10, 0) + UReal(10, 12) -> UReal(0.0, 12.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new URealValue(10, 12))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 12.0), e.eval(op, state));

        // UInteger(9, 5) + UReal(9, 0) -> UReal(0.0, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new URealValue(9, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 5.0), e.eval(op, state));

        // UInteger(2, 3) + UReal(2, 4) -> UReal(0.0, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new URealValue(2, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 5.0), e.eval(op, state));

        // UInteger(6, 1) + UReal(4, 0) -> UReal(2.0, 1.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new URealValue(4, 0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(2.0, 1.0), e.eval(op, state));

        // UInteger(2, 3) + UReal(5, 4) -> UReal(-3.0, 5.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new URealValue(5, 4))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-3.0, 5.0), e.eval(op, state));
    }

    public void testMinusWithReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) +-3.0 -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(new RealValue(-3.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(-6, 0) +-1.2 -> UReal(-4.8, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(new RealValue(-1.2))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-4.8, 0.0), e.eval(op, state));

        // UInteger(-5, 3) +-5.0 -> UReal(0.0, 3.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(new RealValue(-5.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 3.0), e.eval(op, state));

        // UInteger(-8, 5) +-2.0 -> UReal(-6.0, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(new RealValue(-2.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-6.0, 5.0), e.eval(op, state));

        // UInteger(0, 0) +0.0 -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(0.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) +3.0 -> UReal(-3.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(3.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(-3.0, 0.0), e.eval(op, state));

        // UInteger(0, 3) +0.0 -> UReal(0.0, 3.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new RealValue(0.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 3.0), e.eval(op, state));

        // UInteger(0, 5) +-5.0 -> UReal(5.0, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(new RealValue(-5.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(5.0, 5.0), e.eval(op, state));

        // UInteger(5, 0) +5.0 -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new RealValue(5.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(3, 0) +0.6 -> UReal(2.4, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(new RealValue(0.6))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(2.4, 0.0), e.eval(op, state));

        // UInteger(7, 3) +7.0 -> UReal(0.0, 3.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(new RealValue(7.0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(0.0, 3.0), e.eval(op, state));

        // UInteger(2, 5) +0.5 -> UReal(1.5, 5.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(new RealValue(0.5))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new URealValue(1.5, 5.0), e.eval(op, state));
    }

    public void testMinusWithInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) +-3 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(-6, 0) +-12 -> UInteger(6, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-12))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(6, 0), e.eval(op, state));

        // UInteger(-5, 3) +-5 -> UInteger(0, 3) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 3), e.eval(op, state));

        // UInteger(-8, 5) +-2 -> UInteger(-6, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-2))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-6, 5), e.eval(op, state));

        // UInteger(0, 0) +0 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(0, 0) +3 -> UInteger(-3, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(3))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-3, 0), e.eval(op, state));

        // UInteger(0, 3) +0 -> UInteger(0, 3) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 3), e.eval(op, state));

        // UInteger(0, 5) +-5 -> UInteger(5, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(5, 5), e.eval(op, state));

        // UInteger(5, 0) +5 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(5))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(3, 0) +56 -> UInteger(-53, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(56))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-53, 0), e.eval(op, state));

        // UInteger(7, 3) +7 -> UInteger(0, 3) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(7))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(0, 3), e.eval(op, state));

        // UInteger(2, 5) +65 -> UInteger(-63, 5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(65))
        };
        op = ExpStdOp.create("-", args);
        assertEquals(op.toString(), new UIntegerValue(-63, 5), e.eval(op, state));
    }

    public void testMultBetweenUInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;



        // UInteger(-9, 0) * UInteger(-9, 0) -> UInteger(81, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(81, 0.0), e.eval(op, state));

        // UInteger(-5, 0) * UInteger(-5, 3) -> UInteger(25, 15.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new UIntegerValue(-5, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(25, 15.0), e.eval(op, state));

        // UInteger(-4, 0) * UInteger(2, 0) -> UInteger(-8, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new UIntegerValue(2, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(-8, 0.0), e.eval(op, state));

        // UInteger(-10, 0) * UInteger(4, 1) -> UInteger(-40, 10.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new UIntegerValue(4, 1))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(-40, 10.0), e.eval(op, state));

        // UInteger(-9, 9) * UInteger(-9, 0) -> UInteger(81, 81.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(81, 81.0), e.eval(op, state));

        // UInteger(-2, 3) * UInteger(-2, 4) -> UInteger(4, 10.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(-2, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(4, 10.0), e.eval(op, state));

        // UInteger(-6, 2) * UInteger(5, 0) -> UInteger(-30, 10.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new UIntegerValue(5, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(-30, 10.0), e.eval(op, state));

        // UInteger(-2, 3) * UInteger(2, 4) -> UInteger(-4, 10.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(-4, 10.0), e.eval(op, state));

        // UInteger(0, 0) * UInteger(0, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * UInteger(0, 4) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * UInteger(6, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(6, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * UInteger(7, 3) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(7, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 4) * UInteger(0, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 4) * UInteger(0, 3) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 4) * UInteger(1, 0) -> UInteger(0, 4.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(1, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 4.0), e.eval(op, state));

        // UInteger(0, 4) * UInteger(2, 3) -> UInteger(0, 8.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(2, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 8.0), e.eval(op, state));

        // UInteger(9, 0) * UInteger(9, 0) -> UInteger(81, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(81, 0.0), e.eval(op, state));

        // UInteger(5, 0) * UInteger(5, 3) -> UInteger(25, 15.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new UIntegerValue(5, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(25, 15.0), e.eval(op, state));

        // UInteger(4, 0) * UInteger(8, 0) -> UInteger(32, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(32, 0.0), e.eval(op, state));

        // UInteger(10, 0) * UInteger(10, 12) -> UInteger(100, 120.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new UIntegerValue(10, 12))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(100, 120.0), e.eval(op, state));

        // UInteger(9, 5) * UInteger(9, 0) -> UInteger(81, 45.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(81, 45.0), e.eval(op, state));

        // UInteger(2, 3) * UInteger(2, 4) -> UInteger(4, 10.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(4, 10.0), e.eval(op, state));

        // UInteger(6, 1) * UInteger(4, 0) -> UInteger(24, 4.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(24, 4.0), e.eval(op, state));

        // UInteger(2, 3) * UInteger(5, 4) -> UInteger(10, 17.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(5, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(10, 17.0), e.eval(op, state));
    }

    public void testMultWithUReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0) * UReal(-9, 0) -> UReal(81.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new URealValue(-9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(81.0, 0.0), e.eval(op, state));

        // UInteger(-5, 0) * UReal(-5, 3) -> UReal(25.0, 15.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new URealValue(-5, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(25.0, 15.0), e.eval(op, state));

        // UInteger(-4, 0) * UReal(2, 0) -> UReal(-8.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new URealValue(2, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(-8.0, 0.0), e.eval(op, state));

        // UInteger(-10, 0) * UReal(4, 1) -> UReal(-40.0, 10.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new URealValue(4, 1))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(-40.0, 10.0), e.eval(op, state));

        // UInteger(-9, 9) * UReal(-9, 0) -> UReal(81.0, 81.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new URealValue(-9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(81.0, 81.0), e.eval(op, state));

        // UInteger(-2, 3) * UReal(-2, 4) -> UReal(4.0, 10.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new URealValue(-2, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(4.0, 10.0), e.eval(op, state));

        // UInteger(-6, 2) * UReal(5, 0) -> UReal(-30.0, 10.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new URealValue(5, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(-30.0, 10.0), e.eval(op, state));

        // UInteger(-2, 3) * UReal(2, 4) -> UReal(-4.0, 10.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new URealValue(2, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(-4.0, 10.0), e.eval(op, state));

        // UInteger(0, 0) * UReal(0, 0) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * UReal(0, 4) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(0, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * UReal(6, 0) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(6, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * UReal(7, 3) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new URealValue(7, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 4) * UReal(0, 0) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(0, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 4) * UReal(0, 3) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(0, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 4) * UReal(1, 0) -> UReal(0.0, 4.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(1, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 4.0), e.eval(op, state));

        // UInteger(0, 4) * UReal(2, 3) -> UReal(0.0, 8.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new URealValue(2, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 8.0), e.eval(op, state));

        // UInteger(9, 0) * UReal(9, 0) -> UReal(81.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new URealValue(9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(81.0, 0.0), e.eval(op, state));

        // UInteger(5, 0) * UReal(5, 3) -> UReal(25.0, 15.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new URealValue(5, 3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(25.0, 15.0), e.eval(op, state));

        // UInteger(4, 0) * UReal(8, 0) -> UReal(32.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new URealValue(8, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(32.0, 0.0), e.eval(op, state));

        // UInteger(10, 0) * UReal(10, 12) -> UReal(100.0, 120.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new URealValue(10, 12))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(100.0, 120.0), e.eval(op, state));

        // UInteger(9, 5) * UReal(9, 0) -> UReal(81.0, 45.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new URealValue(9, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(81.0, 45.0), e.eval(op, state));

        // UInteger(2, 3) * UReal(2, 4) -> UReal(4.0, 10.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new URealValue(2, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(4.0, 10.0), e.eval(op, state));

        // UInteger(6, 1) * UReal(4, 0) -> UReal(24.0, 4.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new URealValue(4, 0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(24.0, 4.0), e.eval(op, state));

        // UInteger(2, 3) * UReal(5, 4) -> UReal(10.0, 17.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new URealValue(5, 4))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(10.0, 17.0), e.eval(op, state));

    }

    public void testMultReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) * -3.0 -> UReal(9.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(new RealValue(-3.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(9.0, 0.0), e.eval(op, state));

        // UInteger(-6, 0) * -1.2 -> UReal(7.2, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(new RealValue(-1.2))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(7.2, 0.0), e.eval(op, state));

        // UInteger(-5, 3) * -5.0 -> UReal(25.0, 15.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(new RealValue(-5.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(25.0, 15.0), e.eval(op, state));

        // UInteger(-8, 5) * -2.0 -> UReal(16.0, 10.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(new RealValue(-2.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(16.0, 10.0), e.eval(op, state));

        // UInteger(0, 0) * 0.0 -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(0.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * 3.0 -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(3.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 3) * 0.0 -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new RealValue(0.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 5) * -5.0 -> UReal(0.0, 25.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(new RealValue(-5.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(0.0, 25.0), e.eval(op, state));

        // UInteger(5, 0) * 5.0 -> UReal(25.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new RealValue(5.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(25.0, 0.0), e.eval(op, state));

        // UInteger(3, 0) * 0.6 -> UReal(1.8, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(new RealValue(0.6))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(1.8, 0.0), e.eval(op, state));

        // UInteger(7, 3) * 7.0 -> UReal(49.0, 21.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(new RealValue(7.0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(49.0, 21.0), e.eval(op, state));

        // UInteger(2, 5) * 0.5 -> UReal(1.0, 2.5) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(new RealValue(0.5))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new URealValue(1.0, 2.5), e.eval(op, state));
    }

    public void testMultInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) * -3 -> UInteger(9, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(9, 0.0), e.eval(op, state));

        // UInteger(-6, 0) * -12 -> UInteger(72, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-12))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(72, 0.0), e.eval(op, state));

        // UInteger(-5, 3) * -5 -> UInteger(25, 15.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(25, 15.0), e.eval(op, state));

        // UInteger(-8, 5) * -2 -> UInteger(16, 10.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-2))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(16, 10.0), e.eval(op, state));

        // UInteger(0, 0) * 0 -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0) * 3 -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(3))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 3) * 0 -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 5) * -5 -> UInteger(0, 25.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(0, 25.0), e.eval(op, state));

        // UInteger(5, 0) * 5 -> UInteger(25, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(5))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(25, 0.0), e.eval(op, state));

        // UInteger(3, 0) * 56 -> UInteger(168, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(56))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(168, 0.0), e.eval(op, state));

        // UInteger(7, 3) * 7 -> UInteger(49, 21.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(7))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(49, 21.0), e.eval(op, state));

        // UInteger(2, 5) * 65 -> UInteger(130, 325.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(65))
        };
        op = ExpStdOp.create("*", args);
        assertEquals(op.toString(), new UIntegerValue(130, 325.0), e.eval(op, state));
    }


    // Test UInteger.divideBy

    public void testDividyByRBetweenUInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0) / UInteger(-9, 0) -> UReal(1.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.0), e.eval(op, state));

        // UInteger(-5, 0) / UInteger(-5, 3) -> UReal(1.0, 0.12) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new UIntegerValue(-5, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.12), e.eval(op, state));

        // UInteger(-4, 0) / UInteger(2, 0) -> UReal(-2.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new UIntegerValue(2, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-2.0, 0.0), e.eval(op, state));

        // UInteger(-10, 0) / UInteger(4, 1) -> UReal(-2.5, 0.0625) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new UIntegerValue(4, 1))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-2.5, 0.0625), e.eval(op, state));

        // UInteger(-9, 9) / UInteger(-9, 0) -> UReal(1.0, -1.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, -1.0), e.eval(op, state));

        // UInteger(-2, 3) / UInteger(-2, 4) -> UReal(5.0, 2.915475947) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(-2, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 2.9154759474), e.eval(op, state));

        // UInteger(-6, 2) / UInteger(5, 0) -> UReal(-1.2, 0.4) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new UIntegerValue(5, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-1.2, 0.4), e.eval(op, state));

        // UInteger(-2, 3) / UInteger(2, 4) -> UReal(-5.0, 2.915475947) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-1.0, 2.9154759474), e.eval(op, state));

        // UInteger(0, 0) / UInteger(0, 0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0) / UInteger(0, 4) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0) / UInteger(6, 0) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(6, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) / UInteger(7, 3) -> UReal(0.0, 0.06122449) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(7, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0612244898), e.eval(op, state));

        // UInteger(0, 4) / UInteger(0, 0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4) / UInteger(0, 3) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(),  UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4) / UInteger(1, 0) -> UReal(0.0, 4.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(1, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 4.0), e.eval(op, state));

        // UInteger(0, 4) / UInteger(2, 3) -> UReal(0.0, 2.828427125) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(2, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 2.8284271247), e.eval(op, state));

        // UInteger(9, 0) / UInteger(9, 0) -> UReal(1.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.0), e.eval(op, state));

        // UInteger(5, 0) / UInteger(5, 3) -> UReal(1.0, 0.12) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new UIntegerValue(5, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.12), e.eval(op, state));

        // UInteger(4, 0) / UInteger(8, 0) -> UReal(0.5, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.5, 0.0), e.eval(op, state));

        // UInteger(10, 0) / UInteger(10, 12) -> UReal(1.0, 0.12) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new UIntegerValue(10, 12))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.12), e.eval(op, state));

        // UInteger(9, 5) / UInteger(9, 0) -> UReal(1.0, 0.555555556) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.5555555556), e.eval(op, state));

        // UInteger(2, 3) / UInteger(2, 4) -> UReal(5.0, 2.915475947) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 2.9154759474), e.eval(op, state));

        // UInteger(6, 1) / UInteger(4, 0) -> UReal(1.5, 0.25) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.5, 0.25), e.eval(op, state));

        // UInteger(2, 3) / UInteger(5, 4) -> UReal(0.4, 1.379275172) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(5, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.4, 1.379275172), e.eval(op, state));
    }

    public void testDivideByRWithUReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0) / UReal(-9, 0) -> UReal(1.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.0), e.eval(op, state));

        // UInteger(-5, 0) / UReal(-5, 3) -> UReal(1.0, 0.12) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new UIntegerValue(-5, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.12), e.eval(op, state));

        // UInteger(-4, 0) / UReal(2, 0) -> UReal(-2.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new UIntegerValue(2, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-2.0, 0.0), e.eval(op, state));

        // UInteger(-10, 0) / UReal(4, 1) -> UReal(-2.5, 0.0625) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new UIntegerValue(4, 1))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-2.5, 0.0625), e.eval(op, state));

        // UInteger(-9, 9) / UReal(-9, 0) -> UReal(1.0, -1.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, -1.0), e.eval(op, state));

        // UInteger(-2, 3) / UReal(-2, 4) -> UReal(1.0, 2.9154759474) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(-2, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 2.9154759474), e.eval(op, state));

        // UInteger(-6, 2) / UReal(5, 0) -> UReal(-1.2, 0.4) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new UIntegerValue(5, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-1.2, 0.4), e.eval(op, state));

        // UInteger(-2, 3) / UReal(2, 4) -> UReal(-1.0, 2.9154759474) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(-1.0, 2.9154759474), e.eval(op, state));

        // UInteger(0, 0) / UReal(0, 0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0) / UReal(0, 4) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0) / UReal(6, 0) -> UReal(0.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(6, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0), e.eval(op, state));

        // UInteger(0, 0) / UReal(7, 3) -> UReal(0.0, 0.0612244898) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(7, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 0.0612244898), e.eval(op, state));

        // UInteger(0, 4) / UReal(0, 0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4) / UReal(0, 3) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4) / UReal(1, 0) -> UReal(0.0, 4.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(1, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 4.0), e.eval(op, state));

        // UInteger(0, 4) / UReal(2, 3) -> UReal(0.0, 2.8284271247) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(2, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 2.8284271247), e.eval(op, state));

        // UInteger(9, 0) / UReal(9, 0) -> UReal(1.0, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.0), e.eval(op, state));

        // UInteger(5, 0) / UReal(5, 3) -> UReal(1.0, 0.12) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new UIntegerValue(5, 3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.12), e.eval(op, state));

        // UInteger(4, 0) / UReal(8, 0) -> UReal(0.5, 0.0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.5, 0.0), e.eval(op, state));

        // UInteger(10, 0) / UReal(10, 12) -> UReal(1.0, 0.12) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new UIntegerValue(10, 12))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.12), e.eval(op, state));

        // UInteger(9, 5) / UReal(9, 0) -> UReal(1.0, 0.5555555556) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.5555555556), e.eval(op, state));

        // UInteger(2, 3) / UReal(2, 4) -> UReal(1.0, 2.9154759474) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 2.9154759474), e.eval(op, state));

        // UInteger(6, 1) / UReal(4, 0) -> UReal(1.5, 0.25) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.5, 0.25), e.eval(op, state));

        // UInteger(2, 3) / UReal(5, 4) -> UReal(0.4, 1.379275172) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(5, 4))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.4, 1.379275172), e.eval(op, state));
    }

    public void testDivideByRWithReal() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) / -3.0 -> UReal(1.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(new RealValue(-3.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0), e.eval(op, state));

        // UInteger(-6, 0) / -1.2 -> UReal(5.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(new RealValue(-1.2))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(5.0, 0), e.eval(op, state));

        // UInteger(-5, 3) / -5.0 -> UReal(1.0, -0.6) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(new RealValue(-5.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, -0.6), e.eval(op, state));

        // UInteger(-8, 5) / -2.0 -> UReal(4.0, -2.5) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(new RealValue(-2.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(4.0, -2.5), e.eval(op, state));

        // UInteger(0, 0) / 0.0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(0.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0) / 3.0 -> UReal(0.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(3.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 0), e.eval(op, state));

        // UInteger(0, 3) / 0.0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new RealValue(0.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 5) / -5.0 -> UReal(0.0, -1) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(new RealValue(-5.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, -1), e.eval(op, state));

        // UInteger(5, 0) / 5.0 -> UReal(1.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new RealValue(5.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0), e.eval(op, state));

        // UInteger(3, 0) / 0.6 -> UReal(5.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(new RealValue(0.6))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(5.0, 0), e.eval(op, state));

        // UInteger(7, 3) / 7.0 -> UReal(1.0, 0.4285714286) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(new RealValue(7.0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.4285714286), e.eval(op, state));

        // UInteger(2, 5) / 0.5 -> UReal(4.0, 10) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(new RealValue(0.5))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(4.0, 10), e.eval(op, state));
    }

    public void testDivideByRWithInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0) / -3 -> UReal(1.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0), e.eval(op, state));

        // UInteger(-6, 0) / -12 -> UReal(0.5, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-12))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.5, 0), e.eval(op, state));

        // UInteger(-5, 3) / -5 -> UReal(1.0, -0.6) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, -0.6), e.eval(op, state));

        // UInteger(-8, 5) / -2 -> UReal(4.0, -2.5) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-2))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(4.0, -2.5), e.eval(op, state));

        // UInteger(0, 0) / 0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0) / 3 -> UReal(0.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(3))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, 0), e.eval(op, state));

        // UInteger(0, 3) / 0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 5) / -5 -> UReal(0.0, -1) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0, -1), e.eval(op, state));

        // UInteger(5, 0) / 5 -> UReal(1.0, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(5))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0), e.eval(op, state));

        // UInteger(3, 0) / 56 -> UReal(0.0535714286, 0) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(56))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0535714286, 0), e.eval(op, state));

        // UInteger(7, 3) / 7 -> UReal(1.0, 0.4285714286) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(7))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(1.0, 0.4285714286), e.eval(op, state));

        // UInteger(2, 5) / 65 -> UReal(0.0, 0.0769230769) : UReal
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(65))
        };
        op = ExpStdOp.create("/", args);
        assertEquals(op.toString(), new URealValue(0.0307692308, 0.0769230769), e.eval(op, state));
    }

    // Div operation

    public void testDivideByBetweenUInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0)  div UInteger(-9, 0) -> UInteger(1, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.0), e.eval(op, state));

        // UInteger(-5, 0)  div UInteger(-5, 3) -> UInteger(1, 0.12) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new UIntegerValue(-5, 3))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.12), e.eval(op, state));

        // UInteger(-4, 0)  div UInteger(2, 0) -> UInteger(-2, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new UIntegerValue(2, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(-2, 0.0), e.eval(op, state));

        // UInteger(-10, 0)  div UInteger(4, 1) -> UInteger(-2, 0.0625) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new UIntegerValue(4, 1))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(-2, 0.0625), e.eval(op, state));

        // UInteger(-9, 9)  div UInteger(-9, 0) -> UInteger(1, -1.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, -1.0), e.eval(op, state));

        // UInteger(-2, 3)  div UInteger(-2, 4) -> UInteger(1, 2.9154759474) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(-2, 4))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 2.9154759474), e.eval(op, state));

        // UInteger(-6, 2)  div UInteger(5, 0) -> UInteger(-1, 0.4) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new UIntegerValue(5, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(-1, 0.4), e.eval(op, state));

        // UInteger(-2, 3)  div UInteger(2, 4) -> UInteger(-1, 2.9154759474) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(-1, 2.9154759474), e.eval(op, state));

        // UInteger(0, 0)  div UInteger(0, 0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0)  div UInteger(0, 4) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 4))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0)  div UInteger(6, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(6, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0)  div UInteger(7, 3) -> UInteger(0, 0.0612244898) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(7, 3))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0612244898), e.eval(op, state));

        // UInteger(0, 4)  div UInteger(0, 0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4)  div UInteger(0, 3) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 3))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4)  div UInteger(1, 0) -> UInteger(0, 4.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(1, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 4.0), e.eval(op, state));

        // UInteger(0, 4)  div UInteger(2, 3) -> UInteger(0, 2.8284271247) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(2, 3))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 2.8284271247), e.eval(op, state));

        // UInteger(9, 0)  div UInteger(9, 0) -> UInteger(1, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.0), e.eval(op, state));

        // UInteger(5, 0)  div UInteger(5, 3) -> UInteger(1, 0.12) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new UIntegerValue(5, 3))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.12), e.eval(op, state));

        // UInteger(4, 0)  div UInteger(8, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(10, 0)  div UInteger(10, 12) -> UInteger(1, 0.12) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new UIntegerValue(10, 12))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.12), e.eval(op, state));

        // UInteger(9, 5)  div UInteger(9, 0) -> UInteger(1, 0.5555555556) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.5555555556), e.eval(op, state));

        // UInteger(2, 3)  div UInteger(2, 4) -> UInteger(1, 2.9154759474) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 2.9154759474), e.eval(op, state));

        // UInteger(6, 1)  div UInteger(4, 0) -> UInteger(1, 0.25) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.25), e.eval(op, state));

        // UInteger(2, 3)  div UInteger(5, 4) -> UInteger(0, 1.379275172) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(5, 4))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 1.379275172), e.eval(op, state));
    }

    public void testDivideByWithInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0)  div -3 -> UInteger(1, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-3))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0), e.eval(op, state));

        // UInteger(-6, 0)  div -12 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-12))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(-5, 3)  div -5 -> UInteger(1, -0.6) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, -0.6), e.eval(op, state));

        // UInteger(-8, 5)  div -2 -> UInteger(4, -2.5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-2))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(4, -2.5), e.eval(op, state));

        // UInteger(0, 0)  div 0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0)  div 3 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(3))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(0, 3)  div 0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 5)  div -5 -> UInteger(0, -1) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, -1), e.eval(op, state));

        // UInteger(5, 0)  div 5 -> UInteger(1, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(5))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0), e.eval(op, state));

        // UInteger(3, 0)  div 56 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(56))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(7, 3)  div 7 -> UInteger(1, 0.4285714286) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(7))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.4285714286), e.eval(op, state));

        // UInteger(2, 5)  div 65 -> UInteger(0, 0.0769230769) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(65))
        };
        op = ExpStdOp.create("div", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0769230769), e.eval(op, state));
    }


    // MOD OPERATOR

    public void testModBetweenUInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-9, 0)  mod UInteger(-9, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 0)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(-5, 0)  mod UInteger(-5, 3) -> UInteger(0, 0.12) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 0)),
                new ExpressionWithValue(new UIntegerValue(-5, 3))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.12), e.eval(op, state));

        // UInteger(-4, 0)  mod UInteger(2, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-4, 0)),
                new ExpressionWithValue(new UIntegerValue(2, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(-10, 0)  mod UInteger(4, 1) -> UInteger(2, 0.0625) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-10, 0)),
                new ExpressionWithValue(new UIntegerValue(4, 1))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(-2, 0.0625), e.eval(op, state));

        // UInteger(-9, 9)  mod UInteger(-9, 0) -> UInteger(0, -1.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-9, 9)),
                new ExpressionWithValue(new UIntegerValue(-9, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, -1.0), e.eval(op, state));

        // UInteger(-2, 3)  mod UInteger(-2, 4) -> UInteger(0, 2.9154759474) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(-2, 4))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 2.9154759474), e.eval(op, state));

        // UInteger(-6, 2)  mod UInteger(5, 0) -> UInteger(4, 0.4) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 2)),
                new ExpressionWithValue(new UIntegerValue(5, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(-1, 0.4), e.eval(op, state));

        // UInteger(-2, 3)  mod UInteger(2, 4) -> UInteger(0, 2.9154759474) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 2.9154759474), e.eval(op, state));

        // UInteger(0, 0)  mod UInteger(0, 0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0)  mod UInteger(0, 4) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(0, 4))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0)  mod UInteger(6, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(6, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0)  mod UInteger(7, 3) -> UInteger(0, 0.0612244898) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new UIntegerValue(7, 3))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0612244898), e.eval(op, state));

        // UInteger(0, 4)  mod UInteger(0, 0) ->  Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4)  mod UInteger(0, 3) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(0, 3))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4)  mod UInteger(1, 0) -> UInteger(0, 4.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(1, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 4.0), e.eval(op, state));

        // UInteger(0, 4)  mod UInteger(2, 3) -> UInteger(0, 2.8284271247) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new UIntegerValue(2, 3))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 2.8284271247), e.eval(op, state));

        // UInteger(9, 0)  mod UInteger(9, 0) -> UInteger(0, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 0)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(5, 0)  mod UInteger(5, 3) -> UInteger(0, 0.12) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(new UIntegerValue(5, 3))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.12), e.eval(op, state));

        // UInteger(4, 0)  mod UInteger(8, 0) -> UInteger(4, 0.0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new UIntegerValue(8, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(4, 0.0), e.eval(op, state));

        // UInteger(10, 0)  mod UInteger(10, 12) -> UInteger(0, 0.12) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(10, 0)),
                new ExpressionWithValue(new UIntegerValue(10, 12))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.12), e.eval(op, state));

        // UInteger(9, 5)  mod UInteger(9, 0) -> UInteger(0, 0.5555555556) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(9, 5)),
                new ExpressionWithValue(new UIntegerValue(9, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.5555555556), e.eval(op, state));

        // UInteger(2, 3)  mod UInteger(2, 4) -> UInteger(0, 2.9154759474) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(2, 4))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 2.9154759474), e.eval(op, state));

        // UInteger(6, 1)  mod UInteger(4, 0) -> UInteger(2, 0.25) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(6, 1)),
                new ExpressionWithValue(new UIntegerValue(4, 0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(2, 0.25), e.eval(op, state));

        // UInteger(2, 3)  mod UInteger(5, 4) -> UInteger(2, 1.379275172) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3)),
                new ExpressionWithValue(new UIntegerValue(5, 4))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(2, 1.379275172), e.eval(op, state));
    }

    public void testModWithInteger() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(-3, 0)  mod -3 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-3))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(-6, 0)  mod -12 -> UInteger(6, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-6, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(-12))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(-6, 0), e.eval(op, state));

        // UInteger(-5, 3)  mod -5 -> UInteger(0, -0.6) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-5, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, -0.6), e.eval(op, state));

        // UInteger(-8, 5)  mod -2 -> UInteger(0, -2.5) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(-8, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-2))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, -2.5), e.eval(op, state));

        // UInteger(0, 0)  mod 0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0)  mod 3 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(3))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(0, 3)  mod 0 -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(0))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 5)  mod -5 -> UInteger(0, -1) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(-5))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, -1), e.eval(op, state));

        // UInteger(5, 0)  mod 5 -> UInteger(0, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(5, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(5))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0), e.eval(op, state));

        // UInteger(3, 0)  mod 56 -> UInteger(3, 0) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(IntegerValue.valueOf(56))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(3, 0), e.eval(op, state));

        // UInteger(7, 3)  mod 7 -> UInteger(0, 0.4285714286) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(7, 3)),
                new ExpressionWithValue(IntegerValue.valueOf(7))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.4285714286), e.eval(op, state));

        // UInteger(2, 5)  mod 65 -> UInteger(2, 0.0769230769) : UInteger
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 5)),
                new ExpressionWithValue(IntegerValue.valueOf(65))
        };
        op = ExpStdOp.create("mod", args);
        assertEquals(op.toString(), new UIntegerValue(2, 0.0769230769), e.eval(op, state));
    }

    // Testing power

    public void testPower() throws ExpInvalidException {
        Expression [] args;
        Expression op;

        // UInteger(0, 0).power(0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(0))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0).power(3) -> UInteger(0.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(3))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 0).power(-2) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(-2))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 0).power(3.5) -> UInteger(0.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 0)),
                new ExpressionWithValue(new RealValue(3.5))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 2).power(0) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 2)),
                new ExpressionWithValue(new RealValue(0))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 4).power(3) -> UInteger(0.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 4)),
                new ExpressionWithValue(new RealValue(3))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(0, 3).power(-3) -> Undefined : OclVoid
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 3)),
                new ExpressionWithValue(new RealValue(-3))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));

        // UInteger(0, 1).power(3.5) -> UInteger(0.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(0, 1)),
                new ExpressionWithValue(new RealValue(3.5))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0), e.eval(op, state));

        // UInteger(3, 0).power(0) -> UInteger(1.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(3, 0)),
                new ExpressionWithValue(new RealValue(0))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.0), e.eval(op, state));

        // UInteger(2, 0).power(3) -> UInteger(8.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 0)),
                new ExpressionWithValue(new RealValue(3))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(8, 0.0), e.eval(op, state));

        // UInteger(4, 0).power(-2) -> UInteger(0, 0.0625)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new RealValue(-2))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(0, 0.0625), e.eval(op, state));

        // UInteger(4, 0).power(1.5) -> UInteger(8.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(4, 0)),
                new ExpressionWithValue(new RealValue(1.5))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(8, 0.0), e.eval(op, state));

        // UInteger(1.5, 3.2).power(0) -> UInteger(1.0, 0.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 3.2)), // 1.5 -> 2
                new ExpressionWithValue(new RealValue(0))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.0), e.eval(op, state));

        // UInteger(2, 4).power(4) -> UInteger(16.0, 128.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(2, 4)),
                new ExpressionWithValue(new RealValue(4))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(16, 128.0), e.eval(op, state));

        // UInteger(1, 3).power(-2) -> UInteger(1.0, 6.0)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(1, 3)),
                new ExpressionWithValue(new RealValue(-2))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(1, 6.0), e.eval(op, state));

        // UInteger(1, 2).power(0.25) -> UInteger(1.0, 0.5)
        args = new Expression[] {
                new ExpressionWithValue(new UIntegerValue(1, 2)),
                new ExpressionWithValue(new RealValue(0.25))
        };
        op = ExpStdOp.create("power", args);
        assertEquals(op.toString(), new UIntegerValue(1, 0.5), e.eval(op, state));

    }

}
