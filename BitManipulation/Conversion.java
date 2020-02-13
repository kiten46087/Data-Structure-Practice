package BitManipulation;

public class Conversion {
    /**
     * My stupid version of comparing different bits.
     */
    public int conversion(int n, int m) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            int nEnd = n & 1;
            int mEnd = m & 1;
            if (nEnd != mEnd) {
                count += 1;
            }
            n = n >>> 1;
            m = m >>> 1; 
        }
        return count;
    }

    /**
     * A clearer version of comparing different bits using XOR.
     */
    public int bitsSwapRequired(int m, int n) {
        int count = 0;
        int c = m ^ n;
        while (c != 0) {
            count += (c & 1);
            c >>>= 1;
        }
        return count;
    }

    /**
     * A optimized version of comparing different bits using XOR.
     * This version find the number of count quicker.
     */
    public int bitsSwapRequiredOptimized(int m, int n) {
        int count = 0;
        int c = m ^ n;
        while (c != 0) {
            c = c & (c - 1);
            count += 1;
        }
        return count;
    }
}