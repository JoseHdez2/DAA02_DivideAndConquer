package app3;

import java.util.ArrayList;

import app3.def.Problem;

public abstract class Tester {
    
    ArrayList<Testable> testables;
    
    // Difficulty of each random test problem. Depends entirely on implementation.
    int probDiff;
    // Number of random test problems in a test.
    int numTest;
    
    public Tester(){
        probDiff = 10;
        numTest = 100;
        testables = new ArrayList<Testable>();
    }
    
    abstract protected Problem randomProblem();
    
    public void conductTest(){
        
        ArrayList<Problem> testProblems = new ArrayList<Problem>();
        
        // Generate problems
        for (int i = 0; i < numTest; i++)
            testProblems.add(randomProblem());
        
        // Each testable solves all generated problems.
        for (Testable t : testables)
            for (int i = 0; i < numTest; i++)
                t.resolve(testProblems.get(i));
           
        // Show comparisons.
        for (Testable t : testables)
            System.out.println(String.format("%s : %5d comparaciones", t.getTestableName(), t.getComparisons()));
    }
    
}