package trees.level_order;

import trees.TreeNode;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        if (a == null) {
            return new ArrayList<>();
        } else if (isLeaf(a)) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<Integer>());
            list.get(0).add(a.val);
            return list;
        } else {
            ArrayList<ArrayList<Integer>> left = new ArrayList<>();
            if (a.left != null) {
                left = levelOrder(a.left);
            }
            ArrayList<ArrayList<Integer>> right = new ArrayList<>();
            if (a.right != null) {
                right = levelOrder(a.right);
            }
            ArrayList<ArrayList<Integer>> merged = new ArrayList<>();
            int maxDepth = left.size() > right.size() ? left.size() : right.size();
            for (int i = 0; i < maxDepth; i++) {
                merged.add(i, new ArrayList<>());
                if (i < left.size()) {
                    merged.get(i).addAll(left.get(i));
                }
                if (i < right.size()) {
                    merged.get(i).addAll(right.get(i));
                }
                ArrayList<Integer> currentRoot = new ArrayList<>();
                currentRoot.add(a.val);
                merged.add(0, currentRoot);
            }
            return merged;
        }
    }

    private boolean isLeaf(TreeNode a) {
        return (a.right == null && a.left == null);
    }

}
