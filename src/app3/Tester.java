package app3;

import java.util.ArrayList;

import app3.def.Problem;

public abstract class Tester {
    
    ArrayList<Testable> testables;
    
    int defNumProb, defProbDiff;
    
    public Tester(){
        testables = new ArrayList<Testable>();
        defNumProb = 100;
        defProbDiff = 10;
    }
    
    abstract protected Problem randomProblem(int probDiff);
    
    /**
     * @param numProb Number of random test problems in a test.
     * @param probDiff Difficulty of each random test problem. Depends entirely on implementation.
     */
    public void conductTest(int numProb, int probDiff){
        
        System.out.println(String.format("%n%d problemas de dificultad %d:", numProb, probDiff));
        
        ArrayList<Problem> testProblems = new ArrayList<Problem>();
        
        // Generate problems
        for (int i = 0; i < numProb; i++)
            testProblems.add(randomProblem(probDiff));
        
        // Each problem is solved by each testable.
        for (int i = 0; i < numProb; i++){
            for (Testable t : testables){
                t.resolve(testProblems.get(i));
//                System.out.println(t.resolve(testProblems.get(i)));
            }
        }
           
        // Show comparisons.
        for (Testable t : testables)
            System.out.println(String.format("%s : %5d comparaciones (%3.1f de media)", t.getTestableName(), t.getComparisons(), (float)t.getComparisons() / (float)numProb));
    }
    
}