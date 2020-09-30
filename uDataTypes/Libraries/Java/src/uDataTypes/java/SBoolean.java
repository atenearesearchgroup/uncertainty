package uDataTypes.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// BINOMIAL OPINIONS
public class SBoolean implements Cloneable, Comparable<SBoolean> {
	
    public static final SBoolean UNCERTAIN = new SBoolean(0.0D, 0.0D, 1.0D, 0.5D);

    protected double b; // belief mass: degree of belief that self is TRUE
	protected double d; //  disbelief mass: degree of belief that self is FALSE
	protected double u; //  uncertainty mass: amount of uncommitted belief  
	protected double a; //  base rate: prior probability of self being TRUE

	protected double relativeWeight = 1.0D; // For fusion operations

	
    /**
     * Constructors 
     */
    public SBoolean() {
        this.b = 1.0D; this.d = 0.0D; this.u = 0.0D; this.a = 1.0D; // Dogmatic TRUE
        this.relativeWeight = 1.0D;
    }

    public SBoolean(boolean b) {
        if (b) {this.b = 1.0D; this.d = 0.0D; this.u = 0.0D; this.a = 1.0D;} // Dogmatic TRUE
        else {this.b = 0.0D; this.d = 1.0D; this.u = 0.0D; this.a = 0.0D;} // Dogmatic FALSE
        this.relativeWeight = 1.0D;

    }
    
    private double adjust(double value) {
    	return (double)Math.round(value * 1000000d) / 1000000d;
    }

    public SBoolean(double b, double d, double u, double a) {
    	this.b = adjust(b); 
    	this.d = adjust(d); 
    	this.u = adjust(u); 
    	this.a = adjust(a);
        this.relativeWeight = 1.0D;
    	if (Math.abs(this.b+this.d+this.u-1.0D)>0.001D ||
    		this.b<0.0D || this.d<0.0D || this.u<0.0D || this.a<0.0D || 
    		this.b>1.0D || this.d>1.0D || this.u>1.0D || this.a>1.0D ) 
    		throw new IllegalArgumentException("Invalid parameters");
    }
	
    private SBoolean(double b, double d, double u, double a, double relativeWeight) {
    	this.b = adjust(b); 
    	this.d = adjust(d); 
    	this.u = adjust(u); 
    	this.a = adjust(a);
    	this.relativeWeight = adjust(relativeWeight);
    	if (Math.abs(this.b+this.d+this.u-1.0)>0.001 ||
        		this.b<0.0D || this.d<0.0D || this.u<0.0D || this.a<0.0D || 
        		this.b>1.0D || this.d>1.0D || this.u>1.0D || this.a>1.0D ) 
    		throw new IllegalArgumentException("Invalid parameters");
    }
	
    public SBoolean(String b, String d, String u, String a) { //creates an UBoolean from two strings representing (x,u).
       	this.b = adjust(Double.parseDouble(b)); 
    	this.d = adjust(Double.parseDouble(d)); 
    	this.u = adjust(Double.parseDouble(u)); 
    	this.a = adjust(Double.parseDouble(a));
        this.relativeWeight = 1.0D;

    	if (Math.abs(this.b+this.d+this.u-1.0)>0.001 ||
        		this.b<0.0D || this.d<0.0D || this.u<0.0D || this.a<0.0D || 
        		this.b>1.0D || this.d>1.0D || this.u>1.0D || this.a>1.0D ) 
    		throw new IllegalArgumentException("Invalid parameters");
    }
    
    public SBoolean(UBoolean b) { // type embedding -- without uncertainty
       	this.b = adjust(b.getC()); 
    	this.d = 1.0D - this.b; 
    	this.u = 0.0D; 
    	this.a = this.b;
        this.relativeWeight = 1.0D;
    }
   
    /**
     * getters (no public setters in order to respect well-formed rules)
     */
    public double belief() {return this.b;} 
    public double disbelief() {return this.d;} 
    public double uncertainty() {return this.u;} 
    public double baseRate() {return this.a;} 
    
    
    public double getRelativeWeight() {
        return this.isDogmatic()? this.relativeWeight : 0.0D;
    }

    private double getRelativeWeight(SBoolean opinion) {
           return adjust(this.relativeWeight / opinion.relativeWeight);
    }
    
