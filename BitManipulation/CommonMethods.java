package BitManipulation;

public class CommonMethods {
    /* Get the certain bit of the number. */
    public boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    /* Set the certain(ith) bit of the number to 1 and return the number. */
    public int setBit(int num, int i) {
        return num | (1 << i);
    }

    /* Set the certain(ith) bit of the number to 0 and return the number. */
    public int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return mask & num;
    }

    /* We can also clear the bits from most significant bit to i, or ith bit to 0. */
    /* (1 << i) get 0001000
     * (1 << i) - 1 get 0000111 (clear the MSB to ith)
     * 
     * (-1 << i) get 1110000 (chear the ith bits to 0.)
     */
}