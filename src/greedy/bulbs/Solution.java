package greedy.bulbs;

import java.util.ArrayList;

public class Solution {
    public static int NEGATIVE = 1;
    public static int POSITIVE = 0;
    public int bulbs(ArrayList<Integer> a) {
        int counter = 0;
        int mode = 0;
        for (Integer i : a) {
            if (i == mode) {
                counter++;
                mode = (mode + 1) % 2;
            }
        }
        return counter;
    }
}
