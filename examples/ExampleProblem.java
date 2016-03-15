package examples;

import java.io.IOException;


public interface ExampleProblem {

  public void solveByModelChecking();

  public void solveByResolution() throws IOException;

  public String getName();

}
