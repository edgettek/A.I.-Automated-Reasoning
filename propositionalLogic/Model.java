/**
 * 
 * Author: Kyle Edgette
 * 
 * Purpose: Model class implements ModelInterface. Model is a HashMap of Propositional Logic Symbols to truth values
 * 
 * Assignment: CSC 242 Project 02
 * 
 */

package propositionalLogic;

import java.util.HashMap;
import java.util.Set;

public class Model implements ModelInterface{
	
	protected HashMap<Symbol, Boolean> assignments;
	
	

	public Model() {
		assignments = new HashMap<Symbol, Boolean>();
	}

	@Override
	public void set(Symbol sym, boolean value) {
		if(assignments.containsKey(sym)) {
			assignments.remove(sym);
			assignments.put(sym, value);
		}
		else {
			assignments.put(sym, value);
		}
		
	}
	
	public Model clone() {
		
		Model m = new Model();
		
		HashMap<Symbol, Boolean> map = new HashMap<Symbol, Boolean>();
		
		for(Symbol sym : this.getAssignments().keySet()) {
			map.put(sym, this.getAssignments().get(sym));
		}
		
		m.setAssignments(map);
		
		return m;
		
	}

	@Override
	public boolean get(Symbol sym) {
		
		if(assignments.containsKey(sym)) {
			return assignments.get(sym);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean satisfies(KB kb) {
		boolean check = true;
		
		for(Sentence sentence : kb.sentences()) {
			check = check && sentence.isSatisfiedBy(this);
		}
		
		return check;
	}

	@Override
	public boolean satisfies(Sentence sentence) {
		
		return sentence.isSatisfiedBy(this);	
		
	}

	@Override
	public void dump() {
		Set<Symbol> set = assignments.keySet();
		
		for(Symbol symbol: set) {
			System.out.println(symbol + ": " + assignments.get(symbol));
		}
		
	}
	
	public HashMap<Symbol, Boolean> getAssignments() {
		return assignments;
	}

	public void setAssignments(HashMap<Symbol, Boolean> assignments) {
		this.assignments = assignments;
	}

}
