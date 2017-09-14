package sorted_insert_position;

import java.util.ArrayList;

public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        int midIndex = a.get(a.size() / 2);
        int start = 0;
        int end = a.size() - 1;
        int mid = (start + end) / 2;
        if (a.get(end) < b) {
            return a.size();
        }
        if (a.get(start) > b) {
            return 0;
        }
        while (start <= end) {
            if (a.get(mid) < b) {
                start = mid + 1;
            } else if (a.get(mid) > b) {
                end = mid - 1;
            } else if (a.get(mid) == b) {
                return mid;
            }
            mid = (start + end) / 2;
        }
        return a.get(mid) > b ? mid - 1 : mid + 1;
    }
}

