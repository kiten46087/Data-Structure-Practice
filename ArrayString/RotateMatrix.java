package ArrayString;

public class RotateMatrix {
    /**
     * Rotate the matrix by 90 degree in place.
     * One way to do this is to rotate the matrix by layer and 
     * starting from the outer layer to the inner layer.
     */
    public boolean rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top.

                // left to top
                matrix[first][i] = matrix[last - offset][first];

                // bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // top to right
                matrix[i][last] = top; 
            }
        }

        return true;
    }

    /**
     * This is a more tricky solution
     * which involves transpose and change the left and right of the matrix.
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
        // left and right the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}