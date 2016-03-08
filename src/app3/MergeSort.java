package app3;

import java.util.ArrayList;

import app3.def.DivConqTemplate;
import app3.def.Problem;
import app3.def.Solution;
import app3.SortDesc;

/**
 * Thanks to H. Conrad Cunningham, Yi Liu, Cuihua Zhang from the Computer &
 * Information Science department, University of Mississippi.
 * 
 * @author H. Conrad Cunningham, Yi Liu, Cuihua Zhang
 *
 */
public class MergeSort extends DivConqTemplate implements Testable {
    
    int comparisons;
    
    public MergeSort(){
        comparisons = 0;
    }
    
    protected boolean isSimple(Problem p) {
        return (((SortDesc) p).getFirst() >= ((SortDesc) p).getLast());
    }

    protected Solution simplySolve(Problem p) {
        return (Solution) p;
    }

    protected Problem[] decompose(Problem p) {
        ArrayList<Integer> a = ((SortDesc) p).getArr();
        
        ArrayList<Integer> firstHalf = new ArrayList<Integer>();
        ArrayList<Integer> secondHalf = new ArrayList<Integer>();
        
        int mid = a.size() / 2;
        
        for (int i = 0; i < mid; i++)
            firstHalf.add(a.get(i));
        for (int i = mid+1; i < a.size(); i++)
            secondHalf.add(a.get(i));
        
        Problem[] ps = new SortDesc[2];
        ps[0] = new SortDesc(firstHalf);
        ps[1] = new SortDesc(secondHalf);
        return ps;
    }

    protected Solution combine(Problem p, Solution[] ss) {
        SortDesc halfA = (SortDesc)ss[0];
        SortDesc halfB = (SortDesc)ss[1];
        
        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        
        boolean aHasElements = true, bHasElements = true;
        boolean elementsLeftToMerge = true;
        while(elementsLeftToMerge) {
            aHasElements = halfA.getArr().isEmpty() ? false : true;
            bHasElements = halfB.getArr().isEmpty() ? false : true;
            
            if(aHasElements && bHasElements) {
                comparisons++;
                if(halfA.getArr().get(0) <= halfB.getArr().get(0))
                    mergedArr.add(halfA.getArr().remove(0));
                else
                    mergedArr.add(halfB.getArr().remove(0));
            } else if (aHasElements) {
                mergedArr.add(halfA.getArr().remove(0));
            } else if (bHasElements) {
                mergedArr.add(halfB.getArr().remove(0));
            } else {
                elementsLeftToMerge = false;
            }
        }
        
        return new SortDesc(mergedArr);
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    @Override
    public Solution resolve(Problem p) {
        return solve(p);
    }

    @Override
    public String getTestableName() {
        return "Merge Sort";
    }
}