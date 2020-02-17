package RecursionAndDp;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotGrid {
    /* My Solution for the robot grid when seeing the obstacles. */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] matrix = new int[row][col];
        
        // Initialize the first row
        boolean rowObstacle = false;
        for (int i = 0; i < col; i++) {
            if (obstacleGrid[0][i] == 1)
                rowObstacle = true;
            if (!rowObstacle) {
                matrix[0][i] = 1;        
            } else {
                matrix[0][i] = 0;
            }
        }
        
        // Initialize the first column
        boolean colObstacle = false;
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1)
                colObstacle = true;
            if (!colObstacle) {
                matrix[i][0] = 1;        
            } else {
                matrix[i][0] = 0;
            }
        }
        
        
        // DP
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    matrix[i][j] = 0;
                    continue;
                }
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        
        return matrix[row - 1][col - 1];
    }

    /* cc189 Solution for just finding the path and add the point along the way. */
    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<Point>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }

        return null;
    }

    boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoint) {
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }

        Point p = new Point(row, col);

        if (failedPoint.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoint) || getPath(maze, row - 1, col, path, failedPoint)) {
            path.add(p);
            return true;
        }

        failedPoint.add(p);
        return false;
    }

}

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}