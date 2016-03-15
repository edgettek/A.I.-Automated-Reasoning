

import propositionalLogic.Implication;
import propositionalLogic.KB;
import propositionalLogic.Sentence;
import propositionalLogic.Symbol;
import java.io.IOException;


public class ModusPonens extends KB implements ExampleProblem {


	public ModusPonens() {


		Symbol p = intern("P");
		Symbol q = intern("Q");
		add(p);
		add(new Implication(p, q));

	}

	public void solveByModelChecking() {
		System.out.println("Solving Modus Ponens (Model Checking)");

		Sentence q = new Symbol("Q");
		System.out.println(Test.TTEntails(this, q));

		System.out.println("\n**********\n");
	}

	public void solveByResolution() throws IOException {

		System.out.println("Solving Modus Ponens (Resolution)");

		Sentence q = new Symbol("Q");
		System.out.println(Test.PLResolution(this, q));

		System.out.println("\n**********\n");

	}


			public String getName() {
				return "Modus Ponens";
			}
}
