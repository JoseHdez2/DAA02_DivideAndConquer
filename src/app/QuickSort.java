package app;

public class QuickSort extends DivConqTemplate {
    protected boolean isSimple(Problem p) {
        return (((QuickSortDesc) p).getFirst() >= ((QuickSortDesc) p).getLast());
    }

    protected Solution simplySolve(Problem p) {
        return (Solution) p;
    }

    protected Problem[] decompose(Problem p) {
        int first = ((QuickSortDesc) p).getFirst();
        int last = ((QuickSortDesc) p).getLast();
        int[] a = ((QuickSortDesc) p).getArr();
        int x = a[first]; // pivot value
        int sp = first;
        for (int i = first + 1; i <= last; i++) {
            if (a[i] < x) {
                swap(a, ++sp, i);
            }
        }
        swap(a, first, sp);
        Problem[] ps = new QuickSortDesc[2];
        ps[0] = new QuickSortDesc(a, first, sp - 1);
        ps[1] = new QuickSortDesc(a, sp + 1, last);
        return ps;
    }

    protected Solution combine(Problem p, Solution[] ss) {
        return (Solution) p;
    }

    private void swap(int[] a, int first, int last) {
        int temp = a[first];
        a[first] = a[last];
        a[last] = temp;
    }
}