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
        
        conductTest();
    }
    
    private Integer randNum() {
        return rand.nextInt(max) + min;
    }
    
    @Override
    protected Problem randomProblem() {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for (int i = 0; i < probDiff; i++)
            arr.add(randNum());
            
        return new SortDesc(arr);
    }

}
