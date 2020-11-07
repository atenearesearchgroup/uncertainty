package uDataTypes;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

//import junit.framework.*;

class Test {
	
	void test1() {
		final SBoolean t = new SBoolean();
		System.out.println(
				"t=" + t + " p=" + t.projection() + " mu=" + t.uncertaintyMaximized() + " uBoolean=" + t.toUBoolean());
		final SBoolean f = new SBoolean(new UBoolean(true, 0));
		System.out.println(
				"f=" + f + " p=" + f.projection() + " mu=" + f.uncertaintyMaximized() + " uBoolean=" + f.toUBoolean());

		final SBoolean b = new SBoolean(0.7, 0.1, 0.2, 0.5);
		System.out.println("b=" + b + " p=" + b.projection() + " mu=" + b.uncertaintyMaximized() + " uBoolean="
				+ b.toUBoolean());
		
		final SBoolean b0 = new SBoolean(0.85, 0.05, 0.10, 0.9);
		System.out.println("b0=" + b0 + " p=" + b0.projection() + " mu=" + b0.uncertaintyMaximized() + " uBoolean="
				+ b0.toUBoolean());
		
		final SBoolean b1 = new SBoolean(new UBoolean(true, 0.7));
		System.out.println("b1=" + b1 + " p=" + b1.projection() + " mu=" + b1.uncertaintyMaximized() + " uBoolean="
				+ b1.toUBoolean());
		final SBoolean b2 = new SBoolean(new UBoolean(false, 0.7));
		System.out.println("b2=" + b2 + " p=" + b2.projection() + " mu=" + b2.uncertaintyMaximized() + " uBoolean="
				+ b2.toUBoolean());
		final SBoolean b3 = new SBoolean(0.2, 0.6, 0.2, 0.5);
		System.out.println("b3=" + b3 + " p=" + b3.projection() + " mu=" + b3.uncertaintyMaximized() + " uBoolean="
				+ b3.toUBoolean());
		final SBoolean b4 = new SBoolean(0.6, 0.2, 0.2, 0.5);
		System.out.println("b4=" + b4 + " p=" + b4.projection() + " mu=" + b4.uncertaintyMaximized() + " uBoolean="
				+ b4.toUBoolean());

		final SBoolean torf = t.or(f);
		System.out.println("torf=" + torf + " p=" + torf.projection() + " mu=" + torf.uncertaintyMaximized()
				+ " uBoolean=" + torf.toUBoolean());
		final SBoolean tandf = t.and(f);
		System.out.println("tandf=" + tandf + " p=" + tandf.projection() + " mu=" + tandf.uncertaintyMaximized()
				+ " uBoolean=" + tandf.toUBoolean());

		final SBoolean torf1 = t.or(b1);
		System.out.println("torb1=" + torf1 + " p=" + torf1.projection() + " mu=" + torf1.uncertaintyMaximized()
				+ " uBoolean=" + torf1.toUBoolean());
		final SBoolean tandf1 = t.and(b1);
		System.out.println("tandb1=" + tandf1 + " p=" + tandf1.projection() + " mu=" + tandf1.uncertaintyMaximized()
				+ " uBoolean=" + tandf1.toUBoolean());

		final SBoolean torf2 = b3.or(b4);
		System.out.println("torf2=" + torf2 + " p=" + torf2.projection() + " mu=" + torf2.uncertaintyMaximized()
				+ " uBoolean=" + torf2.toUBoolean());
		final SBoolean tandf2 = b3.and(b4);
		System.out.println("tandf2=" + tandf2 + " p=" + tandf2.projection() + " mu=" + tandf2.uncertaintyMaximized()
				+ " uBoolean=" + tandf2.toUBoolean());

		final SBoolean txorf = b1.xor(b2);
		System.out.println("txorf=" + txorf + " p=" + txorf.projection() + " mu=" + txorf.uncertaintyMaximized()
				+ " uBoolean=" + txorf.toUBoolean());
		final SBoolean tequif = b1.equivalent(b2);
		System.out.println("tequif=" + tequif + " p=" + tequif.projection() + " mu=" + tequif.uncertaintyMaximized()
				+ " uBoolean=" + tequif.toUBoolean());
		System.out.println(b1.toUBoolean().xor(b2.toUBoolean()));
		System.out.println(b1.toUBoolean().equivalent(b2.toUBoolean()));

		final SBoolean txorf2 = b3.xor(b4);
		System.out.println("txorf2=" + txorf2 + " p=" + txorf2.projection() + " mu=" + txorf2.uncertaintyMaximized()
				+ " uBoolean=" + txorf2.toUBoolean());
		final SBoolean tequif2 = b3.equivalent(b4);
		System.out.println("tequif2=" + tequif2 + " p=" + tequif2.projection() + " mu=" + tequif2.uncertaintyMaximized()
				+ " uBoolean=" + tequif2.toUBoolean());
		System.out.println(b3.toUBoolean().xor(b4.toUBoolean()));
		System.out.println(b3.toUBoolean().equivalent(b4.toUBoolean()));

		final SBoolean b3equivB4 = b3.implies(b4).and(b4.implies(b3));
	System.out.println("b3equivB4="+b3equivB4+" p="+b3equivB4.projection()+" mu="+b3equivB4.uncertaintyMaximized()+" uBoolean="+b3equivB4.toUBoolean());
	
	System.out.println(txorf.hashCode());
	System.out.println(tequif.hashCode());
	System.out.println(txorf2.hashCode());
	System.out.println(tequif2.hashCode());
	
	SBoolean b5 = new SBoolean(0.4,0.2,0.4,0.9);
	System.out.println("b5="+b5+" p="+b5.projection()+" mu="+b5.uncertaintyMaximized()+" uBoolean="+b5.toUBoolean());
	
	b5 = (new SBoolean(0.75,0.15,0.1,0.5)).and(new SBoolean(0.1,0,0.9,0.2));
	System.out.println("b5="+b5+" p="+b5.projection()+" mu="+b5.uncertaintyMaximized()+" uBoolean="+b5.toUBoolean());
	
	b5 = (new SBoolean(0.75,0.15,0.1,0.5)).or(new SBoolean(0.35,0,0.65,0.2));
	System.out.println("b5="+b5+" p="+b5.projection()+" mu="+b5.uncertaintyMaximized()+" uBoolean="+b5.toUBoolean());
	
	SBoolean x = new SBoolean(0.0,0.0,1,0.8);
	SBoolean yGivenX = new SBoolean(0.4,0.5,0.1,0.4);
	SBoolean yGivenNotX = new SBoolean(0.0,0.4,0.6,0.4);
	SBoolean y = x.deduceY(yGivenX, yGivenNotX);
	System.out.println("y="+y+" p="+y.projection()+" mu="+y.uncertaintyMaximized()+" uBoolean="+y.toUBoolean());


	x = new SBoolean(0.10,0.8,0.1,0.8);
	yGivenX = new SBoolean(0.4,0.5,0.1,0.4);
	yGivenNotX = new SBoolean(0.0,0.4,0.6,0.4);
	y = x.deduceY(yGivenX, yGivenNotX);
	System.out.println("y="+y+" p="+y.projection()+" mu="+y.uncertaintyMaximized()+" uBoolean="+y.toUBoolean());

	x = new SBoolean(0.0,0.40,0.6,0.5);
	yGivenX = new SBoolean(0.55,0.3,0.15,0.38);
	yGivenNotX = new SBoolean(0.1,0.75,0.15,0.38);
	y = x.deduceY(yGivenX, yGivenNotX);
	System.out.println("y="+y+" p="+y.projection()+" mu="+y.uncertaintyMaximized()+" uBoolean="+y.toUBoolean());

	}
	
