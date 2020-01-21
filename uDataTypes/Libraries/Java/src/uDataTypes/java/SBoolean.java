package uDataTypes.java;

// BINOMIAL OPINIONS
public class SBoolean implements Cloneable, Comparable<SBoolean> {
	
	protected double b; // belief mass: degree of belief that self is TRUE
	protected double d; //  disbelief mass: degree of belief that self is FALSE
	protected double u; //  uncertainty mass: amount of uncommitted belief  
	protected double a; //  base rate: prior probability of self being TRUE

	
    /**
     * Constructors 
     */
    public SBoolean() {
        this.b = 1.0; this.d = 0.0; this.u = 0.0; this.a = 1.0; // Dogmatic TRUE
    }

    public SBoolean(boolean b) {
        if (b) {this.b = 1.0; this.d = 0.0; this.u = 0.0; this.a = 1.0;} // Dogmatic TRUE
        else {this.b = 0.0; this.d = 1.0; this.u = 0.0; this.a = 0.0;} // Dogmatic FDALSE
    }

    public SBoolean(double b, double d, double u, double a) {
    	this.b = b; 
    	this.d = d; 
    	this.u = u; 
    	this.a = a;
    	if (Math.abs(this.b+this.d+this.u-1.0)>0.001 ||
    		this.b<0 || this.d<0 || this.u<0 || this.a<0 || 
    		this.b>1 || this.d>1 || this.u>1 || this.a>1 ) 
    		throw new IllegalArgumentException("Invalid parameters");
    }
	
    public SBoolean(String b, String d, String u, String a) { //creates an UBoolean from two strings representing (x,u).
       	this.b = Double.parseDouble(b); 
    	this.d = Double.parseDouble(d); 
    	this.u = Double.parseDouble(u); 
    	this.a = Double.parseDouble(a);
    	if (Math.abs(this.b+this.d+this.u-1.0)>0.001 ||
        		this.b<0 || this.d<0 || this.u<0 || this.a<0 || 
        		this.b>1 || this.d>1 || this.u>1 || this.a>1 ) throw new IllegalArgumentException("Invalid parameters");
    }
    
    public SBoolean(UBoolean b) { // type embedding -- without uncertainty
       	this.b = b.getC(); 
    	this.d = 1-this.b; 
    	this.u = 0; 
    	this.a = this.b;
    }
   
    /**
     * getters (no setters in order to respect well-formed rules)
     */
    public double belief() {return this.b;} 
    public double disbelief() {return this.d;} 
    public double uncertainty() {return this.u;} 
    public double baseRate() {return this.a;} 

    /*********
     * Auxiliary operations
     */

    public double projection() { // projected probability
    	return this.b + this.a*this.u;
    }
    
	public double projectiveDistance(SBoolean s) { // projectiveDistance
		return Math.abs(this.projection()-s.projection())/2;
	}

	public double conjunctiveCertainty(SBoolean s) {
		return (1.0-this.u)*(1-s.u);
	}
	
