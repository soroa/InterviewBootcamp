package trees.vertical_order_traversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    private int maxWidhtLeft = 0;
    private int maxWidthRight = 0;

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        HashMap<Integer, ArrayList<DepthNode>> map = new HashMap<>();
        map = verticalOrderTraversalRec(map, 0, 0, A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int j = 0;
        for (int i = maxWidhtLeft; i < maxWidthRight; i++) {
            res.add(j, new ArrayList<>());
            for (DepthNode dn : map.get(i)) {
                res.get(j).add(dn.node.val);
            }
            j++;
        }
        return res;

    }

    private HashMap<Integer, ArrayList<DepthNode>> verticalOrderTraversalRec(HashMap<Integer, ArrayList<DepthNode>> map, int shift, int depth, TreeNode a) {
        if(a==null) return map;
        if (shift < maxWidhtLeft) maxWidhtLeft = shift;
        if (shift > maxWidthRight) maxWidthRight = shift;
        map.computeIfAbsent(shift, k -> new ArrayList<>());
        map.get(shift).add(new DepthNode(a, depth));
        if (isLeaf(a)) {
            return map;
        }
        HashMap<Integer, ArrayList<DepthNode>> left = verticalOrderTraversalRec(map, shift - 1, depth + 1, a.left);
        return verticalOrderTraversalRec(left, shift + 1, depth + 1,a.right);
    }


    private boolean isLeaf(TreeNode a) {
        return (a.right == null && a.left == null);
    }

    private class DepthNode {
        TreeNode node;
        int depth;

        DepthNode(TreeNode node, int depth) {
            this.depth = depth;
            this.node = node;
        }
    }
}

