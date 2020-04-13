/*
 * USE - UML based specification environment
 * Copyright (C) 1999-2004 Mark Richters, University of Bremen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

// $Id: TypeTest.java 5494 2015-02-05 12:59:25Z lhamann $

package org.tzi.use.uml.ocl.type;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_OVERLAYPeer;
import junit.framework.TestCase;

import org.tzi.use.api.UseApiException;
import org.tzi.use.api.UseModelApi;
import org.tzi.use.uml.mm.MAggregationKind;
import org.tzi.use.uml.mm.MAssociation;
import org.tzi.use.uml.mm.MClass;
import org.tzi.use.uml.ocl.type.Type.VoidHandling;

import com.gargoylesoftware.base.testing.EqualsTester;

/**
 * Test Type classes.
 *
 * @version     $ProjectVersion: 0.393 $
 * @author  Mark Richters
 * @see     Type
 */

public class TypeTest extends TestCase {
    private EnumType enum1;
    private EnumType enum2;

    private MClass testClass;
    private MAssociation testAssociation;
    
    protected void setUp() {
        final String[] LITERALS = { "a", "b", "c" };
        enum1 = TypeFactory.mkEnum("E", Arrays.asList(LITERALS));
        enum2 = TypeFactory.mkEnum("E", Arrays.asList(LITERALS));
        
        UseModelApi api = new UseModelApi("Test");
		try {
			testClass = api.createClass("TestClass", false);
			testAssociation = api.createAssociation("TestAssoc", "TestClass", "a", "1", MAggregationKind.NONE,
					                                             "TestClass", "b", "1", MAggregationKind.NONE);
		} catch (UseApiException e) {
			fail();
			return;
		}
    }

    public void testEquality() {
        assertTrue(TypeFactory.mkInteger().equals(TypeFactory.mkInteger()));

        assertTrue(
                   TypeFactory.mkSet(TypeFactory.mkInteger()).equals(
                                                                     TypeFactory.mkSet(TypeFactory.mkInteger())));
        assertTrue(enum1.equals(enum2));
    }

