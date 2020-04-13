package org.tzi.use.uml.ocl.value;

import junit.framework.TestCase;

public class UBooleanValueTest extends TestCase {

    public void testValues() {
        UBooleanValue uBoolean;

        // FIXME: When It will be fixed in atenea library.
        /*
        try {
            uBoolean = UBooleanValue.valueOf(true, -2);
            fail("Exception expected\n");
        }
        catch (Exception ex) { }
        */

        uBoolean = UBooleanValue.FALSE;
        assertTrue(uBoolean.value());
        assertEquals(0.0, uBoolean.probability());
        assertEquals("UBoolean(true, 0.0)", uBoolean.toString());

        uBoolean = UBooleanValue.valueOf(true, 0.5);
        assertTrue(uBoolean.value());
        assertEquals(0.5, uBoolean.probability());
        assertEquals("UBoolean(true, 0.5)", uBoolean.toString());

        uBoolean = UBooleanValue.TRUE;
        assertTrue(uBoolean.value());
        assertEquals(1.0, uBoolean.probability());
        assertEquals("UBoolean(true, 1.0)", uBoolean.toString());


        // FIXME: When It will be fixed in atenea library.
        /*
        try {
            uBoolean = UBooleanValue.valueOf(true, 2);
            fail("Exception expected : UBoolean(true, 2)\n");
        }
        catch (Exception ex) { }
        */

        uBoolean = UBooleanValue.valueOf(false, 0.5);
        assertTrue(uBoolean.value());
        assertEquals(0.5, uBoolean.probability());
        assertEquals("UBoolean(true, 0.5)", uBoolean.toString());

        uBoolean = UBooleanValue.valueOf(false, 1);
        assertTrue(uBoolean.value());
        assertEquals(0.0, uBoolean.probability());
        assertEquals("UBoolean(true, 0.0)", uBoolean.toString());

        uBoolean = UBooleanValue.valueOf(false, 0.2);
        assertTrue(uBoolean.value());
        assertEquals(0.8, uBoolean.probability());
        assertEquals("UBoolean(true, 0.8)", uBoolean.toString());

    }

    public void testIsTypeOf() {
        Value ubv = UBooleanValue.FALSE;
        assertFalse("UBoolean.isBag", ubv.isBag());
        assertFalse("UBoolean.isCollection", ubv.isCollection());
        assertFalse("UBoolean.isSequence", ubv.isSequence());
        assertFalse("UBoolean.isSet", ubv.isSet());
        assertFalse("UBoolean.isOrderedSet", ubv.isOrderedSet());
        assertFalse("UBoolean.isBoolean", ubv.isBoolean());
        assertFalse("UBoolean.isInteger", ubv.isInteger());
        assertFalse("UBoolean.isReal", ubv.isReal());
        assertFalse("UBoolean.isUReal", ubv.isUReal());
        assertFalse("UBoolean.isUnlimitedNatural", ubv.isUnlimitedNatural());
        assertFalse("UBoolean.isObject", ubv.isObject());
        assertFalse("UBoolean.isLink", ubv.isLink());
        assertTrue("UBoolean.isUBoolean", ubv.isUBoolean());
        assertFalse("UBoolean.isUInteger", ubv.isUInteger());
    }

    public void testEquals() {
        /*
         Partition :
         1. this
            1.1. value          (true)
            1.2. probability    (zero)
         2. other
            2.1. type           (UBoolean, other)
            2.2. nullable       (yes, no)
            2.3. value          (same this.value, distinct this.value)
            2.4. probability    (same this.u, 1 - this.u, distinct this.u)

         Conditions.
         - If type isn't UBoolean, doesn't matter to test more of 2.*
         - If other is nullable, cannot have any value or probability
         */
        UBooleanValue a;
        Value b;

        // (true, zero, UBoolean, yes, -, -)
        a = UBooleanValue.FALSE;
        b = null;
        assertFalse(a.equals(b));

        // (true, zero, UBoolean, no, same, same)
        a = UBooleanValue.FALSE;
        b = UBooleanValue.FALSE;
        assertTrue(a.equals(b));
        assertEquals(a.hashCode(), b.hashCode());

        // (true, zero, UBoolean, no, same, distinct)
        a = UBooleanValue.FALSE;
        b = UBooleanValue.valueOf(true, 0.5);
        assertFalse(a.equals(b));
        assertFalse(a.hashCode() == b.hashCode());

        // (true, zero, UBoolean, no, same, 1 - this.u)
        a = UBooleanValue.FALSE;
        b = UBooleanValue.TRUE;
        assertFalse(a.equals(b));
        assertFalse(a.hashCode() == b.hashCode());


        // (true, zero, UBoolean, no, distinct, same)
        a = UBooleanValue.FALSE;
        b = UBooleanValue.valueOf(false, 0);
        assertFalse(a.equals(b));
        assertFalse(a.hashCode() == b.hashCode());

        // (true, zero, UBoolean, no, distinct, distinct)
        a = UBooleanValue.FALSE;
        b = UBooleanValue.valueOf(false, 0.5);
        assertFalse(a.equals(b));
        assertFalse(a.hashCode() == b.hashCode());

        // (true, zero, UBoolean, no, distinct, 1 - this.u)
        a = UBooleanValue.FALSE;
        b = UBooleanValue.valueOf(false, 1);
        assertTrue(a.equals(b));
        assertEquals(a.hashCode(), b.hashCode());

        // (true, zero, other, -, -, -)
        a = UBooleanValue.FALSE;
        b = new StringValue("Testing");
        assertFalse(a.equals(b));
        assertFalse(a.hashCode() == b.hashCode());

    }

}