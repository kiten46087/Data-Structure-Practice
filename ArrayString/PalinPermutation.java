package ArrayString;

public class PalinPermutation {
    /**
     * Method using array count. it is just like checking odd numbers.
     * However this solution uses two passes
     */
    public static boolean palinPermu(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char temp = s.toLowerCase().charAt(i);
            if (temp == ' ') continue;
            count[temp - 'a'] ^= 1;
        }


        // Check for all zeros or only one 1.
        int oneCount = 0;
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
            oneCount += count[i];
        }

        if (oneCount == 1 || oneCount == 0) {
            return true;
        }

        return false;
    }   


    /**
     * Method using array count. But this solution uses one pass.
     * Assuming the string only contains lowercase letters.
     */
    public static boolean palindPermuOne(String s) {
        int countOdd = 0;

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a'] += 1;
            if (table[s.charAt(i) - 'a'] % 2 == 1) {
                countOdd += 1;
            } else {
                countOdd -= 1;
            }
        }

        return countOdd <= 1;
        // if (countOdd > 1) return false;
        // else return true;
    }


    /**
     * Method using bit vector, no need for extra array space.
     * Toggle certain bit and only check the final bit count is even or not.
     * e.g. (Means: At most 1 bit inside the bit vector).
     */
    public static boolean palindBitVector(String s) {
        int bitVector = creatBitVector(s);
        return checkAtMostOneBit(bitVector);
    }


    /**
     * Helper method create the bit vector.
     */
    public static int creatBitVector(String s) {
        int bitVector = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a';
            bitVector = toggle(bitVector, temp);
        }

        return bitVector;
    }


    /**
     * Helper method. Toggle and return the toggled vector.
     */
    public static int toggle(int bitVector, int ith) {
        if (ith < 0) return bitVector;

        int mask = 1 << ith;
        bitVector ^= mask;
        return bitVector;
    }

    /**
     * Check whether there is only one bit is 1 inside the vector.
     */
    public static boolean checkAtMostOneBit(int vector) {
        return (vector & (vector - 1)) == 0;
    }


    public static void main(String[] args) {
        String s1 = "Tact coa";
        String s2 = "abccba";
        String s3 = "abc";
        System.out.println(palinPermu(s1));
        System.out.println(palinPermu(s2));
        System.out.println(palinPermu(s3));
    }
}