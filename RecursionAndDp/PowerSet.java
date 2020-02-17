package RecursionAndDp;

import java.util.List;
import java.util.ArrayList;

public class PowerSet {
    // My approach using iterative method
    // No matter what we do the time and space space complexity cannot exceed O(N 2^N)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }

        return res;
    }

    // Based on the concept of bit manipulation and for each element it only 
    // has two choices which is choose and not choose.
    public List<List<Integer>> subsets2(ArrayList<Integer> set) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        int max = 1 << set.size();
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSubsets.add(subset);
        }
        return allSubsets;
    }

    public ArrayList<Integer> convIntToSet(int x, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                subset.add(set.get(index));
            }
            index += 1;
        }
        return subset;
    }
}