package org.tzi.use.uml.ocl.value;

import junit.framework.TestCase;
import org.tzi.use.uml.ocl.type.TypeFactory;

public class UIntegerValueTest extends TestCase {

    /**
     * Testing constructor, value(), uncertainty() and toString()
     */

    public void testValues() {
        UIntegerValue uiv;
        int value;
        double uncertainty;
        String stringUInteger;

        Object [][] testCases= new Object [][] {
                {5,   5.0,    "UInteger(5, 5.0)"},
                {5,   0.0,    "UInteger(5, 0.0)"},
                {5,  -5.0,    "UInteger(5, 5.0)"},
                {5,  -5.53,    "UInteger(5, 5.53)"},
                {0,   5.0,    "UInteger(0, 5.0)"},
                {0,   0.0,    "UInteger(0, 0.0)"},
                {0,  -5.0,    "UInteger(0, 5.0)"},
                {0,  -5.45,    "UInteger(0, 5.45)"},
                {-5,  5.0,    "UInteger(-5, 5.0)"},
                {-5,  0.0,    "UInteger(-5, 0.0)"},
                {-5, -5.0,    "UInteger(-5, 5.0)"},
                {-5, -5.223,    "UInteger(-5, 5.223)"}
        };

        for (int i = 0 ; i < testCases.length ; i++) {
            value = (Integer) testCases[i][0];
            uncertainty = (Double) testCases[i][1];
            stringUInteger = (String) testCases[i][2];
            uiv = new UIntegerValue(value, uncertainty);
            assertEquals("UIntegerValue.value", value, uiv.value());
            assertEquals("UIntegerValue.uncertainty", Math.abs(uncertainty), uiv.uncertainty());
            assertEquals("UIntegerValue.toString", stringUInteger, uiv.toString(new StringBuilder()).toString());
        }
    }

    public void testType() {
        UIntegerValue uiv = new UIntegerValue(5,5);

        assertEquals("UInteger.type", TypeFactory.mkUInteger(), uiv.type());
    }

    public void testIsTypeOf() {
        UIntegerValue uiv = new UIntegerValue(5, 5);
        assertFalse("UInteger.isBag", uiv.isBag());
        assertFalse("UInteger.isCollection", uiv.isCollection());
        assertFalse("UInteger.isSequence", uiv.isSequence());
        assertFalse("UInteger.isSet", uiv.isSet());
        assertFalse("UInteger.isOrderedSet", uiv.isOrderedSet());
        assertFalse("UInteger.isBoolean", uiv.isBoolean());
        assertFalse("UInteger.isInteger", uiv.isInteger());
        assertFalse("UInteger.isReal", uiv.isReal());
        assertFalse("UInteger.isUReal", uiv.isUReal());
        assertFalse("UInteger.isUnlimitedNatural", uiv.isUnlimitedNatural());
        assertFalse("UInteger.isObject", uiv.isObject());
        assertFalse("UInteger.isLink", uiv.isLink());
        assertFalse("UInteger.isUBoolean", uiv.isUBoolean());
        assertTrue ("UInteger.isUInteger", uiv.isUInteger());
    }

}