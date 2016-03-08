package app2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Tester {
    
    HashMap<String, TestableSolver> solvers;
    
    // Difficulty of each random test problem. Depends entirely on implementation.
    int probDiff;
    // Number of random test problems in a test.
    int numTest;
    
    public Tester(){
        probDiff = 10;
        numTest = 100;
    }
    
    abstract protected Problem randomProblem();
    
    public void conductTest(){
        
        ArrayList<Problem> testProblems = new ArrayList<Problem>();
        
        // 
        for (int i = 0; i < numTest; i++)
            testProblems.add(randomProblem());
        
        //
        for (TestableSolver ts : solvers.values())
            for (int i = 0; i < numTest; i++)
                ts.solve(testProblems.get(i));
            
        for (Map.Entry<String, TestableSolver> entry : solvers.entrySet()) {
            String key = entry.getKey();
            TestableSolver value = entry.getValue();
            
            System.out.println(String.format("%s : %5d comparaciones", key, value));
        }
    }
    
}