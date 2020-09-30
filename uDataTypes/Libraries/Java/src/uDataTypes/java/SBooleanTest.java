package uDataTypes.java;

import java.util.ArrayList;
import java.util.Collection;

public class SBooleanTest {
	
	public static void main(final String[] args) {

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
	
    SBoolean wcf, majF, minF, CCF, eCCF, ACF;
    Collection<SBoolean> opinions = new ArrayList<>();
    opinions.add(b1);
    opinions.add(b2);
    opinions.add(b3);
    opinions.add(b4);
    opinions.add(b5);
    wcf = SBoolean.weightedBeliefFusion(opinions);
	System.out.println("WCF="+wcf+" p="+wcf.projection()+" w="+wcf.getRelativeWeight());
    majF = SBoolean.majorityBeliefFusion(opinions);
	System.out.println("MaF="+majF+" p="+majF.projection()+" w="+majF.getRelativeWeight());
    minF = SBoolean.minimumBeliefFusion(opinions);
	System.out.println("MiF="+minF+" p="+minF.projection()+" w="+minF.getRelativeWeight());
    ACF = SBoolean.averageBeliefFusion(opinions);
	System.out.println("ACF="+ACF+" p="+ACF.projection()+" w="+ACF.getRelativeWeight());
    CCF = SBoolean.cumulativeBeliefFusion(opinions);
	System.out.println("CCF="+CCF+" p="+CCF.projection()+" w="+CCF.getRelativeWeight());
    eCCF = SBoolean.epistemicCumulativeBeliefFusion(opinions);
	System.out.println("eCCF="+eCCF+" p="+eCCF.projection()+" w="+eCCF.getRelativeWeight());
    


}
	

}
