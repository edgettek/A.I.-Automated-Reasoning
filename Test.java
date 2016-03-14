import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import propositionalLogic.*;
import cnf.*;




public class Test {

	public static void main(String[] args) {
	
		
		System.out.println("Solving Modus Ponens (Model Checking)");
		
		ModusPonens mp = new ModusPonens();
		
		System.out.println(mp.solveModusPonensTT());
		
		System.out.println("\n**********\n");

		System.out.println("Solving Wumpus World (Model Checking)");
		
		WumpusWorld ww = new WumpusWorld();
		
		System.out.println(ww.solveWumpusWorldTT());
		
		System.out.println("\n**********\n");

		System.out.println("Solving Horn Clauses (Model Checking)");
		
		HornClauses hc = new HornClauses();
		
		hc.solveHornClauses();
		
		System.out.println("\n**********\n");
		
		System.out.println("Solving Modus Ponens (Resolution)");
		
		 mp = new ModusPonens();
		
		System.out.println(mp.solveModusPonensResolution());
		
		System.out.println("\n**********\n");
		
		System.out.println("Solving Wumpus World (Resolution)");
		
		 ww = new WumpusWorld();
		
		System.out.println(ww.solveWumpusWorldResolution());

	}
	
	public static boolean PLResolution(KB kb, Sentence alpha) {
		
		kb.add(new Negation(alpha));
		
		Set<Clause> clauses = CNFConverter.convert(kb);

		System.out.println("\n\n\n\n");
		
		Set<Clause> newSet = new HashSet<Clause>();
			
		Clause c, c2;
		
		Iterator<Clause> iterator2;
		
		while(true) {
			
			Iterator<Clause> iterator = clauses.iterator();
			
			while(iterator.hasNext()) {
				
				c = iterator.next();
				
				System.out.println("Clause Orig: " + clauses);
				
				//Set<Clause> clauses2 = new HashSet<Clause>(clauses);
				
				//System.out.println("Clause 2: " + clauses2);

				
				iterator2 = clauses.iterator();
				
				while(iterator2.hasNext()) {
					
					c2 = iterator2.next();
					
					if(c.equals(c2) == false) {

						System.out.println("Clause: "+ c + "\t" + c2);
						HashSet<Clause> resolvents = PLResolve(c, c2);
	
						System.out.println("Resolvents: "+resolvents);
						
						Iterator<Clause> itClause = resolvents.iterator();
						
						while(itClause.hasNext()) {
							System.out.println("\tInside Resolvents Loop");
							if(itClause.next().isEmpty()) {
								return true;
							}
							
						}
						newSet.addAll(resolvents);
						System.out.println("\tInside Loop 3");
					}
				}
				System.out.println("\tInside Loop 2");
							
			}
			System.out.println("\tInside Loop 1");
			if(clauses.containsAll(newSet)) {
				System.out.println("\tInside If Loop 1");
				return false;
			}
			
			clauses.addAll(newSet);
			System.out.println("\tBottom of Loop 1");
		}

		
	}
	
	public static HashSet<Clause> PLResolve(Clause c, Clause d) {
		
		Iterator<Literal> it = c.iterator();
		
		Iterator<Literal> it2 = d.iterator();
		
		Literal l1, l2;
		
		HashSet<Clause> set = new HashSet<Clause>();
		
		int counter = 0;
		
		while(it.hasNext()) {
			System.out.println("\t\tInside Loop 1 - Resolve " + counter);
			l1 = it.next();
			it2 = d.iterator();
			while(it2.hasNext()) {
				
				counter++;
				System.out.println("\t\tInside Loop 2 - Resolve");
				
				
				
				l2 = it2.next();
				
				if(l1.getContent().equals(l2.getContent()) && l1.getPolarity() != l2.getPolarity()) {
					System.out.println("\t\t\tInside Resolution Part - Resolve");
					c.remove(l1);
					d.remove(l2);
					
					c.addAll(d);

					set.add(c);
					
					return set;	
				}				
			}	
		}
		
		set.add(c);
		set.add(d);
		
		return set;
		
		
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
		
		//System.out.println(list);
		
		Model model = new Model();
		
		//model.dump();
		
		//System.out.println(list.size());
		
		return TTCheckAll(kb, alpha, list, model);
	}
	
	public static boolean TTCheckAll(KB kb, Sentence alpha, ArrayList<Symbol> symbols, Model model) {
		//System.out.println("*****");
		//model.dump();
		
		if(symbols.isEmpty() == true) {
			//System.out.println("SYMBOLS IS EMPTY");
			if(model.satisfies(kb) == true) {
				//System.out.println("KNOWLEDGE BASE SATISFIED");
				return model.satisfies(alpha);
			}
			else {
				return true;
			}
		}
		else {
			
			ArrayList<Symbol> symbols2 = new ArrayList<Symbol>(symbols);
			
			Symbol p = symbols.remove(0);
			//System.out.println(symbols.size());
			Model m = model.clone();
			
			m.set(p, true);
			
			Model m2 = model.clone();
			
			
			
			p = symbols2.remove(0);
			
			m2.set(p, false);
			
			return TTCheckAll(kb, alpha, symbols, m) && TTCheckAll(kb, alpha, symbols2, m2);

			
		}		
	}
	
	
	

}
