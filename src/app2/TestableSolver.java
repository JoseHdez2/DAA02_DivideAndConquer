package app2;

public interface TestableSolver {
    
    // return true if ( a > b )
    public boolean greaterThan(int a, int b);
    
    // return true if ( a >= b )
    public boolean greaterOrEqualThan(int a, int b);
    
    // return true if ( a == b )
    public boolean equalTo(int a, int b);
    
    // return true if ( a <= b )
    public boolean smallerOrEqualThan(int a, int b);
    
    // return true if ( a < b )
    public boolean smallerThan(int a, int b);
    
    // Return number of comparisons this object has made.
    public int getNumOfComparisons();
    
    // Solve problem and return solution. This is a solver, after all.
    public Solution solve(Problem p);
}