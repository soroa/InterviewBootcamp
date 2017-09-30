package kth_element_unsorted_array;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> a, int k) {
        if (a.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (k > a.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> sorted = new ArrayList<>();
        Iterator<Integer> it = a.iterator();
        while (it.hasNext()) {
            int next = it.next();
            if(sorted.isEmpty()){
                sorted.add(next);
                continue;
            }
            for (int i = 0; i < sorted.size(); i++) {
                if (sorted.get(i) > next) {
                    sorted.add(i, next);
                    break;
                } else if (i == sorted.size() - 1) {
                    sorted.add(next);
                    break;
                }
            }
        }
        return sorted.get(k - 1);
    }


}

