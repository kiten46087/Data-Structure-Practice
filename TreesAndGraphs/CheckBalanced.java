package TreesAndGraphs;



public class CheckBalanced {
    /* This method needs extra global variable to indicate invalid situtation. */
    boolean result = true;
    /* Return whether the tree is balanced or not. */
    public boolean checkBalanced(TreeNode root) {
        getHeight(root);
        return result;
    }

    /* Helper method which being used to find the height and 
     * Check balanced at the same time.
     */
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            result = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    } 


    /* This method provided by the CC189 and uses MIN_VALUE as indicator */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    /* Helper method check the balanced while get the length of the tree. */
    private int checkHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}