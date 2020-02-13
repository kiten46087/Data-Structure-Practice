package BitManipulation;

public class PairwiseSwap {
    /* Swap odd and even number, bit 0 and bit 1, bit 2 and bit 3. extra.....*/
    /* Using bit mask. */
    public int pairwiseSwap(int x) {
        return ( ((x & 0xaaaaaaaa) >>> 1 | ((x & 0x55555555) << 1)) );
    }
}