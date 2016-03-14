package propositionalLogic;

import java.util.ArrayList;

public interface Sentence {
	
	/**
	 * Return true if this Sentence is satisfied by the given Model.
	 */
	public boolean isSatisfiedBy(ModelInterface model);

	public ArrayList<Symbol> getSymbols();


}
