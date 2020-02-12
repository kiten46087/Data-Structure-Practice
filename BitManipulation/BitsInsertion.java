package BitManipulation;

public class BitsInsertion {
    /* My Solution set or clear the bit one by one */
    public int bitsInsertion(int N, int M, int i, int j) {
        while (M != 0) {
            int end = M & 1;
            if (end == 1) {
                N |= (1 << j);
            } else if (end == 0) {
                N &= ~(1 << j);
            }
            j -= 1;
            M >>= 1;
        }
        return N;
    }

    /* Solution provided by CC 189. Set the bits between i and j to 0. Then shift the M and merge with N. */
    public int update(int n, int m, int i, int j) {
        if (i > j || i < 0 || j >= 32) return 0;

        // Create a mask
        int allOnes = ~0;

        // left mask
        int left = j  <31 ? (allOnes << (j + 1)) : 0;

        // right mask
        int right = ((1 << i) - 1);

        // Actually creating the mask.
        int mask = left | right;

        // Shift the m to position.
        int m_shifted = m << i;

        // Clear bits using the mask on n.
        int n_cleared = n % mask;

        return n_cleared | m_shifted;
    }

    public static void main(String[] args) {
        BitsInsertion test = new BitsInsertion();
        
        System.out.println(Integer.toBinaryString(512));
        System.out.println(Integer.toBinaryString(19));

        int result = test.bitsInsertion(512, 19, 2, 6);
        System.out.println(Integer.toBinaryString(result));
    }
}