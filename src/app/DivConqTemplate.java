package app;

/**
 * Thanks to H. Conrad Cunningham, Yi Liu, Cuihua Zhang from the Computer &
 * Information Science department, University of Mississippi.
 * 
 * @author jose
 *
 */
abstract public class DivConqTemplate {
    final public Solution solve(Problem p) {
        Problem[] pp;
        if (isSimple(p)) {
            return simplySolve(p);
        } else {
            pp = decompose(p);
        }
        Solution[] ss = new Solution[pp.length];
        for (int i = 0; i < pp.length; i++) {
            ss[i] = solve(pp[i]);
        }
        return combine(p, ss);
    }

    abstract protected boolean isSimple(Problem p);

    abstract protected Solution simplySolve(Problem p);

    abstract protected Problem[] decompose(Problem p);

    abstract protected Solution combine(Problem p, Solution[] ss);
}
