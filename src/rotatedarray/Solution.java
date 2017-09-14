package rotatedarray;

import java.util.List;

public class Solution {
    // DO NOT MODIFY THE LIST
    public int findMin(final List<Integer> a) {
        int start = 0;
        int end = a.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(start) <= a.get(end)) {
                return a.get(start);
            } else if (a.get((mid+1)%a.size()) >= a.get(mid) && a.get((mid-1)%a.size()) >= a.get(mid)) {
                return a.get(mid);
            } else if (a.get(mid) <= a.get(end)) {
                end = mid - 1;
            } else if (a.get(mid) >= a.get(start)) {
                start = mid + 1;
            }
        }
        return -1;
    }
}