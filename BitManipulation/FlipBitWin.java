package BitManipulation;

import java.util.ArrayList;

public class FlipBitWin {
    /* Flip one bit from 0 to 1 and get the longest 1s sequence. 
     * This Solution is brute force but easier to understand.
     * This solution Time complexity is O(b) b is the length of the bits
     * However it needs extra space usage.
     */
    public int flipBits(int n) {
        if (n == -1) return Integer.BYTES * 8;
        ArrayList<Integer> sequence = getAlternateSequence(n);
        return findLongestSequence(sequence);
    }

    /* This version uses small O(1) space complexity. */
    public int flipBitsSmall(int a) {
        if (~a == 0) return Integer.BYTES * 8;

        int currentLength = 0;
        int prevLength = 0;
        int maxLength = 1;

        while (a != 0) {
            if ((a & 1) == 0) {
                // Current bit is 1.
                currentLength += 1;
            } else if ((a & 1) == 0) {
                // Current bit is 0
                // Update to 0 if next bit is 0, to currentLength if next bit is 1
                prevLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(prevLength + currentLength + 1, maxLength);
            a >>>= 1;
        }
        return maxLength;
    }

    /* Pirvate helper convert the integer bits sequences to another sequence. */
    private ArrayList<Integer> getAlternateSequence(int n) {
        ArrayList<Integer> sequences = new ArrayList<>();

        int searchingFor = 0;
        int counter = 0;

        for (int i = 0; i < Integer.BYTES; i++) {
            if ((n & 1) != searchingFor) {
                sequences.add(counter);
                searchingFor = n & 1;
                counter = 0;
            }
            counter += 1;
            n >>>= 1;
        }
        
        sequences.add(counter);

        return sequences;
    }

    /* Acutally find the longest sequence using merging the prev and next sequence. */
    private int findLongestSequence(ArrayList<Integer> seq) {
        int maxSeq = 1;

        for (int i = 0; i < seq.size(); i += 2) {
            int zeroSeq = seq.get(i);
            int onesSeqPrev = i - 1 >= 0 ? seq.get(i - 1) : 0;
            int onesSeqNext = i + 1 < seq.size() ? seq.get(i + 1) : 0;

            int thisSeq = 0;
            if (zeroSeq == 1) {
                // Can Merge
                thisSeq = onesSeqPrev + 1 + onesSeqNext;
            } else if (zeroSeq > 1) {
                // Just add a one to either side.
                thisSeq = 1 + Math.max(onesSeqPrev, onesSeqNext);
            } else if (zeroSeq == 0) {
                // No zero, take either side.
                thisSeq = Math.max(onesSeqPrev, onesSeqNext);
            }
            maxSeq = Math.max(thisSeq, maxSeq);
        }

        return maxSeq;
    }
}