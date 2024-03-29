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

// $Id: BooleanType.java 5494 2015-02-05 12:59:25Z lhamann $

package org.tzi.use.uml.ocl.type;

import java.util.HashSet;
import java.util.Set;

/**
 * The OCL Boolean type.
 *
 * @version     $ProjectVersion: 0.393 $
 * @author  Mark Richters
 */
public final class BooleanType extends BasicType {

    BooleanType() {
        super("Boolean");
    }
    
    @Override
    public boolean isTypeOfBoolean() {
    	return true;
    }
    
    @Override
    public boolean isKindOfBoolean(VoidHandling h) {
    	return true;
    }

    @Override
    public boolean isKindOfUBoolean(VoidHandling h) {
        return true;
    }

    @Override
    public boolean isKindOfSBoolean(VoidHandling h) {
        return true;
    }

    /**
     * Returns true if this type is a subtype of <code>t</code>. 
     */
    @Override
    public boolean conformsTo(Type other) {
        return this.equals(other) || other.isTypeOfUBoolean() || other.isTypeOfOclAny() || other.isTypeOfSBoolean();
    }

    /** 
     * Returns the set of all supertypes (including this type).
     */
    @Override
    public Set<Type> allSupertypes() {
        Set<Type> res = new HashSet<Type>(2);
        res.add(TypeFactory.mkOclAny());
        res.add(TypeFactory.mkUBoolean());
        res.add(TypeFactory.mkSBoolean());
        res.add(this);
        return res;
    }
}
