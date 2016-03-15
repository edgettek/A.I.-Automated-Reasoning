/**
 * 
 * Author: George Ferguson
 * 
 * Assignment: CSC 242 Project 02
 * 
 */

package propositionalLogic;

public class Conjunction extends BinaryCompoundSentence {

	public Conjunction(Sentence lhs, Sentence rhs) {
		super(BinaryConnective.AND, lhs, rhs);
	}

	/**
	 * Return true if this Conjunction is satisfied by the given Model.
	 * That is, if both its arguments are satisfied by the Model.
	 */
	public boolean isSatisfiedBy(ModelInterface model) {
		return lhs.isSatisfiedBy(model) && rhs.isSatisfiedBy(model);
	}

}
