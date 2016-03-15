package examples;

import propositionalLogic.*;
import java.io.IOException;


public class MoreLiarsAndTruthTellers extends KB implements ExampleProblem {

  public MoreLiarsAndTruthTellers() {

    super();

    Symbol amy = intern("Amy");
    Symbol bob = intern("Bob");
    Symbol cal = intern("Cal");
    Symbol dee = intern("Dee");
    Symbol eli = intern("Eli");
    Symbol fay = intern("Fay");
    Symbol gil = intern("Gil");
    Symbol hal = intern("Hal");
    Symbol ida = intern("Ida");
    Symbol jay = intern("Jay");
    Symbol kay = intern("Kay");
    Symbol lee = intern("Lee");

    add(new Biconditional(amy, new Conjunction(hal, ida)));
    add(new Biconditional(bob, new Conjunction(amy, lee)));
    add(new Biconditional(cal, new Conjunction(bob, gil)));
    add(new Biconditional(dee, new Conjunction(eli, lee)));
    add(new Biconditional(eli, new Conjunction(cal, hal)));
    add(new Biconditional(fay, new Conjunction(dee, ida)));
    add(new Biconditional(gil, new Conjunction(new Negation(eli), new Negation(jay))));
    add(new Biconditional(hal, new Conjunction(new Negation(fay), new Negation(kay))));
    add(new Biconditional(ida, new Conjunction(new Negation(gil), new Negation(kay))));
    add(new Biconditional(jay, new Conjunction(new Negation(amy), new Negation(cal))));
    add(new Biconditional(kay, new Conjunction(new Negation(dee), new Negation(fay))));
    add(new Biconditional(lee, new Conjunction(new Negation(bob), new Negation(jay))));

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

    System.out.print("Dee is telling the truth: ");
    s = new Symbol("Dee");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Eli is telling the truth: ");
    s = new Symbol("Eli");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Fay is telling the truth: ");
    s = new Symbol("Fay");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Gil is telling the truth: ");
    s = new Symbol("Gil");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Hal is telling the truth: ");
    s = new Symbol("Hal");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Ida is telling the truth: ");
    s = new Symbol("Ida");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Jay is telling the truth: ");
    s = new Symbol("Jay");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Kay is telling the truth: ");
    s = new Symbol("Kay");
    System.out.println(Test.TTEntails(this, s));

    System.out.print("Lee is telling the truth: ");
    s = new Symbol("Lee");
    System.out.println(Test.TTEntails(this, s));

    System.out.println("\n**********\n");

  }

  public void solveByResolution() throws IOException {

    System.out.println("Solving MoreLiarsAndTruthTellers (Resolution)");

        Sentence s = new Symbol("Amy");
        System.out.print("Amy is telling the truth: ");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Bob is telling the truth: ");
        s = new Symbol("Bob");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Cal is telling the truth: ");
        s = new Symbol("Cal");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Dee is telling the truth: ");
        s = new Symbol("Dee");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Eli is telling the truth: ");
        s = new Symbol("Eli");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Fay is telling the truth: ");
        s = new Symbol("Fay");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Gil is telling the truth: ");
        s = new Symbol("Gil");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Hal is telling the truth: ");
        s = new Symbol("Hal");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Ida is telling the truth: ");
        s = new Symbol("Ida");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Jay is telling the truth: ");
        s = new Symbol("Jay");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Kay is telling the truth: ");
        s = new Symbol("Kay");
        System.out.println(Test.PLResolution(this, s));

        System.out.print("Lee is telling the truth: ");
        s = new Symbol("Lee");
        System.out.println(Test.PLResolution(this, s));

        System.out.println("\n**********\n");

    System.out.println("\n**********\n");

  }


  		public String getName() {
  			return "More Liars and Truth Tellers";
  		}
}
