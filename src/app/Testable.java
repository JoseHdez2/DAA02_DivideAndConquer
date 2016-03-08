package app;

import app.def.Problem;
import app.def.Solution;

public interface Testable {
    
    // Get number of comparisons made thus far.
    public int getComparisons();
    
    // Solve.
    public Solution resolve(Problem p);
    
    // Return name of this.
    public String getTestableName();
}
