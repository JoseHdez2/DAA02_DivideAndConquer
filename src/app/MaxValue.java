package app;

import java.util.ArrayList;

import app.SortDesc;
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
public class MaxValue extends DivConqTemplate implements Testable {
    
    int comparisons;
    
    public MaxValue(){
        comparisons = 0;
    }
    
    protected boolean isSimple(Problem p) {
        return ((SortDesc) p).getArr().size() <= 1;
    }

    protected Solution simplySolve(Problem p) {
        ArrayList<Integer> prob = ((SortDesc) p).getArr();
        int val = prob.isEmpty() ? 0 : prob.get(0);
        return new MaxSolution(val);
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
        MaxSolution halfA = (MaxSolution)ss[0];
        MaxSolution halfB = (MaxSolution)ss[1];
//        System.out.println(String.format("a= %s, b= %s", halfA, halfB));
        
        comparisons++;
        if (halfA.getMax() > halfB.getMax())
            return new MaxSolution(halfA.getMax());
        else
            return new MaxSolution(halfB.getMax());
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
        return "Find Max Val";
    }
}