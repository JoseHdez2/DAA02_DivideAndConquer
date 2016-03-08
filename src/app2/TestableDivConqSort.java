package app2;

public abstract class TestableDivConqSort extends DivConqTemplate implements TestableSolver {
    
    // Number of comparisons this object has made.
    int comparisons;
    
    public TestableDivConqSort() {
        comparisons = 0;
    }
    
    /*
    *   Overridden (TestableSort) methods.
    */
    
    // return true if ( a > b )
    public boolean greaterThan(int a, int b)
    { comparisons++; return a > b; }
    
    // return true if ( a >= b )
    public boolean greaterOrEqualThan(int a, int b)
    { comparisons++; return a >= b; }
    
    // return true if ( a == b )
    public boolean equalTo(int a, int b)
    { comparisons++; return a == b; }
    
    // return true if ( a <= b )
    public boolean smallerOrEqualThan(int a, int b)
    { comparisons++; return a <= b; }
    
    // return true if ( a < b )
    public boolean smallerThan(int a, int b)
    { comparisons++; return a < b; }
    
    // Return number of comparisons this object has made.
    public int getNumOfComparisons()
    { return comparisons; }
    
    // Solve problem and return solution. This is a solver, after all.
    public Solution resolve(Problem p)
    { return solve(p); }
}