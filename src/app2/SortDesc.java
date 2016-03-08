package app2;

import java.util.ArrayList;

public class SortDesc implements Problem, Solution {
    public SortDesc(ArrayList<Integer> arr, int first, int last) {
        this.arr = arr;
        this.first = first;
        this.last = last;
    }
    
    public int getFirst() {
        return first;
    }
    
    public int getLast() {
        return last;
    }
    
    public ArrayList<Integer> getArr() {
        return arr;
    }
    
    public int getSize(){
        return arr.size();
    }
    
    private ArrayList<Integer> arr;
    private int first, last;
}