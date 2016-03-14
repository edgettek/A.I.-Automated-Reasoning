import java.util.ArrayList;
import java.util.Collection;

import propositionalLogic.KB;
import propositionalLogic.Model;
import propositionalLogic.Sentence;
import propositionalLogic.Symbol;




public class Test {

	public static void main(String[] args) {
		
//		Model model = new Model();
//		
//		Symbol p = new Symbol("p");
//		Symbol q = new Symbol("q");
//		
//		model.set(p, false);
//		model.set(q, false);
//		
//		model.dump();
//		
//		UnaryCompoundSentence s2 = new UnaryCompoundSentence(propositionalLogic.UnaryConnective.NOT, p);
//		
//		BinaryCompoundSentence sentence = new BinaryCompoundSentence(propositionalLogic.BinaryConnective.IFF, s2, q);
//		
//		System.out.println(model.satisfies(sentence));
		
		System.out.println("Solving Modus Ponens");
		
		ModusPonens mp = new ModusPonens();
		
		System.out.println(mp.solveModusPonens());
		
		System.out.println("\n**********\n");

		System.out.println("Solving Wumpus World");
		
		WumpusWorld ww = new WumpusWorld();
		
		System.out.println(ww.solveWumpusWorld());

	}
	
	
	public static boolean TTEntails(KB kb, Sentence alpha) {
		
		Collection<Symbol> symbols = kb.symbols();
		
		ArrayList<Symbol> list = new ArrayList<Symbol>(symbols);
		
		ArrayList<Symbol> fromAlpha = alpha.getSymbols();
		
		for(Symbol s : fromAlpha) {
			if(list.contains(s) == false) {
				list.add(s);
			}
		}
		
		System.out.println(list);
		
		Model model = new Model();
		
		model.dump();
		
		System.out.println(list.size());
		
		return TTCheckAll(kb, alpha, list, model);
	}
	
	public static boolean TTCheckAll(KB kb, Sentence alpha, ArrayList<Symbol> symbols, Model model) {
		System.out.println("*****");
		model.dump();
		
		if(symbols.isEmpty() == true) {
			System.out.println("SYMBOLS IS EMPTY");
			if(model.satisfies(kb) == true) {
				System.out.println("KNOWLEDGE BASE SATISFIED");
				return model.satisfies(alpha);
			}
			else {
				return true;
			}
		}
		else {
			
			ArrayList<Symbol> symbols2 = new ArrayList<Symbol>(symbols);
			
			Symbol p = symbols.remove(0);
			System.out.println(symbols.size());
			Model m = model.clone();
			
			m.set(p, true);
			
			Model m2 = model.clone();
			
			
			
			p = symbols2.remove(0);
			
			m2.set(p, false);
			
			return TTCheckAll(kb, alpha, symbols, m) && TTCheckAll(kb, alpha, symbols2, m2);

			
		}
		
		
		
		
	}
	
	
	

}
