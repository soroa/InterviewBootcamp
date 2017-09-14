package searchmatrix;

import java.util.ArrayList;

public class Solution {
    private int elementsPerRow;

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        elementsPerRow = a.get(0).size();
        int totalLength = a.size() * a.get(0).size();
        int start = 0;
        int end = totalLength - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (getElement(mid,a) < b) {
                //go right
                start = mid + 1;
                mid = (start + end) / 2;
            } else if (getElement(mid,a) > b) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if(getElement(mid,a)==b){
                return 1;
            }
        }
        return 0;
    }

    private int getElement(int el,ArrayList<ArrayList<Integer>> a ) {
       return a.get(arrayToRow(el)).get(arrayToColumn(el));
    }

    private int arrayToRow(int index) {
        return index / elementsPerRow;
    }

    private int arrayToColumn(int index) {
        return index % elementsPerRow;
    }

}

