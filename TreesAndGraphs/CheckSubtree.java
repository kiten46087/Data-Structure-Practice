package TreesAndGraphs;

public class CheckSubtree {
    /* For this solution using a preorder traversal and add " " when come across null node. */
    public boolean checkSubtree(TreeNode s, TreeNode t) {
        StringBuilder sList = new StringBuilder();
        StringBuilder tList = new StringBuilder();
        
        traverse(s, sList.append(" "));
        traverse(t, tList.append(" "));
        
        
        return sList.toString().contains(tList.toString());
    }

    /* In order traverse. */
    public void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("x ");
            return;
        }
        sb.append(root.value + " ");
        traverse(root.left, sb);
        traverse(root.right, sb);       
    }


    /* Another method that is a optimized version. */
    public boolean containsTree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        return subTree(s, t);
    }

    /* Looking for the node that is the same. */
    public boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        } else if (r1.value == r2.value && matchTree(r1, r2)) {
            return true;
        }

        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    /* Actually comparing the nodes of r1 and r2. */
    public boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else if (r1.value != r2.value) {
            return false;
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }
}