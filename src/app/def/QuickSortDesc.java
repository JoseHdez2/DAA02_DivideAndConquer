package app.def;

/**
 * Thanks to H. Conrad Cunningham, Yi Liu, Cuihua Zhang from the Computer &
 * Information Science department, University of Mississippi.
 * 
 * @author H. Conrad Cunningham, Yi Liu, Cuihua Zhang
 *
 */
public class QuickSortDesc implements Problem, Solution {
    public QuickSortDesc(int[] arr, int first, int last) {
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

    public int[] getArr() {
        return arr;
    }
    
    private int[] arr;
    private int first, last;
}