    private void setRelativeWeight(double weight) { this.relativeWeight = adjust(weight); }

 
    /*********
     * Auxiliary operations
     */

    public double projection() { // projected probability
    	return adjust(this.b + this.a*this.u);
    }
    
	public double projectiveDistance(SBoolean s) { // projectiveDistance
		return adjust(Math.abs(this.projection()-s.projection())/2);
	}

	public double conjunctiveCertainty(SBoolean s) {
		return adjust((1.0D-this.u)*(1-s.u));
	}
	
	public double degreeOfConflict(SBoolean s) {
		return adjust(this.projectiveDistance(s)*this.conjunctiveCertainty(s));
	}

	/* public SBoolean increasedUncertainty() {
	        if (this.isVacuous()) return this.clone();
	        
	    	double sqrt_u = Math.sqrt(this.uncertainty());
	        double k = 1.0D - (sqrt_u - this.uncertainty()) / (this.belief() + this.disbelief());

	        double brBelief = this.belief() * k;
	        double brUncertainty = sqrt_u;
	        double brDisbelief = this.disbelief() * k;

	        return new SBoolean(brBelief, brDisbelief, brUncertainty, this.baseRate());
	    }
	*/

	public boolean isAbsolute() {
	    return (this.belief() == 1.0D) || (this.disbelief() == 1.0D);
	}

	public boolean isVacuous() {
	        return this.uncertainty() == 1.0D;
	}

	public boolean isCertain(double threshold) {
	    return !isUncertain(threshold);
    }

	public boolean isDogmatic() {
	    return this.uncertainty() == 0.0D;
	}

	public boolean isMaximizedUncertainty() {
	    return (this.disbelief() == 0.0D) || (this.belief() == 0.0D);
	}

	public boolean isUncertain(double threshold) {
	    return 1.0D - this.uncertainty() < threshold;
	}

	public SBoolean uncertainOpinion() {
	    return this.uncertaintyMaximized();
	}
	
    public final double certainty()
    {
        if (this.uncertainty() == (0.0D / 0.0D)) return (0.0D / 0.0D);
        return 1.0D - this.uncertainty();
    }

	/**
	 * Dogmatic opinions are opinions with complete certainty (i.e., uncertainty = 0).
	 *
	 * @param projection
	 * @param baseRate a-priori probability
	 * @return
	 */
	public static SBoolean createDogmaticOpinion(double projection, double baseRate) {
	   if ((projection < 0.0D) || (projection > 1.0D) || (baseRate < 0.0D) || (baseRate > 1.0D)) {
	       throw new IllegalArgumentException("Expectation e, must be 0 <= e <= 1");
	   }
	   return new SBoolean(projection, 1.0D - projection, 0.0D, baseRate);
	}

	/**
	 * Vacuous opinions have an uncertainty of 1.
	 * @param projection
	 * @return
	 */
	public static SBoolean createVacuousOpinion(double projection) {
	   if ((projection < 0.0D) || (projection > 1.0D)) {
	       throw new IllegalArgumentException("Projection must be between 0 and 1");
	   }
	   return new SBoolean(0.0D, 0.0D, 1.0D, projection);
	}



    /*********
     * Type Operations
     */

    public SBoolean not() {
	   SBoolean result = new SBoolean(
			   this.d,
			   this.b,
			   this.u,
			   1.0D-this.a,
			   this.relativeWeight);
	   return result;
    }

	public SBoolean and(SBoolean s) { // assumes independent variables

		if (this==s) return this.clone(); // x and x = x
		
		SBoolean result = new SBoolean(
				this.b*s.b + (this.a*s.a==1.0D? 0: ((1.0D-this.a)*s.a*this.b*s.u+this.a*(1.0D-s.a)*this.u*s.b)/(1.0D-this.a*s.a)),
				this.d + s.d- this.d*s.d,
				this.u*s.u + (this.a*s.a==1.0D? 0: ((1.0D-s.a)*this.b*s.u+(1.0D-this.a)*this.u*s.b)/(1.0D-this.a*s.a)),
				this.a*s.a,
				this.getRelativeWeight() + s.getRelativeWeight()
		);
		return result;
	}
	
