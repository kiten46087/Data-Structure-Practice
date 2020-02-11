package TreesAndGraphs;

/* This Problem can be asked with or without the link to the parent node. */
/* The below solution is the situtation when no node has links to the parent. */
/* When can have links to parent we can use depth can traverse back difference. */
/* Or we can uses the cover function to check from certain node. */
public class FirstCommonAncestor {
    /* This is my approach for compaing when the root node is BST. */
    public TreeNode commonBST(TreeNode root, TreeNode p, TreeNode q) {
        if (p.value <= root.value && q.value >= root.value) return root;
        if (p.value >= root.value && q.value <= root.value) return root;
        
        if (p.value > root.value && q.value > root.value) return commonBST(root.right, p, q);
        if (p.value < root.value && q.value < root.value) return commonBST(root.left, p, q);
        
        return null;
    }

    /* Approach for searching when the tree is not BST. This is slow and cause N*log(N)*/
    boolean found = false;
    public TreeNode commonNoBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        
        
        inOrder(root.left, p);
        boolean pLeft = found;
        found = false;
        
        inOrder(root.left, q);
        boolean qLeft = found;
        found = false;
        
        
        if (pLeft && qLeft) return commonNoBST(root.left, p, q);
        if (!pLeft && !qLeft) return commonNoBST(root.right, p, q);
        if (pLeft && !qLeft || !pLeft && qLeft)  return root;
        return null;
    }

    public void inOrder(TreeNode root, TreeNode node) {
        if (root == null) return;
        if (root.left != null) inOrder(root.left, node);
        if (root == node) found = true;
        if (root.right != null) inOrder(root.right, node);
    }

    /* More elegant version of the above solution when coming across the tree traversal. */
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* Error check. */
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return helper(root, p, q);
    }

    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean pLeft = covers(root.left, p);
        boolean qLeft = covers(root.left, p);

        if (pLeft != qLeft) return root;
        TreeNode childSide = pLeft ? root.left : root.right;
        return helper(childSide, p, q);
    }


    /* Check if the root contains node p. */
    public boolean covers(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root == p) return true;
        return covers(root.left, p) || covers(root.right, p);
    }


    /* More concise recursive method. 
     * But this solution ignore the case when searching the node that doesn't exist.   
     * So we can use a wrapper class that has an attribute isAncestor to check.
     * 
     * !!! See the CC189 page 261 for details!
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root;
        if (left == null && right != null) return right;
        if (left != null && right == null) return left;
        
        return null;
    }
}