    public void testSubtype() {
    	assertTrue(
    			"String < OclAny",
				TypeFactory.mkString().conformsTo(TypeFactory.mkOclAny())
		);
		assertTrue(
				"String < String",
				TypeFactory.mkString().conformsTo(TypeFactory.mkString())
		);
		assertTrue(
				"String < UString",
				TypeFactory.mkString().conformsTo(TypeFactory.mkUString())
		);
		assertTrue(
				"UString < UString",
				TypeFactory.mkUString().conformsTo(TypeFactory.mkUString())
		);
		assertTrue(
				"UString < OclAny",
				TypeFactory.mkUString().conformsTo(TypeFactory.mkOclAny())
		);
		assertTrue(
				"SBoolean < OclAny",
				TypeFactory.mkSBoolean().conformsTo(TypeFactory.mkOclAny())
		);
		assertTrue(
				"SBoolean < SBoolean",
				TypeFactory.mkSBoolean().conformsTo(TypeFactory.mkSBoolean()));

		assertTrue(
				"UBoolean < SBoolean",
				TypeFactory.mkUBoolean().conformsTo(TypeFactory.mkSBoolean())
		);
    	assertTrue(
    			"UBoolean < UBoolean",
				TypeFactory.mkUBoolean().conformsTo(TypeFactory.mkUBoolean())
		);
    	assertTrue(
    			"UBoolean < OclAny",
				TypeFactory.mkUBoolean().conformsTo(TypeFactory.mkOclAny())
		);
		assertTrue(
				"Boolean < SBoolean",
				TypeFactory.mkBoolean().conformsTo(TypeFactory.mkSBoolean())
		);
    	assertTrue(
    			"Boolean < UBoolean",
				TypeFactory.mkBoolean().conformsTo(TypeFactory.mkUBoolean())
		);
    	assertTrue(
    			"UReal < OclAny",
					TypeFactory.mkUReal().conformsTo(TypeFactory.mkUReal()));
    	assertTrue(
    			"UReal < UReal",
				    TypeFactory.mkUReal().conformsTo(TypeFactory.mkUReal()));
    	assertTrue(
    				"Real < UReal",
        		  	TypeFactory.mkReal().conformsTo(TypeFactory.mkUReal()));
		assertTrue(
				"UInteger < UInteger",
				TypeFactory.mkUInteger().conformsTo(TypeFactory.mkUInteger()));
		assertTrue(
				"UInteger < UReal",
				TypeFactory.mkUInteger().conformsTo(TypeFactory.mkUReal()));
        assertTrue(
                   "Integer < Integer",
                   TypeFactory.mkInteger().conformsTo(TypeFactory.mkInteger()));
        assertTrue(
                   "Integer < Real",
                   TypeFactory.mkInteger().conformsTo(TypeFactory.mkReal()));
        assertTrue(
        			"Integer < UReal",
					TypeFactory.mkInteger().conformsTo(TypeFactory.mkUReal()));
		assertTrue(
				"Integer < UInteger",
				TypeFactory.mkInteger().conformsTo(TypeFactory.mkUInteger()));
        assertTrue(
                   "Set(Integer) < Set(Integer)",
                   TypeFactory.mkSet(TypeFactory.mkInteger())
                   .conformsTo(TypeFactory.mkSet(TypeFactory.mkInteger())));
        assertTrue(
                   "Set(Integer) < Set(Real)",
                   TypeFactory.mkSet(TypeFactory.mkInteger())
                   .conformsTo(TypeFactory.mkSet(TypeFactory.mkReal())));
        assertTrue(
                   "Set(Integer) < Collection(Integer)",
                   TypeFactory.mkSet(TypeFactory.mkInteger())
                   .conformsTo(TypeFactory.mkCollection(TypeFactory.mkInteger())));
        assertFalse(
                    "Set(Integer) < Set(String)",
                    TypeFactory.mkSet(TypeFactory.mkInteger())
                    .conformsTo(TypeFactory.mkSet(TypeFactory.mkString())));
        assertFalse(
                    "Collection(Integer) < Set(Integer)",
                    TypeFactory.mkCollection(TypeFactory.mkInteger())
                    .conformsTo(TypeFactory.mkSet(TypeFactory.mkInteger())));
        assertFalse(
                    "Collection(Integer) < Bag(Integer)",
                    TypeFactory.mkCollection(TypeFactory.mkInteger())
                    .conformsTo(TypeFactory.mkBag(TypeFactory.mkInteger())));
        assertFalse(
                    "Bag(Integer) < Set(Integer)",
                    TypeFactory.mkBag(TypeFactory.mkInteger())
                    .conformsTo(TypeFactory.mkSet(TypeFactory.mkInteger())));
        assertTrue(
                   "Bag(Integer) < Bag(Integer)",
                   TypeFactory.mkBag(TypeFactory.mkInteger())
                   .conformsTo(TypeFactory.mkBag(TypeFactory.mkInteger())));
        assertTrue(
                   "Bag(Integer) < Collection(Integer)",
                   TypeFactory.mkBag(TypeFactory.mkInteger())
                   .conformsTo(TypeFactory.mkCollection(TypeFactory.mkInteger())));
        assertTrue(
                   "Set(Set(Integer)) < Collection(Collection(Integer))",
                   TypeFactory.mkSet(TypeFactory.mkSet(TypeFactory.mkInteger()))
                   .conformsTo(TypeFactory.mkCollection(TypeFactory
                                                         .mkCollection(TypeFactory.mkInteger()))));
        assertTrue(
                   "Sequence(Integer) < Sequence(Integer)",
                   TypeFactory.mkSequence(TypeFactory.mkInteger())
                   .conformsTo(TypeFactory.mkSequence(TypeFactory.mkInteger())));
    }

