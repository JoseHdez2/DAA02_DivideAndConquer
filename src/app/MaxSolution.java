package app;

import app.def.Solution;

public class MaxSolution implements Solution {
    Integer max;

    public MaxSolution(int i){
        max = i;
    }
    
    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
    
    public String toString(){
        return max.toString();
    }
}
