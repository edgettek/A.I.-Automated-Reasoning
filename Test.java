/**
 *
 * Author: Kyle Edgette & Nina Bose
 *
 * Purpose: main() and propositional logic problem solving methods for model checking and resolution
 *
 * Assignment: CSC 242 Project 02
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import propositionalLogic.*;
import cnf.*;

public class Test {

	public static BufferedWriter bw;

	public static void main(String[] args) throws IOException {

		// Setting up File to print resolution proofs to

		File file = new File("resolution_proofs.txt");

		// If the file doesn't exist then create it
		if (!file.exists()) {
			file.createNewFile();
		}


		List<ExampleProblem> exampleProblems = new ArrayList<>();
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);

		exampleProblems.add(new ModusPonens());
		exampleProblems.add(new WumpusWorld());
		exampleProblems.add(new HornClauses());
		exampleProblems.add(new LiarsAndTruthTellersA());
		exampleProblems.add(new LiarsAndTruthTellersB());


		// Model Checking
		for( ExampleProblem e : exampleProblems ) {
			e.solveByModelChecking();
		}

		// Resolution
		for( ExampleProblem e : exampleProblems ) {
			bw.write("Solving" + e.getName() + " (Resolution)");
			e.solveByResolution();
			bw.write("\n**********\n");
		}

		// System.out.println("Solving Modus Ponens (Model Checking)");
		//
		// ModusPonens mp = new ModusPonens();
		//
		// System.out.println(mp.solveModusPonensTT());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Wumpus World (Model Checking)");
		//
		// WumpusWorld ww = new WumpusWorld();
		//
		// System.out.println(ww.solveWumpusWorldTT());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Horn Clauses (Model Checking)");
		//
		// HornClauses hc = new HornClauses();
		//
		// hc.solveHornClauses();
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Liars and Truth Tellers (Model Checking)");
		//
		// LiarsAndTruthTellersA ltt = new LiarsAndTruthTellersA();
		//
		// ltt.solveLiarsAndTruthTellers();
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Modus Ponens (Resolution)");
		//
		//  mp = new ModusPonens();
		//
		// System.out.println(mp.solveModusPonensResolution());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Wumpus World (Resolution)");
		//
		//  ww = new WumpusWorld();
		//
		// System.out.println(ww.solveWumpusWorldResolution());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Horn Clauses (Resolution)");
		//
		//  hc = new HornClauses();
		//
		// hc.solveHornClausesResolution();
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Liars and Truth Tellers (Resolution)");
		//
    // ltt = new LiarsAndTruthTellersA();
		//
		// ltt.solveLiarsAndTruthTellersResolution();
		//
		// System.out.println(mp.solveModusPonensTT());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Wumpus World (Model Checking)");
		//
		// WumpusWorld ww = new WumpusWorld();
		//
		// System.out.println(ww.solveWumpusWorldTT());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Horn Clauses (Model Checking)");
		//
		// HornClauses hc = new HornClauses();
		//
		// hc.solveHornClausesTT();
		//
		// System.out.println("\n**********\n");
		//
		// bw.write("Solving Modus Ponens (Resolution)");
		//
		// System.out.println("Solving Modus Ponens (Resolution)");
		//
		// mp = new ModusPonens();
		//
		// System.out.println(mp.solveModusPonensResolution());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Wumpus World (Resolution)");
		//
		// bw.write("\n\n******\n\nSolving Wumpus World (Resolution)");
		//
		// ww = new WumpusWorld();
		//
		// System.out.println(ww.solveWumpusWorldResolution());
		//
		// System.out.println("\n**********\n");
		//
		// System.out.println("Solving Horn Clauses (Resolution)");
		//
		// bw.write("\n\n******\n\nSolving Horn Clauses (Resolution)");
		//
		// hc = new HornClauses();
		//
		// hc.solveHornClausesResolution();

		bw.close();

	}


	/**
	 * Solves Propositional Logic Problem by converting Knowledge Base to CNF and then using proves the
	 * problem using resolution
	 *
	 * From AIMA Figure 7.12
	 * @throws IOException
	 *
	 */
	public static boolean PLResolution(KB kb, Sentence alpha) throws IOException {

		kb.add(new Negation(alpha)); // Add negation of alpha to Knowledge Base (Proof by Contradition)
		Set<Clause> clauses = CNFConverter.convert(kb); // Convert all clauses to CNF
		Set<Clause> newSet = new HashSet<>();

		// Used to iterate through clauses
		Iterator<Clause> iterator1;
		Iterator<Clause> iterator2;

		// Used to hold the resulting clauses from resolving two clauses
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

					// If the two clauses are different then resolve them
					if(clause_i.equals(clause_j) == false) {

						// Get the set of clauses from resolving the two clauses
						resolvents = PLResolve(clause_i, clause_j);

						// Iterate over the resolvents
						Iterator<Clause> iterator_resolvents = resolvents.iterator();

						while(iterator_resolvents.hasNext()) {

							Clause currentClause = iterator_resolvents.next();

							// If the resolvents contains the empty clause then return true
							if(currentClause.isEmpty()) {
								return true;
							}
						}

						newSet.addAll(resolvents);

					}	// End if
				} // End While-Loop 3
			} // End While-Loop 2

			// If clauses contains all of the clauses in newSet return false
			if(clauses.containsAll(newSet)) {
				return false;
			}

			// Add newSet to clauses
			clauses.addAll(newSet);
		}
	}

	/**
	 * Resolves two propositional clauses
	 *
	 * Returns the set of possible clauses from resolving the two clauses
	 * @throws IOException
	 *
	 */
	public static Set<Clause> PLResolve(Clause c_original, Clause d_original) throws IOException {

			// Must copy the clauses to prevent pointer errors
			Clause c = c_original.copyClause();
			Clause d = d_original.copyClause();

			// Iterate over the literals in the clauses
			Iterator<Literal> c_iterator = c.iterator();
			Iterator<Literal> d_iterator = d.iterator();

			Set<Clause> resolvents = new HashSet<>();

			while(c_iterator.hasNext()) {

				Literal c_literal = c_iterator.next();

				while(d_iterator.hasNext()) {

					Literal d_literal = d_iterator.next();

					// If the two literals are the same symbol but different polarities (i.e. one is negated and the other isn't)
					// then remove the literals and combing the remaining literals from the two clauses into one new clause
					if(c_literal.getContent().equals(d_literal.getContent()) && c_literal.getPolarity() != d_literal.getPolarity()) {

						bw.write("\nClauses: " + c + "\t" + d);

						// Remove the literals
						c.remove(c_literal);
						d.remove(d_literal);

						c.addAll(d);

						// Add resulting clause to the set
						resolvents.add(c);

						bw.write("\nResolvents: " + resolvents + "\n");

						return resolvents;
					}
				}
			}

			// If the clauses cannot be resolved (i.e. they don't have a matching literal of oppositie polarity)
			// then return the two clauses
			resolvents.add(c);
			resolvents.add(d);

			return resolvents;
	}

	/**
	 * Prepares for model checking algorithm
	 *
	 */
	public static boolean TTEntails(KB kb, Sentence alpha) {

		// Get list of symbols from knowledge base
		Collection<Symbol> symbols = kb.symbols();

		ArrayList<Symbol> list = new ArrayList<Symbol>(symbols);

		// Get list of symbols from sentence that needs to be proven
		ArrayList<Symbol> fromAlpha = alpha.getSymbols();

		// If there is a new symbol from alpha not in the KB symbol list, then add it
		for(Symbol s : fromAlpha) {
			if(list.contains(s) == false) {
				list.add(s);
			}
		}

		Model model = new Model();

		return TTCheckAll(kb, alpha, list, model);
	}


	/**
	 * Recursively enumerates possible Models
	 *
	 * From AIMA Figure 7.10
	 *
	 */
	public static boolean TTCheckAll(KB kb, Sentence alpha, ArrayList<Symbol> symbols, Model model) {

		// If the list of symbols is empty
		if(symbols.isEmpty() == true) {

			// If the Model satisfies the Knowledge Base
			// (i.e. every sentence in the KB is true given the values from the Model)
			// then see if alpha is true given the values from the Model
			if(model.satisfies(kb) == true) {
				return model.satisfies(alpha);
			}
			else {
				return true;
			}
		}
		else {

			// Create duplicate list of symbols to prevent issues with pointers in recursive call
			ArrayList<Symbol> symbols2 = new ArrayList<Symbol>(symbols);

			// Remove the symbol from the list
			Symbol p = symbols.remove(0);

			// Clone Model to prevent issues with pointers
			Model m = model.clone();

			// Set the removed symbol to true in one Model
			m.set(p, true);

			Model m2 = model.clone();

			p = symbols2.remove(0);

			// Set the removed symbol to false in the other Model
			m2.set(p, false);

			// Recursive call with the new Models
			return TTCheckAll(kb, alpha, symbols, m) && TTCheckAll(kb, alpha, symbols2, m2);

		}
	}

}