	public SBoolean or(SBoolean s) {// assumes independent variables

		if (this==s) return this.clone(); // x or x
		
		SBoolean result = new SBoolean(
				this.b + s.b - this.b*s.b,
				this.d*s.d + (this.a + s.a == this.a*s.a? 0: (this.a*(1-s.a)*this.d*s.u+s.a*(1-this.a)*this.u*s.d)/(this.a + s.a - this.a*s.a)),
				this.u*s.u + (this.a + s.a == this.a*s.a? 0: (s.a*this.d*s.u+this.a*this.u*s.d)/(this.a + s.a - this.a*s.a)),
				this.a + s.a - this.a*s.a,
				this.getRelativeWeight() + s.getRelativeWeight() 
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
				1.0D - java.lang.Math.abs(this.b - s.b) - this.u*s.u, //1.0-(this.b*(1.0-s.b)+(1.0-this.b)*s.b)-this.u*s.u,
				this.u*s.u,
				java.lang.Math.abs(this.a - s.a), // this.a*(1.0-s.a)+(1.0-this.a)*s.a 
				this.getRelativeWeight() + s.getRelativeWeight()
		);
		 return result;
		//return this.equivalent(b).not();
	}

	public SBoolean uncertaintyMaximized() { // Returns the equivalent SBoolean with maximum uncertainty. 
		 // The dual operation is toUBoolean, which returns the equivalent SBoolean, with u==0
		// return this.increasedUncertainty();
		// Replaced by another version
		double p = this.projection();
		// Extreme cases
		if ((this.a == 1.0D) && (p==1.0D)) return new SBoolean(0.0D,0.0D,1.0D,this.a,this.getRelativeWeight());
		if ((this.a == 1.0D) && (this.u==1.0D)) return new SBoolean(0.0D,0.0D,1.0D,this.a,this.getRelativeWeight());
		if (this.a == 0.0D && (this.b==0.0D)) return  new SBoolean(0.0D,0.0D,1.0D,this.a,this.getRelativeWeight());
		// Normal cases
		if (p < this.a) 
			return new SBoolean(0.0D, 1.0D - (p/this.a), p/this.a, this.a,this.getRelativeWeight());
		return new SBoolean((p-this.a)/(1.0D-this.a), 0.0D, (1.0D-p)/(1.0D-this.a), this.a,this.getRelativeWeight());	
		
		}

