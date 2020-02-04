package ArrayString;

import java.util.Arrays;

public class CheckPermutation {
    /**
     * Sort two strings and compare.
     * Time complexity is O(N log N) space complexity is O(1).
     */
    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }
        
        return true;
    }


    /**
     * Sort two strings and compare.
     * These codes below are much cleaner.
     */
    public static boolean checkPermutationOptimize(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        return sort(s1).equals(s2);
    }


    /** 
     * Helper method which sort the string s inplace.
    */
    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }


    /**
     * Counting characters inside the array.
     */
    public static boolean checkPermutationArray(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[128];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)] += 1;                     
        }

        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)] -= 1;
            if (count[s2.charAt(i)] < 0) return false;
        }

        return true;
    }

    
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "edcba";

        String s3 = "adf";
        System.out.println(checkPermutation(s1, s2));
        System.out.println(checkPermutation(s1, s3));
    }
}