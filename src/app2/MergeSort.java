package app2;

import java.util.ArrayList;

// import java.lang.ArrayList;

class MergeSort extends TestableDivConqSort {
    public boolean isSimple(Problem p){
        return (((SortDesc)p).getSize()==1);
    }
    
    public Solution simplySolve(Problem p){
        return (Solution) p;
    }
    
    public Problem[] decompose(Problem p){
        Problem[] ps = new SortDesc[2];
        int mid = p.getSize() / 2;
        
        ArrayList<Integer> firstHalf = new ArrayList<Integer>();
        ArrayList<Integer> secondHalf = new ArrayList<Integer>();
        
        for (int i = 0; i < mid; i++)
            firstHalf.add(p.getSubproblem(i));
        
        ps[0] = firstHalf;
        ps[1] = secondHalf;
    }

    @Override
    protected Solution combine(Problem p, Solution[] ss) {
        switch(){
        case 1:
            
        case 2:
            
        default:
            System.out.println(""); break;
        }
    }
}