package TreesAndGraphs;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ListsOfDepth {
    /* Recursive method for level order traversal. */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        helper(result, 0, root);

        return result;
    }

    private void helper(List<List<Integer>> result, int level, TreeNode node) {
        if (level > result.size() - 1) result.add(new ArrayList<>());

        result.get(level).add(node.value);
        if (node.left != null) helper(result, level + 1, node.left);
        if (node.right != null) helper(result, level + 1, node.right);
    }

    /* My iterative solution of this level order traversal. BFS */
    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        
        if (root == null) return result;
        
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
            
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.removeFirst();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);    
                
                list.add(temp.value);
            }
            result.add(list);
        }
        
        return result;
    }
}