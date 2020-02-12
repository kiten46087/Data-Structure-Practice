package TreesAndGraphs;

import java.util.Random;

/**
 * For this class the size attribute is for question 4.11
 */
public class TreeNode {
    public int value;
    public TreeNode right;
    public TreeNode left;
    private int size = 0;

    public TreeNode(int value) {
        this.value = value;
        size = 1;
    }

    // Accessor method
    public int size() { return size; }
    public int data() { return value; }

    /** 
     *  Return a random node.
     *  We can further optimized this solution by only call the random call once and 
     *  get the index from it. Details on the book.
     */
    public TreeNode getRandomNode() {
        int leftSize = left == null ? 0 : left.size();
        Random random = new Random();
        int index = random.nextInt(size);
        if (index < leftSize) {
            return left.getRandomNode();
        } else if (index == leftSize) {
            return this;
        } else {
            return right.getRandomNode();
        }
    }

    /* This insert order method can insert a binary search tree. */
    public void insertOrder(int d) {
        if (d <= value) {
            if (left == null) {
                left = new TreeNode(d);
            } else {
                left.insertOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode(d);
            } else {
                right.insertOrder(d);
            }
        }
        size += 1;
    }

    /* This method can find the node if this treenode is implemented as BST. */
    public TreeNode find(int d) {
        if (d == value) {
            return this;
        } else if (d <= value) {
            return left != null ? left.find(d) : null;
        } else if (d > value) {
            return right != null ? right.find(d) : null;
        }

        return null;
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