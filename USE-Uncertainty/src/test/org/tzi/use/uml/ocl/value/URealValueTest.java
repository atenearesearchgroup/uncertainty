package org.tzi.use.uml.ocl.value;

import junit.framework.TestCase;
import org.tzi.use.uml.ocl.type.TypeFactory;

import java.util.HashSet;

import static org.junit.Assert.*;

public class URealValueTest extends TestCase {

    public void testType() {
        URealValue urv = new URealValue(5,5);

        assertEquals("UReal.type", TypeFactory.mkUReal(), urv.type());
    }

    public void testValues() {
        URealValue urv;
        double value, uncertainty;
        String stringUreal;

        Object [][] testCases= new Object [][] {
                {5.0,   5.0,    "UReal(5.0, 5.0)"},
                {5.0,   0.0,    "UReal(5.0, 0.0)"},
                {5.0,  -5.0,    "UReal(5.0, 5.0)"},
                {0.0,   5.0,    "UReal(0.0, 5.0)"},
                {0.0,   0.0,    "UReal(0.0, 0.0)"},
                {0.0,  -5.0,    "UReal(0.0, 5.0)"},
                {-5.0,  5.0,    "UReal(-5.0, 5.0)"},
                {-5.0,  0.0,    "UReal(-5.0, 0.0)"},
                {-5.0, -5.0,    "UReal(-5.0, 5.0)"},
                {5.556, 5.556,  "UReal(5.556, 5.556)"},
                {5.556, 0.593,  "UReal(5.556, 0.593)"},
                {5.556,-5.556,  "UReal(5.556, 5.556)"},
                {0.593, 5.556,  "UReal(0.593, 5.556)"},
                {0.593, 0.593,  "UReal(0.593, 0.593)"},
                {0.593,-5.556,  "UReal(0.593, 5.556)"},
                {-5.556, 5.556, "UReal(-5.556, 5.556)"},
                {-5.556, 0.593, "UReal(-5.556, 0.593)"},
                {-5.556,-5.556, "UReal(-5.556, 5.556)"}
        };

        for (int i = 0 ; i < testCases.length ; i++) {
            value = (Double) testCases[i][0];
            uncertainty = (Double) testCases[i][1];
            stringUreal = (String) testCases[i][2];
            urv = new URealValue(value, uncertainty);
            assertEquals("URealValue.value", value, urv.value());
            assertEquals("URealValue.uncertainty", Math.abs(uncertainty), urv.uncertainty());
            assertEquals("URealValue.value", stringUreal, urv.toString(new StringBuilder()).toString());
        }

    }

    public void testIsTypeOf() {
        URealValue urv = new URealValue(5.0, 5);
        assertFalse("UReal.isBag", urv.isBag());
        assertFalse("UReal.isCollection", urv.isCollection());
        assertFalse("UReal.isSequence", urv.isSequence());
        assertFalse("UReal.isSet", urv.isSet());
        assertFalse("UReal.isOrderedSet", urv.isOrderedSet());
        assertFalse("UReal.isBoolean", urv.isBoolean());
        assertFalse("UReal.isInteger", urv.isInteger());
        assertFalse("UReal.isReal", urv.isReal());
        assertTrue("UReal.isUReal", urv.isUReal());
        assertFalse("UReal.isUnlimitedNatural", urv.isUnlimitedNatural());
        assertFalse("UReal.isObject", urv.isObject());
        assertFalse("UReal.isLink", urv.isLink());
        assertFalse("UReal.isUBoolean", urv.isUBoolean());
        assertFalse("UReal.isUInteger", urv.isUInteger());
    }

