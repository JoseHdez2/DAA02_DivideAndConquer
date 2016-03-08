package app3;

import java.util.ArrayList;

import app3.def.Problem;
import app3.def.Solution;

public class BubbleSort implements Testable {

    int comparisons;
    
    public BubbleSort(){
        comparisons = 0;
    }
    
    private ArrayList<Integer> swap(int i, int j, ArrayList<Integer> arr) {
        int aux = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, aux);
        
        return arr;
    }
    
    @Override
    public int getComparisons() {
        return comparisons;
    }

    @Override
    public Solution resolve(Problem p) {
        ArrayList<Integer> a = ((SortDesc) p).getArr();
        
        // Gone thru all elements and they were sorted.
        boolean perfectRun = false;
        
        while (!perfectRun){
            perfectRun = true; // Assume all are sorted until proven otherwise.
            
            for (int i = 0; i < a.size()-1; i++){
                comparisons++;
                if (a.get(i) < a.get(i+1)) {
                    a = swap(i, i+1, a);
                    perfectRun = false; // All elements weren't sorted.
                }
            }
        }
        
        return new SortDesc(a);
    }

    @Override
    public String getTestableName() {
        return "Bubble Sort";
    }

}
