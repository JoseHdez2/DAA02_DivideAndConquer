package app3;

import java.util.ArrayList;
import java.util.Random;

import app3.def.Problem;

public class SortTester extends Tester{

//    Integer min = Integer.MIN_VALUE;
//    Integer max = Integer.MAX_VALUE;
    Integer min = 0;
    Integer max = 100;
    
    Random rand;
    
    SortTester(){
        super();
        rand = new Random();
        
        testables.add(new MergeSort());
        testables.add(new BubbleSort());
        testables.add(new MaxValue());
        
//        conductTest(100, 10);
        batchTests(10, 100, 5);
//        batchTests(10, 10, 1);
    }
    
    private Integer randNum() {
        return rand.nextInt(max) + min;
    }
    
    @Override
    protected Problem randomProblem(int probDiff) {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for (int i = 0; i < probDiff; i++)
            arr.add(randNum());
            
        return new SortDesc(arr);
    }
    
    protected void batchTests(int diffBeg, int diffEnd, int diffSteps){
//        int diffBeg = 10, diffEnd = 100, diffSteps = 5;
        
        // Increment of difficulty.
        int diffInc = (diffEnd - diffBeg) / diffSteps;
        
        int curDiff = diffBeg; 
        for (int i = 0; i < diffSteps; i++){
           curDiff = diffBeg + i*diffInc;
           if ( i == diffSteps-1) curDiff = diffEnd;
           
           conductTest(defNumProb, curDiff);
        }
    }

}
