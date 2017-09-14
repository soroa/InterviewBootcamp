package squareroot;

import java.util.Random;

public class Solution {
    public int sqrt(int a) {
        if (a == 0) return 0;
        if (a == 1) return 1;

        int mid = (int) (Math.random() * (a/2));
        int start = 0;
        int end = a / 2;

        while (start <= end) {
            if (mid * mid > a) {
                end = mid - 1;
            } else if (mid * mid < a) {
                start = mid + 1;
            } else if(mid*mid==a) {
                return mid;
            }
            mid = (start + end) / 2;
        }
        return mid * mid > a ? mid - 1 : mid;
    }
}
