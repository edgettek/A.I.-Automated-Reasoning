/**
 *
 *  Author: Nina Bose
 *
 * 	Purpose: Interface for all propositional logic problems
 *
 * Assignment: CSC 242 Project 02
 *
 */

package examples;

import java.io.IOException;


public interface ExampleProblem {

  public void solveByModelChecking();

  public void solveByResolution() throws IOException;

  public String getName();

}
