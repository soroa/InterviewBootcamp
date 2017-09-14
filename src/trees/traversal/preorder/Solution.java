package trees.traversal.preorder;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = a;
        stack.push(null);
        ArrayList<Integer> res = new ArrayList<>();
        while (current != null) {
            res.add(current.val);
            if (current.left != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                current = current.left;
            } else if (current.right != null) {
                current = current.right;
            } else {
                current = stack.pop();
            }

        }
        return res;
    }
}
