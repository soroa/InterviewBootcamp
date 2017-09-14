package visitor_pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static int n;
    private static ArrayList<Integer> values;
    private static ArrayList<Color> colors;
    private static HashMap<Integer, ArrayList<Integer>> edges;

    public static Tree solve() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        values = new ArrayList<>();
        colors = new ArrayList<>();
        edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            values.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            colors.add(in.nextInt() == 0 ? Color.RED : Color.GREEN);
        }
        while (in.hasNext()) {
            int key = in.nextInt() - 1;
            if (edges.containsKey(key)) {
                edges.get(key).add(in.nextInt() - 1);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(in.nextInt() - 1);
                edges.put(key, list);
            }
        }
        TreeNode root = new TreeNode(values.get(0), colors.get(0), 0);
        constructTree(root, 0);
        return root;
    }


    private static void constructTree(TreeNode root, int
            depth) {
        int value = root.getValue();
        if (edges.containsKey(value)) {
            for (Integer i : edges.get(value)) {
                if (edges.containsKey(i)) {
                    TreeLeaf child = new TreeLeaf(values.get(i), colors.get(i), depth + 1);
                    //child is leaf
                    root.addChild(child);

                } else {
                    //child is node
                    TreeNode child = new TreeNode(values.get(i), colors.get(i), depth + 1);
                    root.addChild(child);
                    constructTree(child, depth + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
