import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

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

		kb.add(new Negation(alpha)); // Add negation of alpha to Knowledge Base (Proof by Contradition)
		Set<Clause> clauses = CNFConverter.convert(kb); // Convert all clauses to CNF
		Set<Clause> newSet = new HashSet<>();

		Iterator<Clause> iterator1;
		Iterator<Clause> iterator2;

		Set<Clause> resolvents;
		//Overall while-loop
		while(true) {
			// For each set of pairs
			iterator1 = clauses.iterator();
			while(iterator1.hasNext()) {
				Clause clause_i = iterator1.next();
				iterator2 = clauses.iterator();
				while(iterator2.hasNext()) {
					Clause clause_j = iterator2.next();

					if(clause_i.equals(clause_j) == false) {
						resolvents = PLResolve(clause_i, clause_j);

						//If resolvents contains empty clause
						if(resolvents.contains(new Clause(new Symbol("")))) {
							return true;
						}

						newSet.addAll(resolvents);
					}	// End if
				} // End While-Loop 3
			} // End While-Loop 2

			if(clauses.containsAll(newSet)) {
				return false;
			}

			clauses.addAll(newSet);
		}
	}

	public static Set<Clause> PLResolve(Clause c, Clause d) {

			Iterator<Literal> c_iterator = c.iterator();
			Iterator<Literal> d_iterator = d.iterator();

			Set<Clause> resolvents = new HashSet<>();

			while(c_iterator.hasNext()) {
				Literal c_literal = c_iterator.next();
				while(d_iterator.hasNext()) {
					Literal d_literal = d_iterator.next();

					//Connecting clauses
					if(c_literal.getContent().equals(d_literal.getContent()) && c_literal.getPolarity() != d_literal.getPolarity()) {
						c.remove(c_literal);
						d.remove(d_literal);

						c.addAll(d);

						resolvents.add(c);
						return resolvents;
					}
				}
			}

			resolvents.add(c);
			resolvents.add(d);

			return resolvents;
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
