package trees.isSameTree;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for binary tree
 * class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return 1;
        if ((a == null && b != null) || (a != null && b == null)) {
            return 0;
        } else {
            int lefts = isSameTree(a.left, b.left);
            int rights = isSameTree(a.right, b.right);
            int sameValue = a.val == b.val ? 1 : 0;
            if (lefts + rights +sameValue== 3) {
                return 1;
            }
        }
        return 0;

    }
}
