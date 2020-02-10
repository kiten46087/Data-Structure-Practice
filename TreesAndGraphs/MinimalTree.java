package TreesAndGraphs;

public class MinimalTree {

    /* This is my approach first find the middle one and then recursively set the left and right child. */
    public TreeNode minimalTree(int[] array) {
        return helper(array, 0, array.length - 1);
    }

    private TreeNode helper(int[] array, int start, int end) {
        if (start == end) return new TreeNode(array[start]);
        if (start > end) return null;

        int mid = start + (end - start + 1) / 2;
        TreeNode middleNode = new TreeNode(array[mid]);

        middleNode.right = helper(array, mid + 1, end);
        middleNode.left = helper(array, start, mid - 1);

        return middleNode;
    }

    public static void main(String[] args) {
        int[] array1 = {0, 1, 2, 3, 4, 5};
        int[] array2 = {0, 1, 2, 3, 4, };

        MinimalTree testMin = new MinimalTree();

        TreeNode test1 = testMin.minimalTree(array1);
        TreeNode test2 = testMin.minimalTree(array2);

        test1.printTree();
        System.out.println();
        test2.printTree();
    }
}