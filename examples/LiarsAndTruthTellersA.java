/**
 *
 *  Author: Nina Bose
 *
 * 	Purpose: Create knowledge base for Liars and Truth Tellers (Part A) Problem, helper methods to solve by model checking and resolution
 *
 * Assignment: CSC 242 Project 02
 *
 */

package examples;

import propositionalLogic.*;
import java.io.IOException;

public class LiarsAndTruthTellersA extends KB implements ExampleProblem {


  public LiarsAndTruthTellersA() {

    super();

    Symbol amy = intern("Amy");
    Symbol bob = intern("Bob");
    Symbol cal = intern("Cal");

    add(new Implication(amy, new Conjunction(amy, cal)));
    add(new Implication(bob, new Negation(cal)));
    add(new Implication(cal, new Disjunction(bob, new Negation(amy) )));

  }

  public void solveByModelChecking() {

    System.out.println("Solving LiarsAndTruthTellers Part (a) (Model Checking)");

    Sentence s = new Symbol("Amy");
    System.out.print("Amy is telling the truth: ");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Bob is telling the truth: ");
    s = new Symbol("Bob");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Cal is telling the truth: ");
    s = new Symbol("Cal");
    System.out.println(Test.TTEntails(this, s));

    System.out.println("\n**********\n");

  }

  public void solveByResolution() throws IOException {

    System.out.println("Solving LiarsAndTruthTellers Part (a) (Model Checking)");

    Sentence s = new Symbol("Amy");
    System.out.print("\nAmy is telling the truth: ");
    System.out.println(Test.PLResolution(this, s));

    System.out.print("Bob is telling the truth: ");
    s = new Symbol("Bob");
    System.out.println(Test.PLResolution(this, s));

    System.out.print("Cal is telling the truth: ");
    s = new Symbol("Cal");
    System.out.println(Test.PLResolution(this, s));

    System.out.println("\n**********\n");

  }


	public String getName() {
		return "Liars and Truth Tellers (a)";
	}

}
