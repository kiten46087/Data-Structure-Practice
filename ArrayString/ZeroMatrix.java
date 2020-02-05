package ArrayString;

import java.util.ArrayList;

public class ZeroMatrix {

    /**
     * This solution use a boolean array of row as well as column to store the 
     * row and col that should be set to 0.
     * And this method uses about O(N) space.
     * 
     * !!!!!!!!
     * We can also reduce the space by using the first col and the first row as a replacement
     * for the below row and col boolean array.
     * 
     * 1. We need to check whether the first row and first col has 0
     * 2. Set the first row and first col accoring to the array
     * 3. Set the first col and first row.
     * 
     * Details Check the CC189
     */
    public void setZerosN(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        // Store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Nullify rows
        for (int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        // Nulify cols
        for (int i = 0; i < col.length; i++) {
            if (col[i]) nullifyCol(matrix, i);
        }
    }

    /**
     * Nullify the row-th index of the matrix row.
     */
    public void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++)
            matrix[row][j] = 0;
    }


    /**
     * Nullify the col-th index of the matrix col.
     */
    public void nullifyCol(int[][] matrix, int col) {
        for (int j = 0; j < matrix.length; j++)
            matrix[j][col] = 0;
    }


    /**
     * This method uses a wrapper class and arrayList to store the point where the 
     * zero appears inside the matrix. 
     */
    public void zeroMatrix(int[][] matrix) {
        ArrayList<Point> list = new ArrayList<>();

        // Remember all the points inside the array.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) list.add(new Point(i, j));
            }
        }

        // Extract the point and set all zeros
        for (int i = 0; i < list.size(); i++) { 
            int x = list.get(i).x;
            int y = list.get(i).y;
            setZeros(matrix, x, y);
        }
    }

    /**
     * Helper method set rows and cols of a certain point of x and y.
     */
    public void setZeros(int[][] matrix, int x, int y) {
        // Set row
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[x][i] = 0;
        }

        // Set col
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][y] = 0;
        }
    }
}

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}