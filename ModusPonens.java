import propositionalLogic.Implication;
import propositionalLogic.KB;
import propositionalLogic.Sentence;
import propositionalLogic.Symbol;


public class ModusPonens extends KB{
	
	
	public ModusPonens() {
		
		
		Symbol p = intern("P");
		Symbol q = intern("Q");
		add(p);
		add(new Implication(p, q));
			
	}
	
	public boolean solveModusPonensTT() {
		
		Sentence q = new Symbol("Q");
		
		return Test.TTEntails(this, q);
	}
	
	public boolean solveModusPonensResolution() {
		Sentence q = new Symbol("Q");
		
		return Test.PLResolution(this, q);
	}

}