	void test2() {
		SBoolean b1 = new SBoolean(0.55,0.3,0.15,0.38);
		SBoolean b2 = new SBoolean(0.6,0.3,0.1,0.38);
		SBoolean b3 = new SBoolean(0.7,0.2,0.1,0.38);
		SBoolean b4 = new SBoolean(0.8,0.1,0.1,0.38);
		SBoolean b5 = new SBoolean(0.9,0.05,0.05,0.38);
		
	    SBoolean wcf, majF, minF, aCCF, eCCF, ACF, CCF, BCF;
	    Collection<SBoolean> opinions = new ArrayList<>();
	    opinions.add(b1);
	    opinions.add(b2);
	    opinions.add(b3);
	    opinions.add(b4);
	    opinions.add(b5);

	    wcf = SBoolean.weightedBeliefFusion(opinions);
		System.out.println("Wei="+wcf+" p="+wcf.projection()+" w="+wcf.getRelativeWeight());
	    majF = SBoolean.majorityBeliefFusion(opinions);
		System.out.println("Maj="+majF+" p="+majF.projection()+" w="+majF.getRelativeWeight());
	    minF = SBoolean.minimumBeliefFusion(opinions);
		System.out.println("Min="+minF+" p="+minF.projection()+" w="+minF.getRelativeWeight());
	    ACF = SBoolean.averageBeliefFusion(opinions);
		System.out.println("Avg="+ACF+" p="+ACF.projection()+" w="+ACF.getRelativeWeight());
	    aCCF = SBoolean.cumulativeBeliefFusion(opinions);
		System.out.println("aCu="+aCCF+" p="+aCCF.projection()+" w="+aCCF.getRelativeWeight());
	    eCCF = SBoolean.epistemicCumulativeBeliefFusion(opinions);
		System.out.println("eCu="+eCCF+" p="+eCCF.projection()+" w="+eCCF.getRelativeWeight());
	    BCF = SBoolean.beliefConstraintFusion(opinions);
		System.out.println("CBF="+BCF+" p="+BCF.projection()+" w="+BCF.getRelativeWeight());

		System.out.println("---");
		
		Collection<SBoolean> opinions2 = new ArrayList<>();
	    opinions2.add(b1);
	    opinions2.add(b2);
	    opinions2.add(b3);
	    opinions2.add(b4);
	    opinions2.add(b5);
	    CCF = SBoolean.concensusAndCompromiseFusion(opinions2);
		System.out.println("C&C="+CCF+" p="+CCF.projection()+" w="+CCF.getRelativeWeight());
	    BCF = SBoolean.beliefConstraintFusion(opinions2);
		System.out.println("CBF="+BCF+" p="+BCF.projection()+" w="+BCF.getRelativeWeight());
		System.out.println("---");
		
		
		Collection<SBoolean> opinions3 = new ArrayList<>();
	    opinions3.add(new SBoolean(0.1,0.3,0.6,0.5));
	    opinions3.add(new SBoolean(0.4,0.2,0.4,0.5));
	    opinions3.add(new SBoolean(0.7,0.1,0.2,0.5));
	    
	    CCF = SBoolean.concensusAndCompromiseFusion(opinions3);
		System.out.println("C&C="+CCF+" p="+CCF.projection()+" w="+CCF.getRelativeWeight());
	    BCF = SBoolean.beliefConstraintFusion(opinions3);
		System.out.println("CBF="+BCF+" p="+BCF.projection()+" w="+BCF.getRelativeWeight());
		ACF = SBoolean.averageBeliefFusion(opinions3);
		System.out.println("Avg="+ACF+" p="+ACF.projection()+" w="+ACF.getRelativeWeight());
		aCCF = SBoolean.cumulativeBeliefFusion(opinions3);
		System.out.println("aCu="+aCCF+" p="+aCCF.projection()+" w="+aCCF.getRelativeWeight());
		eCCF = SBoolean.epistemicCumulativeBeliefFusion(opinions3);
		System.out.println("eCu="+eCCF+" p="+eCCF.projection()+" w="+eCCF.getRelativeWeight());
	    wcf = SBoolean.weightedBeliefFusion(opinions3);
		System.out.println("Wei="+wcf+" p="+wcf.projection()+" w="+wcf.getRelativeWeight());
		
		System.out.println("---");
		SBoolean uno = new SBoolean(0.9,0.1,0,0.5);
		SBoolean dos = new SBoolean(0.1,0.9,0,0.5);
		System.out.println(uno.degreeOfConflict(dos));
		System.out.println(uno.bcFusion(dos));
	
	}
	
