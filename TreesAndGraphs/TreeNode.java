package TreesAndGraphs;

public class TreeNode {
    int value;
    TreeNode right;
    TreeNode left;

    public TreeNode(int value) {
        this.value = value;
    }

    /* Print the tree in inorder. */
    public void printTree() {
        inOrderTraversal(this);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;;
        inOrderTraversal(node.left);
        System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }
}