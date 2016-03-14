import propositionalLogic.*;



public class WumpusWorld extends KB{
	
	public WumpusWorld() {
		
		super();
		
		Symbol P11 = intern("P1,1");
		Symbol B11 = intern("B1,1");
		Symbol P12 = intern("P1,2");
		Symbol P21 = intern("P2,1");
		Symbol P22 = intern("P2,2");
		Symbol B21 = intern("B2,1");
		Symbol P31 = intern("P3,1");
		
		add(new Negation(P11));
		
		Sentence s = new Disjunction(P12, P21);
		add(new Biconditional(B11, s));
		
		s = new Disjunction(P31, P22);
		
		Sentence q = new Disjunction(s, P11);
		
		add(new Biconditional(B21, q));
		
		add(new Negation(B11));
		
		add(B21);
		
		
		
//		super();
//		Symbol p11 = intern("P1,1");
//		Symbol p12 = intern("P1,2");
//		Symbol p21 = intern("P2,1");
//		Symbol p22 = intern("P2,2");
//		Symbol p31 = intern("P3,1");
//		Symbol b11 = intern("B1,1");
//		Symbol b21 = intern("B2,1");
//
//		add(new Negation(p11));
//		add(new Biconditional(b11, new Disjunction(p12, p21)));
//		add(new Biconditional(b21, new Disjunction(p12, new Disjunction(p22, p31))));
//		add(new Negation(b11));
//		add(b21);
	
	}
	
	public boolean solveWumpusWorld() {
		
		Sentence P12 = new Symbol("P1,2");
		
		return Test.TTEntails(this, P12);
	}

}
