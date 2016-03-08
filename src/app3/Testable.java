package app3;

import app3.def.Problem;
import app3.def.Solution;

public interface Testable {
    
    // Get number of comparisons made thus far.
    public int getComparisons();
    
    // Solve.
    public Solution resolve(Problem p);
    
    // Return name of this.
    public String getTestableName();
}
