package visitor_pattern;

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private int result = 0;

    public int getResult() {
        //implement this
        return 1;
    }

    public void visitNode(TreeNode node) {
        visitGenericNode(node);

    }

    public void visitLeaf(TreeLeaf leaf) {
        visitGenericNode(leaf);
    }

    private void visitGenericNode(Tree node) {
        if (node.getColor() == Color.RED) {
            result = result * (node.getValue() == 0 ? 1 : node.getValue());
            result = result % (int) (Math.pow(10, 9) + 7);
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafNodesSum = 0;
    private int greenLeafNodesSum = 0;
    public int getResult() {

        return Math.abs(nonLeafNodesSum - greenLeafNodesSum);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth()%2==0){
            nonLeafNodesSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafNodesSum += leaf.getValue();
        }
    }
}

