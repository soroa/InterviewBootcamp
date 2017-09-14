package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public static <T extends Comparable> ArrayList<T> merge(Iterator<T> a, Iterator<T> b) {
        ArrayList<T> mergedList = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while (a.hasNext() || b.hasNext()) {
            if(!a.hasNext()){
                mergedList.add(b.next());
                continue;
            }
            if(!b.hasNext()){
                mergedList.add(a.next());
                continue;
            }
            T aEl = a.next();
            T bEl = b.next();
            if ( aEl.compareTo(bEl)<0) {
                mergedList.add(aEl);
            }else{
                mergedList.add(bEl);
            }
        }
        return mergedList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add(5);
        a.add(34);
        a.add(78);
        a.add(94);
        b.add(7);
        b.add(52);
        b.add(65);
        b.add(99);

        ArrayList<Integer> merged = Solution.merge(a.iterator(), b.iterator());
        System.out.println(merged);
    }
}
