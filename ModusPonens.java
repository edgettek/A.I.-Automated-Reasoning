/**
 * 
 *  Author: Kyle Edgette
 * 
 * 	Purpose: Create knowledge base for Modus Ponens Problem, helper methods to sovle by model checking and resolution
 * 
 * Assignment: CSC 242 Project 02
 * 
 */

import java.io.IOException;

import propositionalLogic.Implication;
import propositionalLogic.KB;
import propositionalLogic.Sentence;
import propositionalLogic.Symbol;


public class ModusPonens extends KB{
	
	/**
	 * Constructor sets up Knowledge Base for Modus Ponens
	 * 
	 */
	public ModusPonens() {
		
		super();
		Symbol p = intern("P");
		Symbol q = intern("Q");
		add(p);
		add(new Implication(p, q));
			
	}
	
	
	/**
	 * Solves Modus Ponens Problem using Model Checking
	 * 
	 */
	public boolean solveModusPonensTT() {
		
		Sentence q = new Symbol("Q");
		
		return Test.TTEntails(this, q);
	}
	
	 
	/**
	 * Solves Modus Ponens Problem using Resolution
	 * @throws IOException 
	 * 
	 */
	public boolean solveModusPonensResolution() throws IOException {
		Sentence q = new Symbol("Q");
		
		return Test.PLResolution(this, q);
	}

}
