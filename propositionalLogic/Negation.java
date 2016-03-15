/**
 * 
 * Author: George Ferguson
 * 
 * 
 * Assignment: CSC 242 Project 02
 * 
 */

package propositionalLogic;

public class Negation extends UnaryCompoundSentence {
	
	public Negation(Sentence argument) {
		super(UnaryConnective.NOT, argument);
	}

	/**
	 * Return true if this Negation is satisfied by the given Model.
	 * That is, if its argument is not satisfied by the Model.
	 */
	public boolean isSatisfiedBy(ModelInterface model) {
		return !argument.isSatisfiedBy(model);
	}

}
