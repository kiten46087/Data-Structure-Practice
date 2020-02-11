package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTSequence {
    /* This is a very hard problem and I ddidn't come up with a solution. */
    public ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.value);

        /* Recursive on left and right subtree */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together list from left and list from right */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = 
                    new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    /* Weave lists together. */
    public void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* If one list is empty the nadd remainder to prefix and store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headSecond);
    }
}