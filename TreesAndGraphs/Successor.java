package TreesAndGraphs;

public class Successor {
    /* My solution. 
     * Recursive approach but using two global variables to check. 
     * This Solution can be used as normal binary tree.
     * 
     * This question can also be don when provided only the node, and the node class contains a 
     * pointer which points to the parent node.
     * 
     */
    public TreeNode successor(TreeNode root, TreeNode p) {
        helper(root, p);
        return result;
    }

    TreeNode result;
    boolean find = false;
    private void helper(TreeNode node, TreeNode target) {
        if (node == null) return;

        helper(node.left, target);

        if (find) {
            result = node;
            find = false;
        }
        if (target == node) find = true;
        
        helper(node.right, target);
    }


    /* This Solution uses the properties of Binary Search Tree. */
    public TreeNode successorBST(TreeNode root, TreeNode p) {
        TreeNode prev = null;
        while (root != null) {
            if (root.value < p.value) {
                prev = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return prev;
    }
}