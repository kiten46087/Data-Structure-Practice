package RecursionAndDp;

public class MagicIndex {
    /* My iterative approach. */
    public int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) return i;
        }
        return -1;
    }
    
    /** 
     * Assuming that the array elements are all distinct and sorted.
     */
    public int magicFast(int[] array) {
        return magicFastHelper(array, 0, array.length);
    }

    public int magicFastHelper(int[] array, int start, int end) {
        if (end < start) {
            return -1;
        } 
        int mid = start + (end - start) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFastHelper(array, start, mid - 1);
        } else {
            return magicFastHelper(array, mid + 1, end);
        }
    } 

    /**
     * This solution is about the case when there can be repeated numbers.
     */
    public int magicFastRepeat(int[] array) {
        return magicFastRepeatHelper(array, 0, array.length - 1);
    }


    public int magicFastRepeatHelper(int[] array, int start, int end) {
        if (end < start) return -1;

        int midIndex = (start + end) / 2;
        int midValue = array[midIndex];
        if (midValue == midIndex) return midIndex;

        // Search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFastRepeatHelper(array, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        // Search right 
        int rightIndex = Math.max(midIndex - 1, midValue);
        int right = magicFastRepeatHelper(array, rightIndex, end);
        
        return right;
    }
}