	void testAverageFusion() {
		SBoolean uno,dos,tres,res,r1;
		Collection<SBoolean> opinions; 
		
		uno = new SBoolean(0.9,0.1,0,0.5);
		dos = new SBoolean(0.1,0.9,0,0.5);
		res = new SBoolean(0.5,0.5,0,0.5);
		assertEquals(res,uno.averageFusion(dos));
		opinions = new ArrayList<>();
	    opinions.add(uno);
	    opinions.add(dos);
		assertEquals(res,SBoolean.averageBeliefFusion(opinions));
		
		uno  = new SBoolean(0.1,0.3,0.6,0.5);
		dos  = new SBoolean(0.4,0.2,0.4,0.5);
		tres = new SBoolean(0.7,0.1,0.2,0.5);
		res  = new SBoolean(0.509,0.164,0.327,0.5);
		opinions = new ArrayList<>();
	    opinions.add(uno);
	    opinions.add(dos);
	    opinions.add(tres);
		assertEquals(res,(SBoolean.averageBeliefFusion(opinions)));

		res  = new SBoolean(0.629,0.182,0.189,0.5);
		assertEquals(res,(SBoolean.concensusAndCompromiseFusion(opinions)));

		res  = new SBoolean(0.738,0.184,0.078,0.5);
		assertEquals(res,(SBoolean.beliefConstraintFusion(opinions)));
		
		res  = new SBoolean(0.651,0.209,0.140,0.5);
		assertEquals(res,(SBoolean.cumulativeBeliefFusion(opinions)));
		
		res  = new SBoolean(0.442,0,0.558,0.5);
		assertEquals(res,(SBoolean.epistemicCumulativeBeliefFusion(opinions)));
		
		res  = new SBoolean(0.562,0.146,0.292,0.5);
		assertEquals(res,(SBoolean.weightedBeliefFusion(opinions)));
		
	
		uno = new SBoolean(0.33,0.33,0.34,0.5);
		dos = new SBoolean(0.33,0.33,0.34,0.5);
		res = new SBoolean(0.33,0.33,0.34,0.5);
		assertEquals(res, uno.averageFusion(dos));

		uno = new SBoolean(0.35,0.15,0.5,0.5);
		dos = new SBoolean(0.15,0.55,0.3,0.5);
		res = new SBoolean(0.23,0.4,0.37,0.5);
		assertEquals(res, uno.averageFusion(dos));

		uno = new SBoolean(0.9,0.1,0,0.5);
		dos = new SBoolean(0.1,0.9,0,0.5);
		res = new SBoolean(0.5,0.5,0,0.5);
		assertEquals(res, uno.averageFusion(dos));

		uno = new SBoolean(0.9,0.1,0,0.5);
		dos = new SBoolean(0.1,0.9,0,0.5);
		res = new SBoolean(0.5,0.5,0,0.5);
		assertEquals(res, uno.averageFusion(dos));
		
	}
}
public class SBooleanTest {
	
	public static void main(final String[] args) {

		Test t = new Test();
		// t.test1();
		// t.test2();
		t.testAverageFusion();

}
	

}