	public SBoolean deduceY(SBoolean yGivenX, SBoolean yGivenNotX) { // DEDUCTION: returns Y, acting "this" as X
		SBoolean y = new SBoolean();
		double px = this.projection();
		double K;
		y.a = (yGivenX.u+yGivenNotX.u < 2.0D)? (this.a*yGivenX.b+(1.0D-this.a)*yGivenNotX.b)/(1.0D-this.a*yGivenX.u-(1.0D-this.a)*yGivenNotX.u) : yGivenX.a;
		double pyxhat = yGivenX.b*this.a + yGivenNotX.b*(1-this.a)+ y.a*(yGivenX.u*this.a+yGivenNotX.u*(1-this.a));
		double bIy = this.b*yGivenX.b+this.d*yGivenNotX.b+this.u*(yGivenX.b*this.a+yGivenNotX.b*(1.0D-this.a));
		double dIy = this.b*yGivenX.d+this.d*yGivenNotX.d+this.u*(yGivenX.d*this.a+yGivenNotX.d*(1.0D-this.a));
		double uIy = this.b*yGivenX.u+this.d*yGivenNotX.u+this.u*(yGivenX.u*this.a+yGivenNotX.u*(1.0D-this.a));
		// case I
		//if (((yGivenX.b>yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d))||((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d))) 
		K=0.0D;

		// case II.A.1
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat <= (yGivenNotX.b+y.a*(1.0D-yGivenNotX.b-yGivenX.d))) &&
				(px<=this.a) ) 
			{K=(this.a*this.u*(bIy-yGivenNotX.b))/((this.b+this.a*this.u)*y.a);}
		// case II.A.2
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat <= (yGivenNotX.b+y.a*(1.0D-yGivenNotX.b-yGivenX.d))) &&
				(px>this.a) ) 
			{K=(this.a*this.u*(dIy-yGivenX.d)*(yGivenX.b-yGivenNotX.b))/((this.d+(1.0D-this.a)*this.u)*y.a*(yGivenNotX.d-yGivenX.d));}
		// case II.B.1
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat > (yGivenNotX.b+y.a*(1.0D-yGivenNotX.b-yGivenX.d))) &&
				(px<=this.a) ) 
			{K=((1.0D-this.a)*this.u*(bIy-yGivenNotX.b)*(yGivenNotX.d-yGivenX.d))/((this.b+this.a*this.u)*(1.0D-y.a)*(yGivenX.b-yGivenNotX.b));}
		// case II.B.2
		if ((yGivenX.b>yGivenNotX.b)&&(yGivenX.d<=yGivenNotX.d)&&
				(pyxhat > (yGivenNotX.b+y.a*(1.0D-yGivenNotX.b-yGivenX.d))) &&
				(px>this.a) ) 
			{K=((1.0D-this.a)*this.u*(dIy-yGivenX.d))/((this.d+(1.0D-this.a)*this.u)*(1.0D-y.a));}

		// case III.A.1
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat <= (yGivenX.b+y.a*(1.0D-yGivenNotX.b-yGivenX.d))) &&
				(px<=this.a) ) 
			{K=((1.0D-this.a)*this.u*(dIy-yGivenNotX.d)*(yGivenNotX.b-yGivenX.b))/((this.b+this.a*this.u)*y.a*(yGivenX.d-yGivenNotX.d));}
		
		// case III.A.2
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat <= (yGivenX.b+y.a*(1.0D-yGivenX.b-yGivenNotX.d))) &&
				(px>this.a) ) 
			{K=((1.0D-this.a)*this.u*(bIy-yGivenX.d))/((this.d+(1.0D-this.a)*this.u)*y.a);}

		// case III.B.1
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat > (yGivenX.b+y.a*(1.0D-yGivenX.b-yGivenNotX.d))) &&
				(px<=this.a) ) 
			{K=(this.a*this.u*(dIy-yGivenNotX.b))/((this.b+this.a*this.u)*(1.0D-y.a));}

		// case III.B.2
		if ((yGivenX.b<=yGivenNotX.b)&&(yGivenX.d>yGivenNotX.d)&&
				(pyxhat > (yGivenX.b+y.a*(1.0D-yGivenX.b-yGivenNotX.d))) &&
				(px>this.a) ) 
			{K=(this.a*this.u*(bIy-yGivenX.b)*(yGivenX.d-yGivenNotX.d))/((this.d+(1.0D-this.a)*this.u)*(1.0D-y.a)*(yGivenNotX.b-yGivenX.b));}
		
		y.b = adjust(bIy - y.a*K);
		y.d = adjust(dIy - (1.0D-y.a)*K);
		y.u = adjust(uIy + K);
        y.setRelativeWeight(yGivenX.getRelativeWeight() + yGivenNotX.getRelativeWeight());
		return y;
	}
	
	/************************************
	 *  FUSION OPERATIONS 
	 *  Implementations are based in those given in https://github.com/vs-uulm/subjective-logic-java
	 *  */
	
	 /**
     * This method implements MIN fusion. This takes the minimum, i.e., returns the opinion with 
     * the lowest probability of being true, meaning the lowest projected probability P(X=x).
     *
     * @param opinions a collection of opinions from different sources.
     * @return a new SBoolean that represents the fused evidence.
     * @throws IllegalArgumentException
     */
    public static SBoolean minimumBeliefFusion(Collection<SBoolean> opinions) {
        if (opinions.contains(null) || opinions.size() < 2)
            throw new IllegalArgumentException("Cannot fuse null opinions, or only one opinion was passed");

        SBoolean min = null;
        for (SBoolean so : opinions) {
            if (min == null) min = so;
            min = min.min(so);
        }
        return min.clone();
    }

    /**
     * This method implements MAJORITY fusion. This returns a new dogmatic opinion that specifies the 
     * decision of the majority.
     * If the majority is tied, a vacuous opinion is returned.
     * It is assumed that the base rates of all opinions are equal.
     * For this operation, opinions that are undecided (projections equals base rate) are ignored.
     *
     * @param opinions a collection of opinions from different sources.
     * @return a new SBoolean that represents the fused evidence.
     * @throws IllegalArgumentException
     */
    public static SBoolean majorityBeliefFusion(Collection<SBoolean> opinions) {
        if (opinions.contains(null) || opinions.size() < 2)
            throw new IllegalArgumentException("Cannot fuse null opinions, or only one opinion was passed");
        int pos=0,neg=0;
        for (SBoolean so: opinions) {
            if(so.projection() < so.a)
                neg++;
            else if (so.projection() > so.a)
                pos++;
        }
        if(pos>neg) return new SBoolean(1D,0D,0D,0.5D); 		// true
        else if(pos<neg) return new SBoolean(0D,1D,0D,0.5D); 	// false
        else return new SBoolean(0D,0D,1D,0.5D); 				// uncertain
    }
    
    /** 
     * This method implements AVERAGE fusion.
     *
     * @param opinions a collection of opinions from different sources.
     * @return a new SBoolean that represents the fused evidence.
     * @throws IllegalArgumentException
     */

   protected static SBoolean averageBeliefFusion(Collection<SBoolean> opinions)
    {
       if (opinions == null || opinions.contains(null) || opinions.isEmpty())
           throw new IllegalArgumentException("Cannot average null opinions");

        int count = 0;

        double b = 0.0D; double a = 0.0D; double p = 0.0D;

        for (SBoolean opinion : opinions) {
            if (opinion != null)
            {
                count++;
                b += opinion.b;
                a += opinion.a;
                p += opinion.projection();
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("Opinions must not be empty");
        }
        double oBelief = b / count;
        double oAtomicity = a / count;
        double oUncertainty = (p / count - oBelief) / oAtomicity;
        double oDisbelief = 1.0D - oBelief - oUncertainty;

        return new SBoolean(oBelief, oDisbelief, oUncertainty, oAtomicity);
    }
   
   /**
    * This method implements cumulative belief fusion (CBF) for multiple sources, as discussed in the corrected
    * version of <a href="https://folk.uio.no/josang/papers/JWZ2017-FUSION.pdf">a FUSION 2017 paper by Josang et al.</a>
    *
    * As discussed in the book, cumulative fusion is useful in scenarios where opinions from multiple sources 
    * are combined, where each source is relying on independent (in the statistical sense) evidence.
    * 
    * 
    * @param opinions a collection of opinions from different sources.
    * @return a new SBoolean that represents the fused evidence based on evidence accumulation.
    * @throws IllegalArgumentException
    */
   public static SBoolean cumulativeBeliefFusion(Collection<SBoolean> opinions) {
       //handle edge cases
       if (opinions == null || opinions.contains(null) || opinions.isEmpty())
           throw new IllegalArgumentException("Cannot average null opinions");
 
       if (opinions.size() == 1){
           return opinions.iterator().next().clone();
       }

       //fusion as defined by Josang
       double resultBelief, resultDisbelief, resultUncertainty, resultRelativeWeight = 0, resultAtomicity = -1;

       Collection<SBoolean> dogmatic = new ArrayList<>(opinions.size());
       Iterator<SBoolean> it = opinions.iterator();
       boolean first = true;
       while(it.hasNext()) {
    	   SBoolean o = it.next();
           if(first) {
               resultAtomicity = o.baseRate();
               first = false;
           }
           //dogmatic iff uncertainty is zero.
           if (o.uncertainty() == 0.0D)
               dogmatic.add(o);
       }

       if(dogmatic.isEmpty()){
           //there are no dogmatic opinions -- case I/Eq16 of 10.23919/ICIF.2017.8009820
           double productOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).reduce(1.0D, (acc, u) -> acc * u);

           double numerator = 0.0D;
           double beliefAccumulator = 0.0D;
           double disbeliefAccumulator = 0.0D;

           //this computes the top and bottom sums in Eq16, but ignores the - (N-1) * productOfUncertainties in the numerator (see below)
           for (SBoolean o : opinions) {
               //productWithoutO = product of uncertainties without o's uncertainty
               //this can be rewritten:
               //prod {C_j != C } u^{C_j} = (u^C)^-1 * prod{C_j} u^{C_j} = 1/(u^C) * prod{C_j} u^{C_j}
               //so instead of n-1 multiplications, we only need a division
               double productWithoutO = productOfUncertainties / o.uncertainty();

               beliefAccumulator = beliefAccumulator + productWithoutO * o.belief();
               disbeliefAccumulator = disbeliefAccumulator + productWithoutO * o.disbelief();
               numerator = numerator + productWithoutO;
           }

           //this completes the numerator:
           numerator = numerator - (opinions.size() - 1) * productOfUncertainties;

           resultBelief = beliefAccumulator / numerator;
           resultDisbelief = disbeliefAccumulator / numerator;
           resultUncertainty = productOfUncertainties / numerator;

           resultRelativeWeight = 0.0D;
       } else {
           //at least 1 dogmatic opinion
           //note: this computation assumes that the relative weight represents how many opinions have been fused into that opinion.
           //for a normal multi-source fusion operation, this should be 1, in which case the gamma's in Eq17 are 1/N as noted in the text (i.e., all opinions count equally)
           //however, this formulation also allows partial fusion beforehand, by "remembering" the amount of dogmatic (!) opinions in o.relativeWeight.

           double totalWeight = dogmatic.stream().mapToDouble( o -> o.getRelativeWeight()).sum();

           resultBelief = dogmatic.stream().mapToDouble(o-> o.getRelativeWeight()/totalWeight * (o).belief()).sum();

           resultDisbelief = dogmatic.stream().mapToDouble(o-> o.getRelativeWeight()/totalWeight * (o).disbelief()).sum();

           resultUncertainty = 0.0D;

           resultRelativeWeight = totalWeight;
       }

       SBoolean result = new SBoolean(resultBelief, resultDisbelief, resultUncertainty, resultAtomicity,resultRelativeWeight);
       return result;
   }

   /**
    * This method implements epistemic cumulative belief fusion (eCBF) for multiple sources, 
    * as discussed in the corrected
    * version of <a href="https://folk.uio.no/josang/papers/JWZ2017-FUSION.pdf">a FUSION 2017 paper by Josang et al.</a>
    *
    * eCBF is useful when the opinions represent knowledge, and not observations, and therefore they are
    * uncertainty maximized. As in the CBF, each source is supposed to be relying on independent 
    * (in the statistical sense) evidence (in this case, knowledge).
    * 
    * 
    * @param opinions a collection of opinions from different sources.
    * @return a new SBoolean that represents the fused evidence based on evidence accumulation.
    * @throws IllegalArgumentException
    */
   public static SBoolean epistemicCumulativeBeliefFusion(Collection<SBoolean> ops) {
       //handle edge cases
       if (ops == null || ops.contains(null) || ops.isEmpty())
           throw new IllegalArgumentException("Cannot average null opinions");
 
       if (ops.size() == 1){
           return ops.iterator().next().uncertaintyMaximized();
       }
       
       //generate uncertaintyMaximized() versions of opinions
       Collection<SBoolean> opinions = new ArrayList<>(ops.size());
       for (SBoolean o:ops) {
    	   opinions.add(o.uncertaintyMaximized());
       }
 
       //fusion as defined by Josang
       double resultBelief, resultDisbelief, resultUncertainty, resultRelativeWeight = 0, resultAtomicity = -1;

       Collection<SBoolean> dogmatic = new ArrayList<>(opinions.size());
       Iterator<SBoolean> it = opinions.iterator();
       boolean first = true;
       while(it.hasNext()) {
    	   SBoolean o = it.next().uncertaintyMaximized();
           if(first) {
               resultAtomicity = o.baseRate();
               first = false;
           }
           //dogmatic iff uncertainty is zero.
           if (o.uncertainty() == 0.0D)
               dogmatic.add(o);
       }

       if(dogmatic.isEmpty()){
           //there are no dogmatic opinions -- case I/Eq16 of 10.23919/ICIF.2017.8009820
           double productOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).reduce(1.0D, (acc, u) -> acc * u);

           double numerator = 0.0D;
           double beliefAccumulator = 0.0D;
           double disbeliefAccumulator = 0.0D;

           //this computes the top and bottom sums in Eq16, but ignores the - (N-1) * productOfUncertainties in the numerator (see below)
           for (SBoolean o : opinions) {
               //productWithoutO = product of uncertainties without o's uncertainty
               //this can be rewritten:
               //prod {C_j != C } u^{C_j} = (u^C)^-1 * prod{C_j} u^{C_j} = 1/(u^C) * prod{C_j} u^{C_j}
               //so instead of n-1 multiplications, we only need a division
               double productWithoutO = productOfUncertainties / o.uncertainty();

               beliefAccumulator = beliefAccumulator + productWithoutO * o.belief();
               disbeliefAccumulator = disbeliefAccumulator + productWithoutO * o.disbelief();
               numerator = numerator + productWithoutO;
           }

           //this completes the numerator:
           numerator = numerator - (opinions.size() - 1) * productOfUncertainties;

           resultBelief = beliefAccumulator / numerator;
           resultDisbelief = disbeliefAccumulator / numerator;
           resultUncertainty = productOfUncertainties / numerator;

           resultRelativeWeight = 0.0D;
       } else {
           //at least 1 dogmatic opinion
           //note: this computation assumes that the relative weight represents how many opinions have been fused into that opinion.
           //for a normal multi-source fusion operation, this should be 1, in which case the gamma's in Eq17 are 1/N as noted in the text (i.e., all opinions count equally)
           //however, this formulation also allows partial fusion beforehand, by "remembering" the amount of dogmatic (!) opinions in o.relativeWeight.

           double totalWeight = dogmatic.stream().mapToDouble( o -> o.getRelativeWeight()).sum();

           resultBelief = dogmatic.stream().mapToDouble(o-> o.getRelativeWeight()/totalWeight * (o).belief()).sum();

           resultDisbelief = dogmatic.stream().mapToDouble(o-> o.getRelativeWeight()/totalWeight * (o).disbelief()).sum();

           resultUncertainty = 0.0D;

           resultRelativeWeight = totalWeight;
       }

       SBoolean result = new SBoolean(resultBelief, resultDisbelief, resultUncertainty, resultAtomicity,resultRelativeWeight);
       return result;
   }

   /**
    * This method implements weighted belief fusion (WBF) for multiple sources, as discussed in a FUSION 2018 paper by van der Heijden et al. that is currently under review.
    *
    * As discussed in the book, WBF is intended to represent the confidence-weighted averaging of evidence.
    * Similar to AverageBF, it is useful when dependence between sources is assumed. However, WBF introduces 
    * additional weights to increase the significance of sources that possess high certainty. 
    *
    * @param opinions a collection of opinions from different sources.
    * @return a new SubjectiveOpinion that represents the fused evidence based on confidence-weighted averaging of evidence.
    * @throws OpinionArithmeticException
    */
   public static SBoolean weightedBeliefFusion(Collection<SBoolean> opinions) {
       if (opinions == null || opinions.contains(null) || opinions.isEmpty())
           throw new IllegalArgumentException("Cannot average null opinions");

       if (opinions.size() == 1) {
           return opinions.iterator().next().clone();
       }

       double resultBelief, resultDisbelief, resultUncertainty, resultRelativeWeight = 0, resultAtomicity;

       Collection<SBoolean> dogmatic = new ArrayList<>(opinions.size());
       Iterator<SBoolean> it = opinions.iterator();
       while(it.hasNext()) {
    	   SBoolean o = it.next();
           //dogmatic iff uncertainty is zero.
           if (o.uncertainty() == 0) 
               dogmatic.add(o);
       }

       if (dogmatic.isEmpty() && opinions.stream().anyMatch(o -> o.certainty() > 0)) {
           //Case 1: no dogmatic opinions, at least one non-vacuous opinion
           double productOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).reduce(1.0D, (acc, u) -> acc * u);
           double sumOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).sum();

           double numerator = 0.0D;
           double beliefAccumulator = 0.0D;
           double disbeliefAccumulator = 0.0D;
           double atomicityAccumulator = 0.0D;

           for (SBoolean o : opinions) {
               //prod = product of uncertainties without o's uncertainty
               double prod = productOfUncertainties / o.uncertainty();

               //recall certainty = 1 - uncertainty
               beliefAccumulator = beliefAccumulator + prod * o.belief() * o.certainty();
               disbeliefAccumulator = disbeliefAccumulator + prod * o.disbelief() * o.certainty();
               atomicityAccumulator = atomicityAccumulator + o.baseRate() * o.certainty();
               numerator = numerator + prod;
           }

           numerator = numerator - opinions.size() * productOfUncertainties;

           resultBelief = beliefAccumulator / numerator;
           resultDisbelief = disbeliefAccumulator / numerator;
           resultUncertainty = (opinions.size() - sumOfUncertainties) * productOfUncertainties / numerator;
           resultAtomicity = atomicityAccumulator / (opinions.size() - sumOfUncertainties);
       } else if (opinions.stream().allMatch(o -> o.uncertainty() == 1)) {
           //Case 3 -- everything is vacuous
           resultBelief = 0;
           resultDisbelief = 0;
           resultUncertainty = 1;
           boolean first = true;

           //all confidences are zero, so the weight for each opinion is the same -> use a plain average for the resultAtomicity
           resultAtomicity = 0;
           for (SBoolean o : opinions) {
               if (first) {
                   resultAtomicity = resultAtomicity + o.baseRate();
                   first = false;
               }
           }
           resultAtomicity = resultAtomicity / ((double)opinions.size());

       } else {
           //Case 2 -- dogmatic opinions are involved
           double totalWeight = dogmatic.stream().mapToDouble( o -> o.getRelativeWeight()).sum();

           resultBelief = dogmatic.stream().mapToDouble(o-> o.getRelativeWeight()/totalWeight * o.belief()).sum();

           resultDisbelief = dogmatic.stream().mapToDouble(o-> o.getRelativeWeight()/totalWeight * o.disbelief()).sum();

           resultUncertainty = 0.0D;

           resultRelativeWeight = totalWeight;

           //note: the for loop below will always set resultAtomicity correctly.
           resultAtomicity = -1;
           boolean first = true;
           for(SBoolean o : opinions){
               if (first) {
                   resultAtomicity = o.baseRate();
                   first = false;
               }
           }
       }

       SBoolean result = new SBoolean(resultBelief, resultDisbelief, resultUncertainty, resultAtomicity,resultRelativeWeight);
       return result;
   }

	/************************************ 
	 * BINARY VERSIONS OF FUSING OPERATIONS
	 * 
	 */

   public final SBoolean cumulativeFusion(SBoolean opinion) {
       Collection<SBoolean> opinions = new ArrayList<>();
       opinions.add(this);
       opinions.add(opinion);
       return cumulativeBeliefFusion(opinions);
   }

   public final SBoolean epistemicCumulativeFusion(SBoolean opinion) {
       Collection<SBoolean> opinions = new ArrayList<>();
       opinions.add(this);
       opinions.add(opinion);
       return epistemicCumulativeBeliefFusion(opinions);
   }

     public final SBoolean weightedFusion(SBoolean opinion) {
       Collection<SBoolean> opinions = new ArrayList<>();
       opinions.add(this);
       opinions.add(opinion);
       return weightedBeliefFusion(opinions);
   }

   
   public final SBoolean minimumFusion(SBoolean opinion) {
       Collection<SBoolean> opinions = new ArrayList<>();
       opinions.add(this);
       opinions.add(opinion);
       return minimumBeliefFusion(opinions);
   }

   public final SBoolean majorityFusion(SBoolean opinion) {
       Collection<SBoolean> opinions = new ArrayList<>();
       opinions.add(this);
       opinions.add(opinion);
       return majorityBeliefFusion(opinions);
   }

   public final SBoolean averageFusion(SBoolean opinion) {
       Collection<SBoolean> opinions = new ArrayList<>();
       opinions.add(this);
       opinions.add(opinion);
       return averageBeliefFusion(opinions);
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
	
	public SBoolean min(SBoolean opinion) { // minimum based on projections
		return this.projection() <= opinion.projection()? this : opinion;
	}

	public SBoolean max(SBoolean opinion) { // maximum based on projections
		return this.projection() >= opinion.projection()? this : opinion;
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
		return new SBoolean(this.b,this.d,this.u,this.a,this.relativeWeight);
	}

}
