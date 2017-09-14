package trees;

public class Solution {
    public int isBalanced(TreeNode a) {
        return subtreeDepth(a) == -1 ? 0 : 1;
    }


    public int subtreeDepth(TreeNode a) {
        if (a == null) {
            return 0;
        } else {
            int leftTreeDepth = subtreeDepth(a.left);
            int rightTreeDepth = subtreeDepth(a.right);
            if(leftTreeDepth==-1 || rightTreeDepth==-1){
                return -1;
            }
            if(Math.abs(leftTreeDepth-rightTreeDepth)>1) return -1;
            else return Math.max(leftTreeDepth, rightTreeDepth)+1;
        }
    }
}

