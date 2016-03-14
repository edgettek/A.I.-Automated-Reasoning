package propositionalLogic;

import java.util.ArrayList;

public class BinaryCompoundSentence extends CompoundSentence {

	protected BinaryConnective connective;
	protected Sentence lhs;
	protected Sentence rhs;

	public BinaryCompoundSentence(BinaryConnective connective, Sentence lhs, Sentence rhs) {
		super();
		this.connective = connective;
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public BinaryConnective getConnective() {
		return connective;
	}

	public Sentence getLhs() {
		return lhs;
	}

	public Sentence getRhs() {
		return rhs;
	}

	public String toString() {
		return "(" + connective.toString() + " " + lhs.toString() + " " + rhs.toString() + ")"; 
	}
	
	/**
	 * If the given connective, lhs, and rhs are equal to the
	 * corresponding components of this BinaryCompoundSentence, then
	 * simply return it, otherwise return a new BinaryCompoundSentence
	 * with those components.  That is, reuse this object if possible,
	 * otherwise return a new object.
	 * This was code was more elegant before I had subclasses of
	 * UnaryCompoundSentence...
	 */
	public BinaryCompoundSentence rebuild(BinaryConnective connective, Sentence lhs, Sentence rhs) {
		if (getConnective().equals(connective) &&
				getLhs().equals(lhs) &&
				getRhs().equals(rhs)) {
			return this;
		} else {
			switch (getConnective()) {
			case AND:
				return new Conjunction(lhs, rhs);
			case OR:
				return new Disjunction(lhs, rhs);
			case IMPLIES:
				return new Implication(lhs, rhs);
			case IFF:
				return new Biconditional(lhs, rhs);
			default:
				throw new IllegalArgumentException();
			}
		}
	}
	
	@Override
	public boolean isSatisfiedBy(ModelInterface model) {
		
		switch (getConnective()) {
		case AND:
			return getLhs().isSatisfiedBy(model) && getRhs().isSatisfiedBy(model);
		case OR:
			return getLhs().isSatisfiedBy(model) || getRhs().isSatisfiedBy(model);
		case IMPLIES:
			if(getLhs().isSatisfiedBy(model) == true && getRhs().isSatisfiedBy(model) == false) {
				return false;
			}
			else {
				return true;
			}
		case IFF:
			if(getLhs().isSatisfiedBy(model) == getRhs().isSatisfiedBy(model)) {
				return true;
			}
			else {
				return false;
			}
		default:
			throw new IllegalArgumentException();
		}
		
		
	}

	@Override
	public ArrayList<Symbol> getSymbols() {
		ArrayList<Symbol> list = getLhs().getSymbols();
		
		ArrayList<Symbol> list2 = getRhs().getSymbols();
		
		list.addAll(list2);
		
		return list;
	}


}
