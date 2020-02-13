package BitManipulation;

public class NextNumber {
    /**
     * print the next largest and smallest number have the same number
     * of 1 bits in the binary repreentation.
     * My dumb solution brute force
     */
    public void getNextLS(int n) {
        int number = Integer.bitCount(n);

        boolean firstEncounter = false;
        // boolean lastEncounter = false;

        int first = 0;
        int last = 0;

        for (int i = n + 1; n < Integer.MAX_VALUE; i++) {
            if (Integer.bitCount(i) == number && !firstEncounter) {
                firstEncounter = true;
                first = i;
            } else if (Integer.bitCount(i) == number && firstEncounter) {
                last = i;
            }
        }

        System.out.println(first);
        System.out.println(last);
    } 

    /** Bit manipulation approach, flip a right-most non-trailing zero to 1 and flip a 1 to 0 on the right. 
     * (Re-arange the bits on the right) with one lesser 1 bit .
     */
    public int getNext(int n) {
        // Computer c0 and c1
        int c = n;
        int c0 = 0;
        int c1 = 0;

        while (((c & 1) == 0) && (c != 0)) {
            c1 += 1;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1 += 1;
            c >>= 1;
        }

        // Check error when overflow
        if (c0 + c1 == 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1; // Position of the rightmost non-trailing zero
        n |= (1 << p); // Flip that bit
        n &= ~((1 << p) - 1); // Clear all bits to the right of p.
        n |= (1 << (c1 - 1)) - 1; // Insert (c1 - 1) ones on the right.

        return n;
    }


    /**
     * Similar approach, set the rigthmost non-trailing 1 to 0, and clear all the bits to the right of p
     * Then insert (c1 + 1) bits to the right of p.
     */
    public int getPrev(int n) {
        int temp = n;
        int c0 = 0;
        int c1 = 0;
        while ((temp & 1) == 1) {
            c1 += 1;
            temp >>= 1;
        }

        if (temp == 0) return -1;

        while (((temp & 1) == 0) && (temp != 0)) {
            c0 += 1;
            temp >>= 1;
        }

        
        int p = c0 + c1; // Rightmost non-trailing one.
        System.out.println("The position of p is " + p);
        n &= ((~0) << (p + 1)); // Clears from bit p onwards.
        
        /* Insert (c1 + 1) to the right. */
        int mask = (1 << (c1 + 1)) - 1;  
        n |= mask << (c0 - 1);

        return n;
    }

    public static void main(String[] args) {
        NextNumber nn = new NextNumber();
        // nn.getNextLS(5); 

        System.out.println(nn.getPrev(6));
    }
}