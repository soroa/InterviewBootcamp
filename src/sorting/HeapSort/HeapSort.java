package sorting.HeapSort;

import java.util.ArrayList;

public class HeapSort {

    public static ArrayList<Integer> sort(ArrayList<Integer> a) {
        //1. Heapify tree
        for(int i=a.size()/2 -1; i>=0;i--) {
            heapify(a, a.size(), i);
        }
        //2
        ArrayList<Integer> res = new ArrayList<>();
        while(a.size()>0){
            swap(a, 0, a.size() - 1);
            res.add(a.remove(a.size() - 1));
            heapify(a, a.size(), 0);
        }
        return res;
    }


    private static void heapify(ArrayList<Integer> a, int totalNodesCount, int currentNodeIndex) {
        int leftChildIndex = 2 * currentNodeIndex + 1;
        int rightChildIndex = 2 * currentNodeIndex + 2;
        int largesElementIndex = currentNodeIndex;

        if (rightChildIndex < totalNodesCount && a.get(rightChildIndex) > a.get(largesElementIndex)) {
            largesElementIndex = rightChildIndex;
        }
        if (leftChildIndex<totalNodesCount && a.get(leftChildIndex) > a.get(largesElementIndex)) {
            largesElementIndex = leftChildIndex;
        }
        if (largesElementIndex != currentNodeIndex) {
            swap(a, currentNodeIndex, largesElementIndex);
            heapify(a, totalNodesCount, largesElementIndex);
        }

    }

    private static void swap(ArrayList<Integer> a, int n1, int n2) {
        int temp = a.get(n1);
        a.set(n1, a.get(n2));
        a.set(n2, temp);
    }
}
