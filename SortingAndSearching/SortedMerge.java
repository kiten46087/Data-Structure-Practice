package SortingAndSearching;

public class SortedMerge {
    /* When A has a large enough space to store b, we can start from the end of 
     * A and the end  of B and go to the front.
     */
    public void merge(int[] a, int[] b, int countA, int countB) {
        int indexMergead = countA + countB - 1;
        int indexA = countA - 1;
        int indexB = countB - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMergead] = a[indexA];
                indexA -= 1;
            } else {
                a[indexMergead] = b[indexB];
                indexB -= 1;
            }
            indexMergead -= 1;
        }
    }
}