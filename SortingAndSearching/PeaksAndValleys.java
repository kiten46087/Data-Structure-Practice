package SortingAndSearching;

import java.util.Arrays;

public class PeaksAndValleys {
    // Naive solution sort the array first and then swap every two elements.
    public void sortValleyPeak(int[] array) {
        Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {
            swap(array, i - 1, i);
        }
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    // Faster approach swap the middle one with the largest on its left and right side.
    public void sortValleyPeak2 (int[] array) {
        for (int i = 1; i < array.length; i++) {
            int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if (i != biggestIndex) {
                swap(array, i, biggestIndex);
            }
        }
    }

    public int maxIndex(int[] array, int a, int b, int c) {
        int len = array.length;
        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (aValue == max) return a;
        else if (bValue == max) return b;
        else return c;
    }
}