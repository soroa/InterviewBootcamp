package trees.traversal.postorder;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(null);
        TreeNode current = a;
        ArrayList<Integer> res = new ArrayList<>();
        while (current != null) {
            if (current.left != null) {
                stack.push(current);
                current = current.left;
            } else if (current.right != null) {
                stack.push(current);
                current = current.right;

            } else {
                res.add(current.val);
                TreeNode topOfStack = stack.peek();
                if (topOfStack != null && topOfStack.right == current) {
                    topOfStack.right = null;
                }
                current = stack.pop();
                if (current != null) {
                    current.left = null;
                }
            }
        }
        return res;
    }
}

