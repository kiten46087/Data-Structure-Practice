package TreesAndGraphs;

public class ValidBST {
    /* My recursive method. using one lower bound and one upper bound*/
    public boolean isValid(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }

    /* Helper method for actually do the recursive call. */
    public boolean helper(TreeNode node, Integer lowest, Integer highest) {
        boolean result = true;

        if (lowest != null) {
            if (node.value <= lowest) return false;
        }
        if (highest != null) {
            if (node.value >= highest) return false;
        }

        if (node.right != null) result = helper(node.right, node.value, highest) && result;

        if (node.left != null) result = helper(node.left, lowest, node.value) && result;
        
        return result;
    }

    /* We can also do the inorder traversal. */
    Integer lastPrinted = null;
    public boolean checkBST(TreeNode n) {
        if (n == null) return true;

        // Check left recursive
        if (!checkBST(n.left)) return false;

        // Check current
        if (lastPrinted != null && n.value <= lastPrinted) return false;
        lastPrinted = n.value;
        
        // Check right recursive
        if (!checkBST(n.right)) return false;

        return true;

    }


    /* Concise version of My recursive call */
    boolean checkBSTconcise(TreeNode n, Integer min, Integer max) {
        if (n == null) return true;

        if ((min != null && n.value <= min) || (max != null && n.value > max)) {
            return false;
        }

        if (!checkBSTconcise(n.left, min, n.value) || !checkBSTconcise(n.right, n.value, max)) return false;

        return true;
    }
}