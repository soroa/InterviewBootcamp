package hasing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer el : a) {
            map.put(el, a.indexOf(el));
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < a.size() / 2; i++) {
            int missing = b - a.get(i);
            Integer match = map.get(missing);
            if (match != null && match>=i) {
                if (res.size() == 2) {
                    if (res.get(1) > match) {
                        res.set(0, i);
                        res.set(1, match);
                    } else if (res.get(0) > i) {
                        res.set(0, i);
                        res.set(1, match);
                    }
                } else {
                    res.add(i);
                    res.add(match);

                }
            }
        }
        return res;
    }
}

