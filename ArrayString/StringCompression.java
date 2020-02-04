package ArrayString;

/**
 * Similar to LeetCode 443.
 */
public class StringCompression {
    /**
     * Return the string after being compressed.
     * This solution is working but not very concies.
     */
    public static String stringCompress(String s) {
        StringBuilder sb = new StringBuilder();

        int tempCount = 1;
        int i = 0;

        while (i < s.length()) {
            sb.append(s.charAt(i));
            if (i + 1 == s.length()) {
                sb.append(tempCount);
                break;
            }
                
            while (s.charAt(i) == s.charAt(i + 1)) {
                tempCount += 1;
                i += 1;
                if (i == s.length() - 1) break;
            }
            sb.append(tempCount);
            tempCount = 1;
            i += 1;

            // if (i == s.length)
        }

        return sb.toString();
    }


    /**
     * This solution is more concise when comparing the above one.
     * These two solutions are all pretty straightforward and is the same algorithm.
     * 
     * !!!
     * And the reason why not using string concatenation is that the string + string
     * is O(N^2) time complexity.
     * 
     */
    public static String stringCompressConcise(String s) {
        StringBuilder sb = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < s.length(); i++) {
            countConsecutive += 1;

            /** If the next character is different than the last one or is at the boundary. Then add
             *  the character and then add the count consecutive to the string builder.
             */
            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                sb.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringCompressConcise("aabccca"));
        System.out.println(stringCompressConcise("abcad"));
        System.out.println(stringCompressConcise("aa"));
        System.out.println(stringCompressConcise("a"));
        System.out.println(stringCompressConcise("aabb"));
    }
}