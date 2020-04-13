package org.tzi.use.uml.ocl.expr;

import junit.framework.TestCase;
import org.tzi.use.uml.mm.ModelFactory;
import org.tzi.use.uml.ocl.type.TypeFactory;
import org.tzi.use.uml.ocl.value.*;
import org.tzi.use.uml.sys.MSystem;
import org.tzi.use.uml.sys.MSystemState;

public class ExpQueryUncertaintyTest extends TestCase {

    private MSystemState state;
    private Evaluator e;

    /**
     * Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}
     */
    private Expression setA;
    /**
     * Sequence{UReal(52, 0.5), 3.2, 2, UReal(-53, 20), UReal(20, 5)}
     */
    private Expression seqB;

    /**
     * Sequence{UInteger(2, 2.3), 3, UInteger(1,0.5)}
     */
    private Expression seqC;

    /**
     * Sequence{UReal(2, 3), Undefined}
     */
    private Expression seqWithUndefined;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        state = new MSystem(new ModelFactory().createModel("Test")).state();
        e = new Evaluator();

        // Set{UReal(2, 0.5), 1, 2.5, 3.2, UReal(3.5, 0.25)}
        Value[] args1 = new Value[]{
                new URealValue(2, 0.5),
                IntegerValue.valueOf(1),
                new RealValue(2.5),
                new RealValue(3.2),
                new URealValue(3.5, 0.25)};
        setA = new ExpressionWithValue(new SetValue(TypeFactory.mkUReal(), args1));


        // Sequence{UReal(52, 0.5), 3.2, 2, UReal(-53, 20), UReal(20, 5)}
        Value [] args2 = new Value [] {
                new URealValue(52, 0.5),
                new RealValue(3.2),
                IntegerValue.valueOf(2),
                new URealValue(-53, 20),
                new URealValue(20, 5)
        };
        seqB = new ExpressionWithValue(new SequenceValue(TypeFactory.mkUReal(), args2));

        // Sequence{UInteger(2, 2.3), 3, UInteger(1,0.5)}
        Value [] args3 = new Value [] {
                new UIntegerValue(2, 2.3),
                IntegerValue.valueOf(3),
                new UIntegerValue(1, 0.5)
        };
        seqC = new ExpressionWithValue(new SequenceValue(TypeFactory.mkUInteger(), args3));

