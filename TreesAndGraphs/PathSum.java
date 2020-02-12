package TreesAndGraphs;

import java.util.HashMap;

public class PathSum {
    int count = 0;

    /* This is my kinda ugly and slow solution I think it might be brute force solution. */
    public int pathSumMy(TreeNode root, int sum) {
        traverse(root, sum);
        return count;
    }

    /* This is the method that traverse all the nodes and at each node do the search. */
    public void traverse(TreeNode node, int sum) {
        if (node == null) return;
        helper(node, sum);
        traverse(node.left, sum);
        traverse(node.right, sum);
    }
    
    /* Acutally searching the sum. */
    public void helper(TreeNode node, int sum) {
        if (node == null) return;
        
        if (sum == node.value)  {
            count += 1;
            
        }
        
        helper(node.left, sum - node.value);
        helper(node.right, sum - node.value);
    }


    /* Elegant brute force solution. */
    public int countPathWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int pathFromRoot = countFromNode(root, targetSum, 0);

        int pathFromLeft = countPathWithSum(root.left, targetSum);
        int pathFromRight = countPathWithSum(root.right, targetSum);

        return pathFromLeft + pathFromRight + pathFromRoot;
    }

    // Helper method.
    public int countFromNode(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.value;

        int totalPaths = 0;
        if (currentSum == targetSum) {
            totalPaths += 1;
        }

        totalPaths += countFromNode(node.left, targetSum, currentSum);
        totalPaths += countFromNode(node.right, targetSum, currentSum);
        return totalPaths;
    }

    // Faster appraoch using hashMap, this is just like two sum questions.
    public int countPathWithSum2(TreeNode root, int targetSum) {
        return countPathWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    public int countPathWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0; // base case.

        runningSum += node.value;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSum == targetSum) {
            totalPaths += 1;
        }

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;

    }

    public void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}