    public void testCompareTo() {
        URealValue a;
        Value b;

        // Tipos UReal
        a = new URealValue(0, 0);
        b = new URealValue(0, 0);
        assertEquals(
                "UReal(0, 0) = UReal(0, 0)",
                0,
                a.compareTo(b));

        a = new URealValue(0, 0);
        b = new URealValue(1, 0);
        assertEquals(
                "UReal(0, 0) < UReal(1, 0)",
                -1,
                a.compareTo(b));

        a = new URealValue(3, 0);
        b = new URealValue(0, 0);
        assertEquals(
                "UReal(3, 0) > UReal(0, 0)",
                1,
                a.compareTo(b));

        a = new URealValue(0, 0);
        b = new URealValue(3, 2);
        assertEquals(
                "UReal(0, 0) < UReal(3, 2)",
                -1,
                a.compareTo(b));

        a = new URealValue(3, 0);
        b = new URealValue(0, 2);
        assertEquals(
                "UReal(3, 0) > UReal(0, 2)",
                1,
                a.compareTo(b));

        a = new URealValue(0, 2);
        b = new URealValue(3, 0);
        assertEquals(
                "UReal(0, 2) < UReal(3, 0)",
                -1,
                a.compareTo(b));

        a = new URealValue(3, 2);
        b = new URealValue(0, 0);
        assertEquals(
                "UReal(3, 2) > UReal(0, 0)",
                1,
                a.compareTo(b));

        a = new URealValue(0, 2);
        b = new URealValue(0, 2);
        assertEquals(
                "UReal(0, 2) = UReal(0, 2)",
                0,
                a.compareTo(b));

        a = new URealValue(0, 2);
        b = new URealValue(0, 1);
        assertEquals(
                "UReal(0, 2) = UReal(0, 1)",
                0,
                a.compareTo(b));

        a = new URealValue(0, 2);
        b = new URealValue(1, 1);
        assertEquals(
                "UReal(0, 2) = UReal(1, 1)",
                0,
                a.compareTo(b));

        a = new URealValue(0, 2);
        b = new URealValue(-1, 1);
        assertEquals(
                "UReal(0, 2) = UReal(-1, 1)",
                0,
                a.compareTo(b));

        a = new URealValue(0, 2);
        b = new URealValue(5, 2);
        assertEquals(
                "UReal(0, 2) = UReal(5, 2)",
                -1,
                a.compareTo(b));

        a = new URealValue(5, 2);
        b = new URealValue(0, 2);
        assertEquals(
                "UReal(5, 2) = UReal(0, 2)",
                1,
                a.compareTo(b));

        // Real

        a = new URealValue(0, 0);
        b = new RealValue(0);
        assertEquals(
                "UReal(0, 0) = 0.0",
                0,
                a.compareTo(b));

        a = new URealValue(0, 0);
        b = new RealValue(1);
        assertEquals(
                "UReal(0, 0) < 1.0",
                -1,
                a.compareTo(b));

        a = new URealValue(1, 0);
        b = new RealValue(0);
        assertEquals(
                "UReal(0, 0) > 1.0",
                1,
                a.compareTo(b));

        a = new URealValue(1, 2);
        b = new RealValue(3);
        assertEquals(
                "UReal(1, 2) < 3.0",
                -1,
                a.compareTo(b));

        a = new URealValue(3, 2);
        b = new RealValue(0);
        assertEquals(
                "UReal(1, 2) > 3.0",
                1,
                a.compareTo(b));


        // Integer

        a = new URealValue(0, 0);
        b = IntegerValue.valueOf(0);
        assertEquals(
                "UReal(0, 0) = 0",
                0,
                a.compareTo(b));

        a = new URealValue(0, 0);
        b = IntegerValue.valueOf(1);
        assertEquals(
                "UReal(0, 0) < 1",
                -1,
                a.compareTo(b));

        a = new URealValue(1, 0);
        b = IntegerValue.valueOf(0);
        assertEquals(
                "UReal(0, 0) > 0",
                1,
                a.compareTo(b));

        a = new URealValue(1, 2);
        b = IntegerValue.valueOf(3);
        assertEquals(
                "UReal(1, 2) < 3",
                -1,
                a.compareTo(b));

        a = new URealValue(3, 2);
        b = IntegerValue.valueOf(0);
        assertEquals(
                "UReal(1, 2) > 0",
                1,
                a.compareTo(b));


    }

    public void testIdentical() {
        URealValue a;
        Value b;

        a = new URealValue(-2, 3);
        b = new URealValue(-2, 3);
        assertTrue("UReal(-2, 3).equals(UReal(-2, 3))", a.equals(b));

        a = new URealValue(-2, 3);
        b = new URealValue(0, 3);
        assertFalse("not UReal(-2, 3).equals(UReal(0, 3))", a.equals(b));

        a = new URealValue(2, 3);
        b = new URealValue(2, 0);
        assertFalse("not UReal(2, 3).equals(UReal(2, 0))", a.equals(b));

        a = new URealValue(2, 3);
        b = new URealValue(1, 0);
        assertFalse("not UReal(2, 3).equals(UReal(1, 0))", a.equals(b));

        // Real
        a = new URealValue(-2, 3);
        b = new RealValue(-2);
        assertFalse("UReal(-2, 3).equals(-2)", a.equals(b));

        a = new URealValue(-2, 0);
        b = new RealValue(-2);
        assertTrue("UReal(-2, 3).equals(-2)", a.equals(b));

        a = new URealValue(-2, 0);
        b = new RealValue(1);
        assertFalse("UReal(-2, 3).equals(2)", a.equals(b));

        a = new URealValue(-2, 3);
        b = new RealValue(1);
        assertFalse("UReal(-2, 3).equals(2)", a.equals(b));

        // Integer
        a = new URealValue(-2, 3);
        b = IntegerValue.valueOf(-2);
        assertFalse("UReal(-2, 3).equals(-2)", a.equals(b));

        a = new URealValue(-2, 0);
        b = IntegerValue.valueOf(-2);
        assertTrue("UReal(-2, 3).equals(-2)", a.equals(b));

        a = new URealValue(-2, 0);
        b = IntegerValue.valueOf(1);
        assertFalse("UReal(-2, 3).equals(2)", a.equals(b));

        a = new URealValue(-2, 3);
        b = IntegerValue.valueOf(1);
        assertFalse("UReal(-2, 3).equals(2)", a.equals(b));

        // Otro
        a = new URealValue(-2, 3);
        b = new StringValue("testing");
        assertFalse("UReal(-2, 3).equals(-2)", a.equals(b));


    }

}