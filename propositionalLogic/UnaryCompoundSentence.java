/**
 *
 * Author: George Ferguson
 *
 * Modified by: Kyle Edgette
 *
 * Modification: Implemented the isSatisfiedBy(Model model), therefore the class is no longer abstract
 *
 * Assignment: CSC 242 Project 02
 *
 */

package propositionalLogic;

import java.util.ArrayList;

public class UnaryCompoundSentence extends CompoundSentence {

	protected UnaryConnective connective;
	protected Sentence argument;

	public UnaryCompoundSentence(UnaryConnective connective, Sentence argument) {
		super();
		this.connective = connective;
		this.argument = argument;
	}

	public UnaryConnective getConnective() {
		return connective;
	}



	@Override
	public boolean isSatisfiedBy(ModelInterface model) {
		switch (getConnective()) {
		case NOT:
			return !(getArgument().isSatisfiedBy(model));
		default:
			throw new IllegalArgumentException();
		}
	}

	public Sentence getArgument() {
		return argument;
	}

	public String toString() {
		return "(" + connective.toString() + " " + argument.toString() + ")";
	}

	/**
	 * If the given connective and argument are equal to the
	 * corresponding components of this UnaryCompoundSentence, then
	 * simply return it, otherwise return a new UnaryCompoundSentence
	 * with those components.  That is, reuse this object if possible,
	 * otherwise return a new one.
	 * This was code was more elegant before I had subclasses of
	 * UnaryCompoundSentence...
	 */
	public UnaryCompoundSentence rebuild(UnaryConnective connective, Sentence argument) {
		if (getConnective().equals(connective) &&
				getArgument().equals(argument)) {
			return this;
		} else {
			switch (getConnective()) {
			case NOT:
				return new Negation(argument);
			default:
				throw new IllegalArgumentException();
			}
		}
	}

	@Override
	public ArrayList<Symbol> getSymbols() {
		return getArgument().getSymbols();
	}

	public Sentence copySentence() {
		return new UnaryCompoundSentence(connective, argument);
	}
}
