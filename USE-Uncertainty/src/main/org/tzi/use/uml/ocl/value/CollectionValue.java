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

// $Id: CollectionValue.java 5494 2015-02-05 12:59:25Z lhamann $

package org.tzi.use.uml.ocl.value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.tzi.use.uml.ocl.type.*;
import org.tzi.use.uml.ocl.type.TupleType.Part;
import org.tzi.use.util.collections.CollectionComparator;

/**
 * Base class for collection values.
 *
 * @version     $ProjectVersion: 0.393 $
 * @author  Mark Richters
 * @see     SetValue
 * @see     SequenceValue
 * @see     BagValue
 */
public abstract class CollectionValue extends Value implements Iterable<Value> {

	protected Type fElemType; // store frequently needed element type too	
    
    CollectionValue(Type t, Type elemType) {
        super(t);
        fElemType = elemType;
    }

    public final Type elemType() {
    	return fElemType;
    }
    
    public final Type type() {
        return super.type();
    }

    @Override
	public Type getRuntimeType() {
    	Set<Type> types = new HashSet<Type>();
    	types.add(TypeFactory.mkVoidType());
    	for (Value v : collection()) {
    		types.add(v.getRuntimeType());
    	}
    	Type runtimeElemType = new UniqueLeastCommonSupertypeDeterminator().calculateFor(types);
    	if (runtimeElemType == null) {
    		throw new RuntimeException("Could not determine unique common supertype for " + types);
    	}
        return getRuntimeType(runtimeElemType);
	}            

    /**
     * This method returns the type of a collection with the given 
     * element type.   
     */
    protected abstract CollectionType getRuntimeType(Type elementType);
    
    /**
     * Returns the element type of the <code>resultType</code> if 
     * it is a collection type. 
     * Otherwise, a runtime exception is thrown.
	 * @param resultType
	 * @return
	 */
	protected final Type getResultElementType(final Type resultType) {
    	// Result could be any (currently not) or void.... 
    	if (resultType instanceof CollectionType) {
    		return ((CollectionType)resultType).elemType();
    	} else {
    		throw new RuntimeException("Internal type error!");
    	}
	}
	
    public abstract Iterator<Value> iterator();
    public abstract int size();
    public abstract boolean isEmpty();
    public abstract boolean includes(Value v);
    public abstract boolean includesAll(CollectionValue v);
    public abstract boolean excludesAll(CollectionValue v);
    public abstract int count(Value v);
    public abstract CollectionValue flatten(Type resultType);

    protected abstract Integer getClassCompareNr();
    
    public abstract Collection<Value> collection();

    public UBooleanValue uIncludes(Value v) {
    	UBooleanValue res = UBooleanValue.FALSE, aux;
    	Iterator<Value> it = iterator();
    	Value elemVal;

    	while (res.probability() <1 && it.hasNext()) {
    		elemVal = it.next();

    		if (elemVal instanceof UncertainValue)
    			aux = UBooleanValue.valueOf(((UncertainValue) elemVal).uEquals(v));
    		else if (v instanceof UncertainValue)
    			aux = UBooleanValue.valueOf(((UncertainValue) v).uEquals(elemVal));
    		else
    			aux = UBooleanValue.valueOf(v.equals(elemVal), 1);

    		if (aux.probability() > res.probability())
    			res = aux;
		}

    	return res;
	}

	public UBooleanValue uIncludesAll(CollectionValue coll2) {
    	UBooleanValue result = UBooleanValue.TRUE, aux;
    	Iterator<Value> it = coll2.iterator();

    	if (coll2.size() > size())
    		result = UBooleanValue.FALSE;
    	else {

			while (result.probability() > 0 && it.hasNext()) {
				Value elemVal = it.next();
				aux = uIncludes(elemVal);
				result = result.and(aux);
			}

		}

    	return result;
	}


