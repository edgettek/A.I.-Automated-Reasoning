/**
 * 
 *  Author: Kyle Edgette
 * 
 * 	Purpose: Create knowledge base for Wumpus World Problem, helper methods to solve by model checking and resolution
 * 
 * Assignment: CSC 242 Project 02
 * 
 */

import java.io.IOException;

import propositionalLogic.*;



public class WumpusWorld extends KB{
	
	
	/**
	 * Constructor sets up Knowledge Base for Wumpus World Problem
	 * 
	 */
	public WumpusWorld() {
		
		super();
		
		Symbol P11 = intern("P1,1");
		Symbol B11 = intern("B1,1");
		Symbol P12 = intern("P1,2");
		Symbol P21 = intern("P2,1");
		Symbol P22 = intern("P2,2");
		Symbol B21 = intern("B2,1");
		Symbol P31 = intern("P3,1");
		
		add(new Negation(P11));
		
		Sentence s = new Disjunction(P12, P21);
		add(new Biconditional(B11, s));
		
		s = new Disjunction(P31, P22);
		
		Sentence q = new Disjunction(s, P11);
		
		add(new Biconditional(B21, q));
		
		add(new Negation(B11));
		
		add(B21);	
	}
	
	/**
	 * Solves Wumpus World Problem using Model Checking
	 * 
	 */
	public boolean solveWumpusWorldTT() {
		
		Sentence P12 = new Symbol("P1,2");
		
		return Test.TTEntails(this, P12);
	}
	
	/**
	 * Solves Wumpus World Problem using Model Checking
	 * @throws IOException 
	 * 
	 */
	public boolean solveWumpusWorldResolution() throws IOException {
		
		Sentence P12 = new Symbol("P1,2");
		
		return Test.PLResolution(this, P12);
	}


}
