package trees.traversal.inorder;

import apple.laf.JRSUIUtils;
import trees.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> inorderTraversalRec(TreeNode a) {
        if (a == null) {
            return new ArrayList<>();
        } else if (isLeaf(a)) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(a.val);
            return arr;
        } else {
            ArrayList res = inorderTraversal(a.left);
            res.add(a.val);
            res.addAll(inorderTraversal(a.right));
            return res;
        }
    }

    private boolean isLeaf(TreeNode a) {
        return (a.right == null && a.left == null);
    }

    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode current = a;
        stack.push(null);
        while (current != null) {
            if (current.left != null) {
                stack.push(current);
                current = current.left;
            } else if (current.right != null) {
                res.add(current.val);
                current = current.right;
            } else if (isLeaf(current)) {
                res.add(current.val);
                current = stack.pop();
                if (current != null) {
                    current.left = null;
                }
            }
        }
        return res;
    }
}
