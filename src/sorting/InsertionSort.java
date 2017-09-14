package sorting;

import java.util.ArrayList;

public class InsertionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> a){
        for (int i = 1; i <a.size() ; i++) {
            for(int j=i-1; j<i; j++) {
                if (a.get(i) <= a.get(j)) {
                    a.add(i, a.get(j));
                }
            }
        }
        return a;
    }
}
