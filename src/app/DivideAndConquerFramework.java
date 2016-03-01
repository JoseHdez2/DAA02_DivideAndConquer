package app;

import java.util.ArrayList;

public abstract class DivideAndConquerFramework<T> {

    ArrayList<T> divAndConq(ArrayList<T> input){
        ArrayList<T> out;
        
        ArrayList<T> out1 = new ArrayList<T>();
        ArrayList<T> out2 = new ArrayList<T>();
        
        int half = input.size();
        for (int i = 0; i < half; i++)
            out1.add(input.remove(0));
        for (int i = 0; i < input.size(); i++)
            out2.add(input.remove(0));
        
        out1 = divAndConq(out1);
        out2 = divAndConq(out2);
        
        divAndConq();
        
        return out;
    }
}
