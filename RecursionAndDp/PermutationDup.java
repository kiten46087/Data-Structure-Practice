package RecursionAndDp;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class PermutationDup {
    /* My solution using backtracking */
    public List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(0, nums, res, new LinkedList<>());
        return res;
    }

    public void helper(int len, int[] nums, List<List<Integer>> res, List<Integer> temp) {
        if (len == nums.length) {
            res.add(new LinkedList<>(temp));
        }

        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            helper(len + 1, nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }

    /* Solution building from permutation of first n - 1 characters */
    // And this solution uses string as input and get the permutation of characters.
    public ArrayList<String> getPerm(String str) {
        if (str == null) return null;

        ArrayList<String> permutations = new ArrayList<>();
        if (str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainder = str.substring(1);

        ArrayList<String> words = getPerm(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }

        return permutations;
    }   

    /* Private helper method. */
    String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    public static void main(String[] args) {
        PermutationDup test = new PermutationDup();
        test.getPerm("abc");
    }

}