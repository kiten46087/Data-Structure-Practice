package ArrayString;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class IsUnique {
    /**
     * Method using extra memory Map data structure.
     * Time complexity is O(n).
     */
    public static boolean isUniqueMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != 1) return false;
        }

        return true;
    }


    /**
     * Method using extra memory using array and sort data structure.
     * Time complexity is O(N log N).
     */
    public static boolean isUniqueArray(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) return false;
        }

        return true;
    }

    
    /**
     * Method using fixed amout of memory O(1) space and O(N) time complexity.
     * Assuming the ASCII code which incudes 128 chars.
     */
    public static boolean isUniqueFixedArray(String s) {
        boolean[] array = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i)]) {
                return false;
            } 
            array[s.charAt(i)] = true;
        }

        return true;
    }

    /**
     * Method using bit vector which takes lesser space complexity.
     * O(1) space complexity. And O(n) time complexity.
     * Assuming only lower case character inside the string.
     */
    public static boolean isUniqueBit(String s) {
        int check = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((check & (1 << val)) > 0) {
                return false;
            }
            check |= (1 << val);
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "aabc";

        System.out.println(isUniqueBit(s1));
        System.out.println(isUniqueBit(s2));
    }
}