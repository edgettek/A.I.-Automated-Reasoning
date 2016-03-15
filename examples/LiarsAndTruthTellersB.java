/**
 *
 *  Author: Nina Bose
 *
 * 	Purpose: Create knowledge base for Liars and Truth Tellers (Part B) Problem, helper methods to solve by model checking and resolution
 *
 * Assignment: CSC 242 Project 02
 *
 */

package examples;

import propositionalLogic.*;
import java.io.IOException;

public class LiarsAndTruthTellersB extends KB implements ExampleProblem {


  public LiarsAndTruthTellersB() {

    super();

    Symbol amy = intern("Amy");
    Symbol bob = intern("Bob");
    Symbol cal = intern("Cal");

    add(new Implication(amy, new Negation(cal)));
    add(new Implication(bob, new Conjunction(amy, cal)));
    add(new Implication(cal, bob));

  }

  public void solveByModelChecking() {

    System.out.println("Solving LiarsAndTruthTellers Part (b) (Model Checking)");

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

    System.out.println("Solving LiarsAndTruthTellers Part (b) (Resolution)");

    Sentence s = new Symbol("Amy");
    System.out.print("Amy is telling the truth: ");
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
		return "Liars and Truth Tellers (b)";
	}

}
