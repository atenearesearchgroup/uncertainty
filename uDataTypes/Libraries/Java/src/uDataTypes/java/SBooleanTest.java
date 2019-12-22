package uDataTypes.java;

public class SBooleanTest {
	
	public static void main(String[] args) {


	SBoolean t = new SBoolean();
	System.out.println("t="+t+" p="+t.projection()+" mu="+t.uncertaintyMaximized()+" uBoolean="+t.toUBoolean());
	SBoolean f = new SBoolean(new UBoolean(true,0));
	System.out.println("f="+f+" p="+f.projection()+" mu="+f.uncertaintyMaximized()+" uBoolean="+f.toUBoolean());
	SBoolean b1 = new SBoolean(new UBoolean(true,0.7));
	System.out.println("b1="+b1+" p="+b1.projection()+" mu="+b1.uncertaintyMaximized()+" uBoolean="+b1.toUBoolean());
	SBoolean b2 = new SBoolean(new UBoolean(false,0.7));
	System.out.println("b2="+b2+" p="+b2.projection()+" mu="+b2.uncertaintyMaximized()+" uBoolean="+b2.toUBoolean());
	SBoolean b3 = new SBoolean(0.2,0.6,0.2,0.5);
	System.out.println("b3="+b3+" p="+b3.projection()+" mu="+b3.uncertaintyMaximized()+" uBoolean="+b3.toUBoolean());
	SBoolean b4 = new SBoolean(0.6,0.2,0.2,0.5);
	System.out.println("b4="+b4+" p="+b4.projection()+" mu="+b4.uncertaintyMaximized()+" uBoolean="+b4.toUBoolean());

	SBoolean torf = t.or(f);
	System.out.println("torf="+torf+" p="+torf.projection()+" mu="+torf.uncertaintyMaximized()+" uBoolean="+torf.toUBoolean());
	SBoolean tandf = t.and(f);
	System.out.println("tandf="+tandf+" p="+tandf.projection()+" mu="+tandf.uncertaintyMaximized()+" uBoolean="+tandf.toUBoolean());

	SBoolean torf1 = b1.or(b2);
	System.out.println("torf1="+torf1+" p="+torf1.projection()+" mu="+torf1.uncertaintyMaximized()+" uBoolean="+torf1.toUBoolean());
	SBoolean tandf1 = b1.and(b2);
	System.out.println("tandf1="+tandf1+" p="+tandf1.projection()+" mu="+tandf1.uncertaintyMaximized()+" uBoolean="+tandf1.toUBoolean());

	SBoolean torf2 = b3.or(b4);
	System.out.println("torf2="+torf2+" p="+torf2.projection()+" mu="+torf2.uncertaintyMaximized()+" uBoolean="+torf2.toUBoolean());
	SBoolean tandf2 = b3.and(b4);
	System.out.println("tandf2="+tandf2+" p="+tandf2.projection()+" mu="+tandf2.uncertaintyMaximized()+" uBoolean="+tandf2.toUBoolean());
	
	SBoolean txorf = b1.xor(b2);
	System.out.println("txorf="+txorf+" p="+txorf.projection()+" mu="+txorf.uncertaintyMaximized()+" uBoolean="+txorf.toUBoolean());
	SBoolean tequif = b1.equivalent(b2);
	System.out.println("tequif="+tequif+" p="+tequif.projection()+" mu="+tequif.uncertaintyMaximized()+" uBoolean="+tequif.toUBoolean());
	System.out.println(b1.toUBoolean().xor(b2.toUBoolean()));
	System.out.println(b1.toUBoolean().equivalent(b2.toUBoolean()));

	
	SBoolean txorf2 = b3.xor(b4);
	System.out.println("txorf2="+txorf2+" p="+txorf2.projection()+" mu="+txorf2.uncertaintyMaximized()+" uBoolean="+txorf2.toUBoolean());
	SBoolean tequif2 = b3.equivalent(b4);
	System.out.println("tequif2="+tequif2+" p="+tequif2.projection()+" mu="+tequif2.uncertaintyMaximized()+" uBoolean="+tequif2.toUBoolean());
	System.out.println(b3.toUBoolean().xor(b4.toUBoolean()));
	System.out.println(b3.toUBoolean().equivalent(b4.toUBoolean()));
	
	SBoolean b3equivB4 = b3.implies(b4).and(b4.implies(b3));
	System.out.println("b3equivB4="+b3equivB4+" p="+b3equivB4.projection()+" mu="+b3equivB4.uncertaintyMaximized()+" uBoolean="+b3equivB4.toUBoolean());
	
	System.out.println(txorf.hashCode());
	System.out.println(tequif.hashCode());
	System.out.println(txorf2.hashCode());
	System.out.println(tequif2.hashCode());
	
	
	
}
	

}