	public double degreeOfConflict(SBoolean s) {
		return this.projectiveDistance(s)*this.conjunctiveCertainty(s);
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

	public SBoolean implies(SBoolean s) {

		return this.not().or(s); // this is to be consistent with UBoolean, because in Subjective Logic this is not the case...
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

	public SBoolean uncertaintyMaximized() { // Returns the equivalent SBoolean with maximum uncertainty. 
		 // The dual operation is toUBoolean, which returns the equivalent SBoolean, with u==0
		double p = this.projection();
		// Extreme cases
		if ((this.a == 1.0) && (p==1)) return new SBoolean(0.0,0.0,1,this.a);
		if ((this.a == 1.0) && (this.u==1)) return new SBoolean(0.0,0.0,1,this.a);
		if (this.a == 0.0 && (this.b==0)) return  new SBoolean(0.0,0.0,1,this.a);
		// Normal cases
		if (p < this.a) 
			return new SBoolean(0.0, 1.0 - (p/this.a), p/this.a, this.a);
		return new SBoolean((p-this.a)/(1.0-this.a), 0.0, (1.0-p)/(1.0-this.a), this.a);	
	}

	public SBoolean deduceY(SBoolean yGivenX, SBoolean yGivenNotX) { // DEDUCTION: returns Y, acting "this" as X
		SBoolean y = new SBoolean();
		double px = this.projection();
		double K;
		y.a = (yGivenX.u+yGivenNotX.u < 2.0)? (this.a*yGivenX.b+(1-this.a)*yGivenNotX.b)/(1-this.a*yGivenX.u-(1-this.a)*yGivenNotX.u) : yGivenX.a;
		double pyxhat = yGivenX.b*this.a + yGivenNotX.b*(1-this.a)+ y.a*(yGivenX.u*this.a+yGivenNotX.u*(1-this.a));
		double bIy = this.b*yGivenX.b+this.d*yGivenNotX.b+this.u*(yGivenX.b*this.a+yGivenNotX.b*(1-this.a));
		double dIy = this.b*yGivenX.d+this.d*yGivenNotX.d+this.u*(yGivenX.d*this.a+yGivenNotX.d*(1-this.a));
		double uIy = this.b*yGivenX.u+this.d*yGivenNotX.u+this.u*(yGivenX.u*this.a+yGivenNotX.u*(1-this.a));
		// case I
		//if (((yGivenX.b>yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d))||((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d))) 
		K=0.0;

		// case II.A.1
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat <= (yGivenNotX.b+y.a*(1-yGivenNotX.b-yGivenX.d))) &&
				(px<=this.a) ) 
			{K=(this.a*this.u*(bIy-yGivenNotX.b))/((this.b+this.a*this.u)*y.a);}
		// case II.A.2
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat <= (yGivenNotX.b+y.a*(1-yGivenNotX.b-yGivenX.d))) &&
				(px>this.a) ) 
			{K=(this.a*this.u*(dIy-yGivenX.d)*(yGivenX.b-yGivenNotX.b))/((this.d+(1-this.a)*this.u)*y.a*(yGivenNotX.d-yGivenX.d));}
		// case II.B.1
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat > (yGivenNotX.b+y.a*(1-yGivenNotX.b-yGivenX.d))) &&
				(px<=this.a) ) 
			{K=((1-this.a)*this.u*(bIy-yGivenNotX.b)*(yGivenNotX.d-yGivenX.d))/((this.b+this.a*this.u)*(1-y.a)*(yGivenX.b-yGivenNotX.b));}
		// case II.B.2
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat > (yGivenNotX.b+y.a*(1-yGivenNotX.b-yGivenX.d))) &&
				(px>this.a) ) 
			{K=((1-this.a)*this.u*(dIy-yGivenX.d))/((this.d+(1-this.a)*this.u)*(1-y.a));}

		// case III.A.1
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat <= (yGivenX.b+y.a*(1-yGivenNotX.b-yGivenX.d))) &&
				(px<=this.a) ) 
			{K=((1-this.a)*this.u*(dIy-yGivenNotX.d)*(yGivenNotX.b-yGivenX.b))/((this.b+this.a*this.u)*y.a*(yGivenX.d-yGivenNotX.d));}
		
		// case III.A.2
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat <= (yGivenX.b+y.a*(1-yGivenX.b-yGivenNotX.d))) &&
				(px>this.a) ) 
			{K=((1-this.a)*this.u*(bIy-yGivenX.d))/((this.d+(1-this.a)*this.u)*y.a);}

		// case III.B.1
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat > (yGivenX.b+y.a*(1-yGivenX.b-yGivenNotX.d))) &&
				(px<=this.a) ) 
			{K=(this.a*this.u*(dIy-yGivenNotX.b))/((this.b+this.a*this.u)*(1-y.a));}

		// case III.B.2
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat > (yGivenX.b+y.a*(1-yGivenX.b-yGivenNotX.d))) &&
				(px>this.a) ) 
			{K=(this.a*this.u*(bIy-yGivenX.b)*(yGivenX.d-yGivenNotX.d))/((this.d+(1-this.a)*this.u)*(1-y.a)*(yGivenNotX.b-yGivenX.b));}
		
		y.b = bIy - y.a*K;
		y.d = dIy - (1-y.a)*K;
		y.u = uIy + K;
		return y;
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