	public UBooleanValue uExcludes(Value v) {
    	UBooleanValue result = UBooleanValue.TRUE;
		UncertainBooleanValue aux;
		Iterator<Value> it = iterator();

    	while (result.probability() > 0 && it.hasNext()) {
    		Value elemVal = it.next();

    		// check that values are different.
			if (elemVal instanceof UncertainValue)
				aux = ((UncertainValue) elemVal).uDistinct(v);
			else if (v instanceof UncertainValue)
				aux = ((UncertainValue) v).uDistinct(elemVal);
			else
				aux = UBooleanValue.valueOf(!v.equals(elemVal), 1);

			// And operation
			result = result.and(aux);
		}

    	return result;
	}

	public UBooleanValue uExcludesAll(CollectionValue coll2) {
		UBooleanValue result = UBooleanValue.TRUE, aux;
		Iterator<Value> it = coll2.iterator();

		while (result.probability() > 0 && it.hasNext()) {
			Value elemVal = it.next();
			aux = uExcludes(elemVal);
			result = result.and(aux);
		}

		return result;
	}

	public int uCountC(Value value, double confidence) {
    	int result = 0;
    	UBooleanValue equals;

    	for (Value v : this) {

    		if (v instanceof UncertainValue)
    			equals = UBooleanValue.valueOf(((UncertainValue) v).uEquals(value));
    		else if (value instanceof UncertainValue)
    			equals = UBooleanValue.valueOf(((UncertainValue) value).uEquals(v));
    		else
    			equals = UBooleanValue.valueOf(v.equals(value), 1);

    		if (equals.probability() >= confidence)
    			result++;

		}

    	return result;
	}

    @Override
    public boolean isCollection() {
    	return true;
    }
    
    @Override
    public int compareTo(Value o) {
        if (o == this )
            return 0;
        if (o instanceof UndefinedValue )
            return +1;
        if (o instanceof CollectionValue) {
            CollectionValue c = (CollectionValue)o;
            int res = new CollectionComparator<Value>().compare(collection(), c.collection());
            if (c.getClass().equals( getClass() ) ) {
                return res;
            } else {
            	// Need to make compares work in both directions a < b => b > a
            	return getClassCompareNr().compareTo(c.getClassCompareNr());
            }
        }
        throw new ClassCastException();
    }

  
    public SetValue product(CollectionValue col)
    {
    	Part[] parts = new Part[2];
    	parts[0] = new Part(0, "first", this.elemType());
    	parts[1] = new Part(1, "second", col.elemType());
    	
    	TupleType tupleType = TypeFactory.mkTuple(parts);
    	SetValue res = new SetValue(tupleType);
    	
    	Iterator<Value> iter1 = this.iterator();
    	Iterator<Value> iter2;
    	Value elem1, elem2;
    	TupleValue tuple;
    	TupleValue.Part[] valueParts;
    	
    	while (iter1.hasNext())
    	{
    		elem1 = iter1.next();
    		iter2 = col.iterator();
    		
    		while(iter2.hasNext())
    		{
    			elem2 = iter2.next();
    			
    			valueParts = new TupleValue.Part[2];
    			valueParts[0] = new TupleValue.Part(0, "first", elem1);
    			valueParts[1] = new TupleValue.Part(1, "second", elem2);
    			
    			tuple = new TupleValue(tupleType, Arrays.asList(valueParts));
    			res.add(tuple);
    		}
    	}
    	
    	return res;
    }
    
    /**
     * Creates a sorted list of the elements included in the collection.
     * This is especially used for messages to the user and for tests to
     * get a natural output.
     * @return Sorted <code>List</code> of the elements of the set.
     */
    public List<Value> getSortedElements() {
    	List<Value> result = new ArrayList<Value>(collection());
    	Collections.sort(result);
    	return result;
    }
    
    public BagValue asBag() {
    	return new BagValue(elemType(), collection());
    }
    
    public SetValue asSet() {
    	return new SetValue(elemType(), collection());
    }
    
    public OrderedSetValue asOrderedSet() {
    	if (this.isOrderedSet() || this.isSequence())
    		return new OrderedSetValue(elemType(), this.collection());
    	else
    		return new OrderedSetValue(elemType(), this.getSortedElements());
    }
    
    public SequenceValue asSequence() {
    	if (this.isOrderedSet() || this.isSequence())
    		return new SequenceValue(elemType(), this.collection());
    	else
    		return new SequenceValue(elemType(), this.getSortedElements());
    }
}

