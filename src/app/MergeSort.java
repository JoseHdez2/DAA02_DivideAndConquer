package app;

import java.util.ArrayList;

import app.def.DivConqTemplate;
import app.def.Problem;
import app.def.Solution;

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
        return ((SortDesc) p).getArr().size() <= 1;
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
//        System.out.println(String.format("a= %s, b= %s", halfA, halfB));
        
        ArrayList<Integer> mergedArr = new ArrayList<Integer>();
        
        boolean aHasElements = true, bHasElements = true;
        boolean elementsLeftToMerge = true;
        
        boolean debug = false;
        if(debug){
            System.out.println("Traza:---------------");
            System.out.println(String.format("%s (size = %d)", halfA, halfA.getArr().size()));
            System.out.println(String.format("%s (size = %d)", halfB, halfB.getArr().size()));
        }
        
        while(elementsLeftToMerge) {
            aHasElements = halfA.getArr().isEmpty() ? false : true;
            bHasElements = halfB.getArr().isEmpty() ? false : true;
            
            if(aHasElements && bHasElements) {
                comparisons++;
//                System.out.println("ab");
                if(halfA.getArr().get(0) <= halfB.getArr().get(0))
                    mergedArr.add(halfA.getArr().remove(0));
                else
                    mergedArr.add(halfB.getArr().remove(0));
            } else if (aHasElements) {
//                System.out.println("a");
                mergedArr.add(halfA.getArr().remove(0));
            } else if (bHasElements) {
//                System.out.println("b");
                mergedArr.add(halfB.getArr().remove(0));
            } else {
//                System.out.println("none(?)");
                
                elementsLeftToMerge = false;
            }
        }
        
        if(debug){
            System.out.println(String.format("%s (size = %d)", mergedArr, mergedArr.size()));
            System.out.println("--------------");
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