        // Sequence{UReal(2, 3), Undefined}
        Value [] args4 = new Value [] {
                new URealValue(2, 3),
                UndefinedValue.instance
        };
        seqWithUndefined = new ExpressionWithValue(new SequenceValue(TypeFactory.mkUReal(), args4));

    }

    // TESTING FOR ALL

    public void testForAllColA() throws ExpInvalidException {
        VarDeclList elemVars = new VarDeclList(true);
        elemVars.add(new VarDecl("e1", TypeFactory.mkUReal()));
        Expression [] args = new Expression [] {
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(0)
        };
        ExpStdOp op = ExpStdOp.create(">", args);
        Expression exp = new ExpForAll(elemVars, setA, op);
        assertEquals(exp.toString(), UBooleanValue.valueOf(true, 0.999968314), e.eval(exp, state));
    }

    // TESTING EXISTS

    public void testExistsA() throws ExpInvalidException{
        VarDeclList elemVars = new VarDeclList(true);
        elemVars.add(new VarDecl("e1", TypeFactory.mkUReal()));
        Expression [] args = new Expression [] {
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(3.2)
        };
        ExpStdOp op = ExpStdOp.create(">=", args);
        Expression exp = new ExpExists(elemVars, setA, op);
        assertEquals(exp.toString(), UBooleanValue.TRUE, e.eval(exp, state));
    }


    // TESTING USELECT

    public void testUSelectColA() throws ExpInvalidException {
        VarDecl varDecl = new VarDecl("e1", TypeFactory.mkUReal());
        Expression [] args = new Expression[]{
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(2)
        };
        ExpStdOp op = ExpStdOp.create(">=", args);
        Expression expUSelect = new ExpUSelect(varDecl, setA, op);
        // Collection expected
        Value [] expectedValues = new Value[]{
                new RealValue(2.5),
                new RealValue(3.2),
                new URealValue(3.5, 0.25)
        };
        // Assert
        assertEquals(op.toString(),
                new SetValue(TypeFactory.mkUReal(), expectedValues),
                e.eval(expUSelect, state));
    }

    public void testUSelectColANoMatches() throws ExpInvalidException {
        VarDecl varDecl = new VarDecl("e1", TypeFactory.mkUReal());
        Expression [] args = new Expression[]{
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(50)
        };
        ExpStdOp op = ExpStdOp.create(">=", args);
        Expression expUSelect = new ExpUSelect(varDecl, setA, op);
        // Collection expected
        Value [] expectedValues = new Value[]{ /*empty*/ };
        // Assert
        assertEquals(op.toString(),
                new SetValue(TypeFactory.mkUReal(), expectedValues),
                e.eval(expUSelect, state));
    }

    // TESTING USELECTC

    public void testUSelectCUncertaintyErrorType() throws ExpInvalidException {
        VarDecl varDecl = new VarDecl("e1", TypeFactory.mkUReal());
        Expression [] args = new Expression[]{
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(2)
        };
        ExpStdOp op = ExpStdOp.create(">=", args);
        // Assert
        try {
            new ExpUSelectC(varDecl, setA, op, new ExpConstString("testing"));
            fail("ExpInvalidException expected!");
        }
        catch (ExpInvalidException exp) {
            // Success
        }
        catch (Exception ex) {
            fail("ExpInvalidException expected, found : " + ex.getClass().getName());
        }
    }

    public void testUSelectCUncertaintyHigherThanOne() throws ExpInvalidException {
        VarDecl varDecl = new VarDecl("e1", TypeFactory.mkUReal());
        Expression [] args = new Expression[]{
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(2)
        };
        ExpStdOp op = ExpStdOp.create(">=", args);
        // Assert
        try {
            new ExpUSelectC(varDecl, setA, op, new ExpConstReal(2));
            e.eval(op, state);
            fail("RuntimeException expected!");
        }
        catch (RuntimeException exp) {
            // Success
        }
        catch (Exception ex) {
            fail("RuntimeException expected, found : " + ex.getClass().getName());
        }
    }

    public void testUSelectCUncertaintyLowerThanZero() throws ExpInvalidException {
        VarDecl varDecl = new VarDecl("e1", TypeFactory.mkUReal());
        Expression [] args = new Expression[]{
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(2)
        };
        ExpStdOp op = ExpStdOp.create(">=", args);
        // Assert
        try {
            new ExpUSelectC(varDecl, setA, op, new ExpConstReal(-2));
            e.eval(op, state);
            fail("RuntimeException expected!");
        }
        catch (RuntimeException exp) {
            // Success
        }
        catch (Exception ex) {
            fail("RuntimeException expected, found : " + ex.getClass().getName());
        }
    }

    public void testUSelectCColA() throws ExpInvalidException {
        VarDecl varDecl = new VarDecl("e1", TypeFactory.mkUReal());
        Expression [] args = new Expression[]{
                new ExpVariable("e1", TypeFactory.mkUReal()),
                new ExpConstReal(2)
        };
        ExpStdOp op = ExpStdOp.create(">=", args);
        Expression expUSelect = new ExpUSelectC(varDecl, setA, op, new ExpConstReal(0.8));
        // Collection expected
        Value [] expectedValues = new Value[]{
                new RealValue(2.5),
                new RealValue(3.2),
                new URealValue(3.5, 0.25)
        };
        // Assert
        assertEquals(op.toString(),
                new SetValue(TypeFactory.mkUReal(), expectedValues),
                e.eval(expUSelect, state));
    }


    // TESTING SUM

    public void testSum() throws ExpInvalidException  {
        ExpStdOp op = ExpStdOp.create("sum", new Expression [] {setA});
        assertEquals(op.toString(), new URealValue(12.2, 0.5590169944), e.eval(op, state));
    }

    public void testSumSeqB() throws ExpInvalidException {
        ExpStdOp op = ExpStdOp.create("sum", new Expression[] {seqB});
        assertEquals(op.toString(), new URealValue(24.2, 20.6215906273), e.eval(op, state));
    }

    public void testSumSeqC() throws ExpInvalidException {
        ExpStdOp op = ExpStdOp.create("sum", new Expression[] {seqC});
        assertEquals(op.toString(), new UIntegerValue(6, 2.3537204592), e.eval(op, state));
    }

    public void testSumSeqWithUndefined() throws ExpInvalidException {
        ExpStdOp op = ExpStdOp.create("sum", new Expression[]{seqWithUndefined});
        assertEquals(op.toString(), UndefinedValue.instance, e.eval(op, state));
    }
}
