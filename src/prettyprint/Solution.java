package prettyprint;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int dim = a * 2 - 1;

        for (int i = 0; i <dim ; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j <dim ; j++) {
                int xDiff = Math.abs(i - a+1);
                int yDiff = Math.abs(j - a+1);
                int max = Math.max(xDiff, yDiff);
                res.get(i).add(max + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Solution mSolution = new Solution();
        mSolution.prettyPrint(4);
        for (int i = 0; i <5 ; i++) {
            ArrayList<ArrayList<Integer>> res = mSolution.prettyPrint(1);
            printMatrx(res);
        }
    }

    public static void printMatrx(ArrayList<ArrayList<Integer>> matrix){
        for (int i = 0; i < matrix.size(); i++) {
            String line = "";
            for (int j = 0; j <matrix.size() ; j++) {
                line = line.concat(String.valueOf(matrix.get(i).get(j)));
            }
            System.out.println(line);
        }
    }

}


