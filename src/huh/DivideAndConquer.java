package huh;

public interface DivideAndConquer<T> {

    public T solve();
    
    boolean isSimple();
    
    T simplySolve();
    
    T decompose();
    
    T combine();
}
