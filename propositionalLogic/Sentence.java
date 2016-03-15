/**
 * 
 * Author: George Ferguson
 * 
 * Modified by: Kyle Edgette
 * 
 * Modification: Added the getSymbols() method to facilitate adding the symbols from the sentence we want to prove into list of
 * 				 symbols for model checking
 * 
 * 
 * Assignment: CSC 242 Project 02
 * 
 */

package propositionalLogic;

import java.util.ArrayList;

public interface Sentence {
	
	/**
	 * Return true if this Sentence is satisfied by the given Model.
	 */
	public boolean isSatisfiedBy(ModelInterface model);

	public ArrayList<Symbol> getSymbols();


}