    public void testSupertype() {
        assertEquals(
                     "OclAny.allSupertypes()",
                     mkSet(new Object[] { TypeFactory.mkOclAny()}),
                     TypeFactory.mkOclAny().allSupertypes());
		assertEquals(
				"SBoolean.allSupertypes()",
				mkSet(
						new Object [] {
								TypeFactory.mkSBoolean(),
								TypeFactory.mkOclAny()
						}),
				TypeFactory.mkSBoolean().allSupertypes()
		);
        assertEquals(
        		"UBoolean.allSupertypes()",
				mkSet(
						new Object [] {
								TypeFactory.mkUBoolean(),
								TypeFactory.mkSBoolean(),
								TypeFactory.mkOclAny()
						}),
				TypeFactory.mkUBoolean().allSupertypes()
		);
        assertEquals(
                     "Boolean.allSupertypes()",
                     mkSet(
                     		new Object[] {
                     				TypeFactory.mkBoolean(),
									TypeFactory.mkOclAny(),
									TypeFactory.mkUBoolean(),
									TypeFactory.mkSBoolean()
							}),
                     TypeFactory.mkBoolean().allSupertypes());
        assertEquals(
                     "Integer.allSupertypes()",
                     mkSet(
                           new Object[] {
                               TypeFactory.mkInteger(),
								   TypeFactory.mkUInteger(),
                               TypeFactory.mkReal(),
                               TypeFactory.mkOclAny(),
				               TypeFactory.mkUReal()}),
                     TypeFactory.mkInteger().allSupertypes());
		assertEquals(
				"UInteger.allSupertypes()",
				mkSet(
						new Object[] {
								TypeFactory.mkUInteger(),
								TypeFactory.mkUReal(),
								TypeFactory.mkOclAny()}),
				TypeFactory.mkUInteger().allSupertypes());
        assertEquals(
                     "Real.allSupertypes()",
                     mkSet(new Object[] {
                     		TypeFactory.mkReal(),
							 TypeFactory.mkOclAny(),
					 		TypeFactory.mkUReal()}),
                     TypeFactory.mkReal().allSupertypes());
        assertEquals(
        			"UReal.allSupertypes()",
					mkSet(new Object[] {TypeFactory.mkUReal(), TypeFactory.mkOclAny()}),
				    TypeFactory.mkUReal().allSupertypes());
        assertEquals(
                     "String.allSupertypes()",
                     mkSet(new Object[] { TypeFactory.mkString(), TypeFactory.mkUString(), TypeFactory.mkOclAny()}),
                     TypeFactory.mkString().allSupertypes());
		assertEquals(
				"UString.allSupertypes()",
				mkSet(new Object[] { TypeFactory.mkUString(), TypeFactory.mkOclAny()}),
				TypeFactory.mkUString().allSupertypes());
        assertEquals(
                     "Enum.allSupertypes()",
                     mkSet(new Object[] { enum1, TypeFactory.mkOclAny()}),
                     enum1.allSupertypes());
        assertEquals(
                     "Collection(Boolean).allSupertypes()",
                     mkSet(
                           new Object[] {
                           		TypeFactory.mkCollection(TypeFactory.mkBoolean()),
                               TypeFactory.mkCollection(TypeFactory.mkOclAny()),
								   TypeFactory.mkCollection(TypeFactory.mkUBoolean()),
								   TypeFactory.mkCollection(TypeFactory.mkSBoolean())
                           }),
                     TypeFactory.mkCollection(TypeFactory.mkBoolean()).allSupertypes());
        assertEquals(
                     "Collection(Integer).allSupertypes()",
                     mkSet(
                           new Object[] {
                               TypeFactory.mkCollection(TypeFactory.mkInteger()),
                               TypeFactory.mkCollection(TypeFactory.mkReal()),
                               TypeFactory.mkCollection(TypeFactory.mkOclAny()),
                                   TypeFactory.mkCollection(TypeFactory.mkUReal()),
								   TypeFactory.mkCollection(TypeFactory.mkUInteger())
                           }),
                     TypeFactory.mkCollection(TypeFactory.mkInteger()).allSupertypes());
        assertEquals(
                     "Collection(Collection(Real))).allSupertypes()",
                     mkSet(new Object[] {
                               TypeFactory.mkCollection(
                                   TypeFactory.mkCollection(TypeFactory.mkReal())),
                               TypeFactory.mkCollection(
                                   TypeFactory.mkCollection(TypeFactory.mkOclAny())),
							 TypeFactory.mkCollection(
									 TypeFactory.mkCollection(TypeFactory.mkUReal()))
                           }), 
                     TypeFactory.mkCollection(TypeFactory.mkCollection(
                         TypeFactory.mkReal())).allSupertypes());

        assertEquals(
                     "Set(Integer).allSupertypes()",
                     mkSet(
                           new Object[] {
                               TypeFactory.mkCollection(TypeFactory.mkInteger()),
                               TypeFactory.mkCollection(TypeFactory.mkReal()),
                               TypeFactory.mkCollection(TypeFactory.mkOclAny()),
                                   TypeFactory.mkCollection(TypeFactory.mkUReal()),
								   TypeFactory.mkCollection(TypeFactory.mkUInteger()),
                               TypeFactory.mkSet(TypeFactory.mkInteger()),
                               TypeFactory.mkSet(TypeFactory.mkReal()),
                               TypeFactory.mkSet(TypeFactory.mkOclAny()),
                                   TypeFactory.mkSet(TypeFactory.mkUReal()),
								   TypeFactory.mkSet(TypeFactory.mkUInteger())
                           }),
                     TypeFactory.mkSet(TypeFactory.mkInteger()).allSupertypes());
        assertEquals(
                     "Sequence(Integer).allSupertypes()",
                     mkSet(
                           new Object[] {
                               TypeFactory.mkCollection(TypeFactory.mkInteger()),
                               TypeFactory.mkCollection(TypeFactory.mkReal()),
                               TypeFactory.mkCollection(TypeFactory.mkOclAny()),
                                   TypeFactory.mkCollection(TypeFactory.mkUReal()),
								   TypeFactory.mkCollection(TypeFactory.mkUInteger()),
                               TypeFactory.mkSequence(TypeFactory.mkInteger()),
                               TypeFactory.mkSequence(TypeFactory.mkReal()),
                               TypeFactory.mkSequence(TypeFactory.mkOclAny()),
                                   TypeFactory.mkSequence(TypeFactory.mkUReal()),
								   TypeFactory.mkSequence(TypeFactory.mkUInteger())
                           }),
                     TypeFactory.mkSequence(TypeFactory.mkInteger()).allSupertypes());
        assertEquals(
                     "Bag(Integer).allSupertypes()",
                     mkSet(
                           new Object[] {
                               TypeFactory.mkCollection(TypeFactory.mkInteger()),
                               TypeFactory.mkCollection(TypeFactory.mkReal()),
                               TypeFactory.mkCollection(TypeFactory.mkOclAny()),
                                   TypeFactory.mkCollection(TypeFactory.mkUReal()),
								   TypeFactory.mkCollection(TypeFactory.mkUInteger()),
                               TypeFactory.mkBag(TypeFactory.mkInteger()),
                               TypeFactory.mkBag(TypeFactory.mkReal()),
                               TypeFactory.mkBag(TypeFactory.mkOclAny()),
                                   TypeFactory.mkBag(TypeFactory.mkUReal()),
								   TypeFactory.mkBag(TypeFactory.mkUInteger())
                           }),
                     TypeFactory.mkBag(TypeFactory.mkInteger()).allSupertypes());
    }

    
    // more elaborated test for equals
    public void testEquals() {
        // boolean 
        BooleanType bt1 = new BooleanType();
        BooleanType bt2 = new BooleanType();
        new EqualsTester(bt1, bt2, null, null);
        assertEquals( bt1.hashCode(), bt2.hashCode() );
        
        
        // integer
        IntegerType it1 = new IntegerType();
        IntegerType it2 = new IntegerType();
        new EqualsTester(it1, it2, null, null);
        assertEquals( it1.hashCode(), it2.hashCode() );

        // UInteger
		UIntegerType uit1 = new UIntegerType();
		UIntegerType uit2 = new UIntegerType();
		assertEquals(uit1.hashCode(), uit2.hashCode());


        // real
        RealType rt1 = new RealType();
        RealType rt2 = new RealType();
        new EqualsTester(rt1, rt2, null, null);
        assertEquals( rt1.hashCode(), rt2.hashCode() );

        // UReal
		URealType urt1 = new URealType();
		URealType urt2 = new URealType();
		assertEquals(urt1.hashCode(), urt2.hashCode());

		// UBoolean
		UBooleanType ubt1 = new UBooleanType();
		UBooleanType ubt2 = new UBooleanType();
		assertEquals(ubt1.hashCode(), ubt2.hashCode());

		// SBoolean
		SBooleanType sbt1 = new SBooleanType();
		SBooleanType sbt2 = new SBooleanType();
		assertEquals(ubt1.hashCode(), ubt2.hashCode());
        
        
        SetType sett1 = new SetType(bt1);
        SetType sett2 = new SetType(bt1);
        SetType sett3 = new SetType(it1);
        new EqualsTester(sett1, sett2, sett3, null);
        
        BagType bagt1 = new BagType(bt1);
        BagType bagt2 = new BagType(bt1);
        BagType bagt3 = new BagType(it1);
        new EqualsTester(bagt1, bagt2, bagt3, null);

        SequenceType sequencet1 = new SequenceType(bt1);
        SequenceType sequencet2 = new SequenceType(bt1);
        SequenceType sequencet3 = new SequenceType(it1);
        new EqualsTester(sequencet1, sequencet2, sequencet3, null);
        
        CollectionType collectiont1 = new CollectionType(bt1);
        CollectionType collectiont2 = new CollectionType(bt1);
        CollectionType collectiont3 = new CollectionType(it1);
        new EqualsTester(collectiont1, collectiont2, collectiont3, sett1);

        EnumType enumt1 = new EnumType(null, "e1", new LinkedList<String>() );
        EnumType enumt2 = new EnumType(null, "e1", new LinkedList<String>() );
        EnumType enumt3 = new EnumType(null, "e2", new LinkedList<String>() );
        new EqualsTester(enumt1, enumt2, enumt3, null);

        TupleType.Part part1 = new TupleType.Part(0, "p1", sett1);
        TupleType.Part part2 = new TupleType.Part(1, "p1", sett2);
        TupleType.Part part3 = new TupleType.Part(2, "p2", sett2);
        TupleType tuplet1 = new TupleType( new TupleType.Part[]{part1});
        TupleType tuplet2 = new TupleType( new TupleType.Part[]{part2});
        TupleType tuplet3 = new TupleType( new TupleType.Part[]{part3});
        new EqualsTester(tuplet1, tuplet2, tuplet3, null);
                
    }

