
import propositionalLogic.*;


public class HornClauses extends KB implements ExampleProblem{

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

	public void solveByModelChecking() {

		System.out.println("Solving Horn Clauses (Model Checking)");

		Sentence s = new Symbol("mythical");
		System.out.println("Can we prove that the unicorn is mythical?");
		System.out.println(Test.TTEntails(this, s));

		System.out.println("Can we prove that the unicorn is magical?");
		s = new Symbol("magical");
		System.out.println(Test.TTEntails(this, s));

		System.out.println("Can we prove that the unicorn is horned?");
		s = new Symbol("horned");
		System.out.println(Test.TTEntails(this, s));

		System.out.println("\n**********\n");

	}

	public void solveByResolution() {

				System.out.println("Solving Horn Clauses (Resolution)");

				Sentence s = new Symbol("mythical");
				System.out.println("Can we prove that the unicorn is mythical?");
				System.out.println(Test.PLResolution(this, s));

				System.out.println("Can we prove that the unicorn is magical?");
				s = new Symbol("magical");
				System.out.println(Test.PLResolution(this, s));

				System.out.println("Can we prove that the unicorn is horned?");
				s = new Symbol("horned");
				System.out.println(Test.PLResolution(this, s));

				System.out.println("\n**********\n");
		}

}
