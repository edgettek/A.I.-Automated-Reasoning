package examples;
/**
 *
 *  Author: Kyle Edgette and Nina Bose
 *
 * 	Purpose: Create knowledge base for Horn Clause Problem, helper methods to sovle by model checking and resolution
 *
 * Assignment: CSC 242 Project 02
 *
 */


import java.io.IOException;

import propositionalLogic.*;


public class HornClauses extends KB implements ExampleProblem{

	/**
	 * Constructor sets up Knowledge Base for Horn Clause Problem
	 *
	 */
	public HornClauses() {

		super();

		Symbol myth = intern("mythical");
		Symbol immortal = intern("immortal");
		Symbol mammal = intern("mammal");
		Symbol horned = intern("horned");
		Symbol magical = intern("magical");

		add(new Implication(myth, immortal));

		add(new Implication(new Negation(myth), new Conjunction(new Negation(immortal), mammal)));

		add(new Implication(new Disjunction(immortal, mammal), horned));

		add(new Implication(horned, magical));

	}

	/**
 	* Solves Horn Clause Problem using Model Checking
 	*
 	*/
	public void solveByModelChecking() {

		System.out.println("Solving Horn Clauses (Model Checking)");

		Sentence s = new Symbol("mythical");
		System.out.println("Can we prove that the unicorn is mythical?");
		System.out.println(Test.TTEntails(this, s));

		System.out.println();

		System.out.println("Can we prove that the unicorn is magical?");
		s = new Symbol("magical");
		System.out.println(Test.TTEntails(this, s));

		System.out.println();

		System.out.println("Can we prove that the unicorn is horned?");
		s = new Symbol("horned");
		System.out.println(Test.TTEntails(this, s));

		System.out.println("\n**********\n");

	}

	/**
	 * Solves Horn Clause Problem using Resolution
	 * @throws IOException
	 *
	 */
	public void solveByResolution()  throws IOException {

				System.out.println("Solving Horn Clauses (Resolution)");

				Sentence s = new Symbol("mythical");
				System.out.println("Can we prove that the unicorn is mythical?");
				System.out.println(Test.PLResolution(this, s));

				System.out.println();

				System.out.println("Can we prove that the unicorn is magical?");
				s = new Symbol("magical");
				System.out.println(Test.PLResolution(this, s));

				System.out.println();

				System.out.println("Can we prove that the unicorn is horned?");
				s = new Symbol("horned");
				System.out.println(Test.PLResolution(this, s));

				System.out.println("\n**********\n");
		}

		public String getName() {
			return "Horn Clause";
		}

}