    public void testIsTypeOfBag() {
    	Type type = TypeFactory.mkBag(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertTrue (type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
    	assertFalse(type.isTypeOfUReal());
    	assertFalse(type.isTypeOfUBoolean());
    	assertFalse(type.isTypeOfUInteger());
    	assertFalse(type.isTypeOfUString());
    	assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfBag() {
    	Type type = TypeFactory.mkBag(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfBooloean() {
    	Type type = TypeFactory.mkBoolean();
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertTrue (type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
    	assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfBoolean() {
    	Type type = TypeFactory.mkBoolean();
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
    	assertTrue(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertTrue(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }



	public void testIsTypeOfSBooloean() {
		Type type = TypeFactory.mkSBoolean();

		assertFalse(type.isTypeOfAssociation());
		assertFalse(type.isTypeOfBag());
		assertFalse (type.isTypeOfBoolean());
		assertFalse(type.isTypeOfCollection());
		assertFalse(type.isTypeOfEnum());
		assertFalse(type.isTypeOfClassifier());
		assertFalse(type.isTypeOfInteger());
		assertFalse(type.isTypeOfClass());
		assertFalse(type.isTypeOfOclAny());
		assertFalse(type.isTypeOfOrderedSet());
		assertFalse(type.isTypeOfReal());
		assertFalse(type.isTypeOfSequence());
		assertFalse(type.isTypeOfSet());
		assertFalse(type.isTypeOfString());
		assertFalse(type.isTypeOfTupleType());
		assertFalse(type.isTypeOfUnlimitedNatural());
		assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertTrue(type.isTypeOfSBoolean());
	}

	public void testIsKindOfSBoolean() {
		Type type = TypeFactory.mkSBoolean();

		assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertTrue(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));

		assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
		assertFalse (type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
	}

	public void testIsTypeOfUBooloean() {
		Type type = TypeFactory.mkUBoolean();

		assertFalse(type.isTypeOfAssociation());
		assertFalse(type.isTypeOfBag());
		assertFalse (type.isTypeOfBoolean());
		assertFalse(type.isTypeOfCollection());
		assertFalse(type.isTypeOfEnum());
		assertFalse(type.isTypeOfClassifier());
		assertFalse(type.isTypeOfInteger());
		assertFalse(type.isTypeOfClass());
		assertFalse(type.isTypeOfOclAny());
		assertFalse(type.isTypeOfOrderedSet());
		assertFalse(type.isTypeOfReal());
		assertFalse(type.isTypeOfSequence());
		assertFalse(type.isTypeOfSet());
		assertFalse(type.isTypeOfString());
		assertFalse(type.isTypeOfTupleType());
		assertFalse(type.isTypeOfUnlimitedNatural());
		assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUReal());
		assertTrue(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
	}

	public void testIsKindOfUBoolean() {
		Type type = TypeFactory.mkUBoolean();

		assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertTrue(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertTrue(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));

		assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
		assertFalse (type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
	}

    public void testIsTypeOfCollection() {
    	Type type = TypeFactory.mkCollection(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertTrue (type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
    	assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfCollection() {
    	Type type = TypeFactory.mkCollection(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfEnum() {
    	Type type = TypeFactory.mkEnum("testEnum", Collections.<String>emptyList());
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertTrue (type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
    	assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfEnum() {
    	Type type = TypeFactory.mkEnum("testEnum", Collections.<String>emptyList());
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfClass() {
    	Type type = testClass;
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier()); 	
    	assertFalse(type.isTypeOfInteger());
    	assertTrue (type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
    	assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfClass() {
    	Type type = testClass;
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfInteger() {
    	Type type = TypeFactory.mkInteger();
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertTrue (type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
    	assertFalse(type.isTypeOfUReal());
    	assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfInteger() {
    	Type type = TypeFactory.mkInteger();
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
    	assertTrue(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertTrue (type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertTrue (type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    }

    public void testIsTypeOfUInteger() {
		Type type = TypeFactory.mkUInteger();

		assertFalse(type.isTypeOfAssociation());
		assertFalse(type.isTypeOfBag());
		assertFalse(type.isTypeOfBoolean());
		assertFalse(type.isTypeOfCollection());
		assertFalse(type.isTypeOfEnum());
		assertFalse(type.isTypeOfClassifier());
		assertFalse(type.isTypeOfInteger());
		assertFalse(type.isTypeOfClass());
		assertFalse(type.isTypeOfOclAny());
		assertFalse(type.isTypeOfOrderedSet());
		assertFalse(type.isTypeOfReal());
		assertFalse(type.isTypeOfSequence());
		assertFalse(type.isTypeOfSet());
		assertFalse(type.isTypeOfString());
		assertFalse(type.isTypeOfTupleType());
		assertFalse(type.isTypeOfUnlimitedNatural());
		assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
    	assertTrue (type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
	}

	public void testIsKindOfUInteger() {
		Type type = TypeFactory.mkUInteger();

		assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
		assertFalse (type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));

		assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
	}
    
    public void testIsTypeOfAssociation() {
    	Type type = testAssociation;
    	
    	assertTrue (type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
    	assertFalse(type.isTypeOfUReal());
    	assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfAsociation() {
    	Type type = testAssociation;
    	
    	assertTrue (type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertTrue (type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfOclAny() {
    	Type type = TypeFactory.mkOclAny();
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertTrue (type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfOclAny() {
    	Type type = TypeFactory.mkOclAny();
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfOrderedSet() {
    	Type type = TypeFactory.mkOrderedSet(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertTrue (type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfOrderedSet() {
    	Type type = TypeFactory.mkOrderedSet(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }

    public void testIsTypeOfUReal() {
    	Type type = TypeFactory.mkUReal();

		assertFalse(type.isTypeOfAssociation());
		assertFalse(type.isTypeOfBag());
		assertFalse(type.isTypeOfBoolean());
		assertFalse(type.isTypeOfCollection());
		assertFalse(type.isTypeOfEnum());
		assertFalse(type.isTypeOfClassifier());
		assertFalse(type.isTypeOfInteger());
		assertFalse(type.isTypeOfClass());
		assertFalse(type.isTypeOfOclAny());
		assertFalse(type.isTypeOfOrderedSet());
		assertFalse(type.isTypeOfReal());
		assertTrue(type.isTypeOfUReal());
		assertFalse(type.isTypeOfSequence());
		assertFalse(type.isTypeOfSet());
		assertFalse(type.isTypeOfString());
		assertFalse(type.isTypeOfTupleType());
		assertFalse(type.isTypeOfUnlimitedNatural());
		assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
	}

	public void testIsKindOfUReal() {
		Type type = TypeFactory.mkUReal();

		assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
		assertFalse (type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));

		assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
		assertFalse (type.isKindOfReal(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
	}

	public void testIsKindOfReal() {
		Type type = TypeFactory.mkReal();

		assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertTrue(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));

		assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
	}
    
    public void testIsTypeOfReal() {
    	Type type = TypeFactory.mkReal();

		assertFalse(type.isTypeOfAssociation());
		assertFalse(type.isTypeOfBag());
		assertFalse(type.isTypeOfBoolean());
		assertFalse(type.isTypeOfCollection());
		assertFalse(type.isTypeOfEnum());
		assertFalse(type.isTypeOfClassifier());
		assertFalse(type.isTypeOfInteger());
		assertFalse(type.isTypeOfClass());
		assertFalse(type.isTypeOfOclAny());
		assertFalse(type.isTypeOfOrderedSet());
		assertTrue(type.isTypeOfReal());
		assertFalse(type.isTypeOfSequence());
		assertFalse(type.isTypeOfSet());
		assertFalse(type.isTypeOfString());
		assertFalse(type.isTypeOfTupleType());
		assertFalse(type.isTypeOfUnlimitedNatural());
		assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsTypeOfSequence() {
    	Type type = TypeFactory.mkSequence(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertTrue (type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfSequence() {
    	Type type = TypeFactory.mkSequence(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfSet() {
    	Type type = TypeFactory.mkSet(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertTrue (type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfSet() {
    	Type type = TypeFactory.mkSet(TypeFactory.mkOclAny());
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    public void testIsTypeOfString() {
    	Type type = TypeFactory.mkString();
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertTrue (type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfString() {
    	Type type = TypeFactory.mkString();
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertTrue(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }



	public void testIsTypeOfUString() {
		Type type = TypeFactory.mkUString();

		assertFalse(type.isTypeOfAssociation());
		assertFalse(type.isTypeOfBag());
		assertFalse(type.isTypeOfBoolean());
		assertFalse(type.isTypeOfCollection());
		assertFalse(type.isTypeOfEnum());
		assertFalse(type.isTypeOfClassifier());
		assertFalse(type.isTypeOfInteger());
		assertFalse(type.isTypeOfClass());
		assertFalse(type.isTypeOfOclAny());
		assertFalse(type.isTypeOfOrderedSet());
		assertFalse(type.isTypeOfReal());
		assertFalse(type.isTypeOfSequence());
		assertFalse(type.isTypeOfSet());
		assertFalse(type.isTypeOfString());
		assertFalse(type.isTypeOfTupleType());
		assertFalse(type.isTypeOfUnlimitedNatural());
		assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertTrue (type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
	}

	public void testIsKindOfUString() {
		Type type = TypeFactory.mkUString();

		assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertTrue(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));

		assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
		assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
	}
    
    public void testIsTypeOfTupleType() {
    	Type type = TypeFactory.mkTuple(new TupleType.Part[0]);
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertTrue (type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfTupleType() {
    	Type type = TypeFactory.mkTuple(new TupleType.Part[0]);
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }

    public void testIsTypeOfUnlimitedNatural() {
    	Type type = TypeFactory.mkUnlimitedNatural();
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertTrue (type.isTypeOfUnlimitedNatural());
    	assertFalse(type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfUnlimitedNatural() {
    	Type type = TypeFactory.mkUnlimitedNatural();
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertTrue (type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertTrue (type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }

    public void testIsTypeOfVoidType() {
    	Type type = TypeFactory.mkVoidType();
    	
    	assertFalse(type.isTypeOfAssociation());
    	assertFalse(type.isTypeOfBag());
    	assertFalse(type.isTypeOfBoolean());
    	assertFalse(type.isTypeOfCollection());
    	assertFalse(type.isTypeOfEnum());
    	assertFalse(type.isTypeOfClassifier());    	
    	assertFalse(type.isTypeOfInteger());
    	assertFalse(type.isTypeOfClass());
    	assertFalse(type.isTypeOfOclAny());
    	assertFalse(type.isTypeOfOrderedSet());
    	assertFalse(type.isTypeOfReal());
    	assertFalse(type.isTypeOfSequence());
    	assertFalse(type.isTypeOfSet());
    	assertFalse(type.isTypeOfString());
    	assertFalse(type.isTypeOfTupleType());
    	assertFalse(type.isTypeOfUnlimitedNatural());
    	assertTrue (type.isTypeOfVoidType());
		assertFalse(type.isTypeOfUReal());
		assertFalse(type.isTypeOfUBoolean());
		assertFalse(type.isTypeOfUInteger());
		assertFalse(type.isTypeOfUString());
		assertFalse(type.isTypeOfSBoolean());
    }
    
    public void testIsKindOfVoidType() {
    	Type type = TypeFactory.mkVoidType();
    	
    	assertFalse(type.isKindOfAssociation(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBag(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfBoolean(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfCollection(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfEnum(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClassifier(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfInteger(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfNumber(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfClass(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOclAny(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfOrderedSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfReal(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSequence(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfSet(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfString(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfTupleType(VoidHandling.EXCLUDE_VOID));
    	assertFalse(type.isKindOfUnlimitedNatural(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUReal(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUBoolean(VoidHandling.EXCLUDE_VOID));
        assertFalse(type.isKindOfUInteger(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfUString(VoidHandling.EXCLUDE_VOID));
		assertFalse(type.isKindOfSBoolean(VoidHandling.EXCLUDE_VOID));
    	
    	assertTrue(type.isKindOfAssociation(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfBag(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfBoolean(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfCollection(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfEnum(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfClassifier(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfInteger(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfNumber(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfClass(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfOclAny(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfOrderedSet(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfReal(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfSequence(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfSet(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfString(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfTupleType(VoidHandling.INCLUDE_VOID));
    	assertTrue(type.isKindOfUnlimitedNatural(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfUReal(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfUBoolean(VoidHandling.INCLUDE_VOID));
        assertTrue(type.isKindOfUInteger(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfUString(VoidHandling.INCLUDE_VOID));
		assertTrue(type.isKindOfSBoolean(VoidHandling.INCLUDE_VOID));
    }
    
    private Set<Object> mkSet(Object[] elems) {
        Set<Object> res = new HashSet<Object>(elems.length);
        res.addAll(Arrays.asList(elems));
        return res;
    }
}
