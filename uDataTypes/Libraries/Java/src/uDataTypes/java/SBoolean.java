package uDataTypes.java;

// BINOMIAL OPINIONS
public class SBoolean implements Cloneable, Comparable<SBoolean> {
	
	protected double b; // belief mass: degree of belief that self is TRUE
	protected double d; //  disbelief mass: degree of belief that self is FALSE
	protected double u; //  uncertainty mass: amount of uncommitted belief  
	protected double a; //  -- base rate: prior probability of self being TRUE

	
    /**
     * Constructors 
     */
    public SBoolean() {
        this.b = 1.0; this.d = 0.0; this.u = 0.0; this.a = 1.0; // Dogmatic TRUE
    }

    public SBoolean(double b, double d, double u, double a) {
    	this.b = b; 
    	this.d = d; 
    	this.u = u; 
    	this.a = a;
    }
	
    public SBoolean(String b, String d, String u, String a) { //creates an UBoolean from two strings representing (x,u).
       	this.b = Double.parseDouble(b); 
    	this.d = Double.parseDouble(d); 
    	this.u = Double.parseDouble(u); 
    	this.a = Double.parseDouble(a);
    }
    
    public SBoolean(UBoolean b) { // type embedding -- without uncertainty
       	this.b = b.getC(); 
    	this.d = 1-this.b; 
    	this.u = 0; 
    	this.a = this.b;
    }
   
    /**
     * Setters and getters 
     */
    public double belief() {return this.b;} 
    public double disbelief() {return this.d;} 
    public double uncertainty() {return this.u;} 
    public double baseRate() {return this.a;} 
    public void setBelief(double b) {this.b = b;}
    public void setDisbelief(double d) {this.d = d;}
    public void setUncertainty(double u) {this.u = u;}
    public void setBaseRate(double a) {this.a = a;}

    /*********
     * Auxiliary operations
     */

    public double projection() { // projected probability
    	return this.b + this.a*this.u;
    }
    
    public SBoolean uncertaintyMaximized() { // Returns the equivalent SBoolean with maximum uncertainty. 
    										 // The dual operation is toUBoolean, which returns the equivalent SBoolean, with u==0
 	   double p = this.projection();
 	   if (this.a == 1.0) return new SBoolean(1.0-p,0.0,p,this.a);
 	   if (p < this.a) 
 		   return new SBoolean(
			   0.0,
			   1.0 - (p/this.a),
			   p/this.a,
			   this.a);
 	   return new SBoolean(
			   (p-this.a)/(1.0-this.a),
			   0.0,
			   (1.0-p)/(1.0-this.a),
			   this.a);	
    }
    
    /*********
     * Type Operations
     */

    public SBoolean not() {
	   SBoolean result = new SBoolean(
			   this.d,
			   this.b,
			   this.u,
			   1.0-this.a);
	   return result;
    }

	public SBoolean and(SBoolean s) { // assumes independent variables

		if (this==s) return this.clone(); // x and x = x
		
		SBoolean result = new SBoolean(
				this.b*s.b + (this.a*s.a==1? 0: ((1-this.a)*s.a*this.b*s.u+this.a*(1-s.a)*this.u*s.b)/(1-this.a*s.a)),
				this.d + s.d- this.d*s.d,
				this.u*s.u + (this.a*s.a==1? 0: ((1-s.a)*this.b*s.u+(1-this.a)*this.u*s.b)/(1-this.a*s.a)),
				this.a*s.a 
		);
		return result;
	}
	
	public SBoolean or(SBoolean s) {// assumes independent variables

		if (this==s) return this.clone(); // x or x
		
		SBoolean result = new SBoolean(
				this.b + s.b - this.b*s.b,
				this.d*s.d + (this.a + s.a == this.a*s.a? 0: (this.a*(1-s.a)*this.d*s.u+s.a*(1-this.a)*this.u*s.d)/(this.a + s.a - this.a*s.a)),
				this.u*s.u + (this.a + s.a == this.a*s.a? 0: (s.a*this.d*s.u+this.a*this.u*s.d)/(this.a + s.a - this.a*s.a)),
				this.a + s.a - this.a*s.a 
		);
		return result;
	}

	public SBoolean implies(SBoolean s) {// assumes independent variables

		if (this==s) return this.clone(); // x implies x

		return this.not().or(s);
	}

    public SBoolean equivalent(SBoolean s) {
		// return this.implies(b).and(b.implies(this));
		 return this.xor(s).not();
 	
	}

	public SBoolean xor(SBoolean s) {
		SBoolean result = new SBoolean(
				java.lang.Math.abs(this.b - s.b), //this.b*(1.0-s.b)+(1.0-this.b)*s.b,
				1.0 - java.lang.Math.abs(this.b - s.b) - this.u*s.u, //1.0-(this.b*(1.0-s.b)+(1.0-this.b)*s.b)-this.u*s.u,
				this.u*s.u,
				java.lang.Math.abs(this.a - s.a) // this.a*(1.0-s.a)+(1.0-this.a)*s.a 
		);
		 return result;
		//return this.equivalent(b).not();
	}

	/***
	 * comparison operations
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SBoolean sBoolean = (SBoolean) o;

		return  (Double.compare(sBoolean.b, this.b) == 0) && 
				(Double.compare(sBoolean.d, this.d) == 0) &&
				(Double.compare(sBoolean.u, this.u) == 0) &&
				(Double.compare(sBoolean.a, this.a) == 0);
	}

	public boolean distinct(SBoolean b) {
		return !this.equals(b);
	}

	@Override
	public int hashCode() {
		int result;
		result = Math.round((float)this.b*100)+10*Math.round((float)this.d*100)+100*Math.round((float)this.u*100)+1000*Math.round((float)this.a*100);
		return result;
	}


	/******
	 * Conversions
	 */
	
	public String toString() {
		return String.format("(%5.3f, %5.3f, %5.3f, %5.3f)", this.b, this.d, this.u, this.a);
	}

	public UBoolean toUBoolean(){ // returns the projected probability
		return new UBoolean(true, this.projection()); 
	}
	
	/**
	 * Other Methods 
	 */
	@Override
	public int compareTo(SBoolean other) {
		double x = Math.abs(this.b-other.b)+Math.abs(this.d-other.d)+Math.abs(this.u-other.u)+Math.abs(this.a-other.a);
		if (x==0) return 0;
		if (this.b-other.b < 0) return -1;
		return 1;
	}

 	public SBoolean clone() {
		return new SBoolean(this.b,this.d,this.u,this.a);
	}

}
