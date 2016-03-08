package app;

import java.util.ArrayList;

import app.def.Problem;
import app.def.Solution;

/**
 * Thanks to H. Conrad Cunningham, Yi Liu, Cuihua Zhang from the Computer &
 * Information Science department, University of Mississippi.
 * 
 * @author H. Conrad Cunningham, Yi Liu, Cuihua Zhang
 *
 */
public class SortDesc implements Problem, Solution {
    
    public SortDesc(ArrayList<Integer> arr) {
        this.arr = arr;
    }
    
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
    
    public String toString(){
        return arr.toString();
    }
    
    private ArrayList<Integer> arr;
    private int first, last;
}