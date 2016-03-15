README

Contact Information:

Names: Kyle Edgette & Nina Bose
Course: CSC 242 SPRING 2016
Assignment: Project 02: Automated Reasoning

***** IMPORTANT NOTES FOR GRADER *****

1. The "proof" for problem solving by resolution is printed to a text file named resolution_proofs.txt.

2. Along with the required Modus Ponens and Wumpus World problems, our third problem is the Horn Clauses
	problem.
	
3. EXTRA CREDIT: We also solved the Liars and Truth Tellers and the More Liars and Truth Tellers problems for 
	extra credit, as described in the project assignment.
	
Description:

	A Java program that solves propositional logic problems by the model checking (model enumeration)
method and by resolution theorem proving. The problems solved include: Modus Ponens, Wumpus World (Simple), 
Horn Clauses, Liars and Truth Tellers, and More Liars and Truth Tellers.

Files Included:

	Files Created by Nina & Kyle:
	
		Test.java
		ModusPonens.java
		WumpusWorld.java
		HornClauses.java
		Model.java
		
	Files Created by George Ferguson:
	
		All Files in cnf package
		All Files in propositionalLogic package, with the exception of Model.java (see above)
		Note: 	That the file that is now named ModelInterface.java was originally called Model.java
				The name was changed to facilitate the Model.java class
				
How to Compile and Run:

1. Change directory to src in terminal.

2. Using the following commands to compile the necessary files.
	
		KEdgette1$ javac cnf/*.java
		KEdgette1$ javac propositionalLogic/*.java
		KEdgette1$ javac examples/*.java
	
3. Run the program using the command:

		KEdgette1$ java examples.Test
		

		