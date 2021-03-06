/**
 * 
 * Author: George Ferguson
 * 
 * Assignment: CSC 242 Project 02
 * 
 */

package propositionalLogic;

public class Disjunction extends BinaryCompoundSentence {

	public Disjunction(Sentence lhs, Sentence rhs) {
		super(BinaryConnective.OR, lhs, rhs);
	}

	/**
	 * Return true if this Disjunction is satisfied by the given Model.
	 * That is, if either of its arguments are satisfied by the Model.
	 */
	public boolean isSatisfiedBy(ModelInterface model) {
		return lhs.isSatisfiedBy(model) || rhs.isSatisfiedBy(model);
	}

}
