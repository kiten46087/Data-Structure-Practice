package StackAndQueue;

import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;


public class SlidingPuzzle {
    private static final int[] d = {0, 1, 0, -1, 0}; //  relative displacements of neighbors in board.
    
    private String getTargetS(int[][] board) {
        StringBuilder sb = new StringBuilder();
        int length = board.length * board[0].length;
        for (int i = 0; i < length; i++) {
            sb.append(i);
        }
        return sb.toString();
    }

    public int slidingPuzzle(int[][] board) {
        int height = board.length, width = height == 0 ? 0 : board[0].length;
        // convert board to string - initial state.
        String s = Arrays.deepToString(board).replaceAll("\\[|\\]|,|\\s", ""); // e.g., [[1,2,3],[4,0,5]] -> "123405"
        Queue<String> q = new LinkedList<>(Arrays.asList(s)); // add initial state to queue.
        Set<String> seen = new HashSet<>(q); // used to avoid duplicates
        for (int steps = 0; !q.isEmpty(); ++steps) { // Not traverse all states yet?
            // loop used to control search breadth.
            for (int sz = q.size(); sz > 0; --sz) {
                String str = q.poll();
                if (str.equals(getTargetS(board))) { return steps; } // found target.
                int i = str.indexOf("0"), x = i / width, y = i % width; // board[x][y] is '0'.
                for (int k = 0; k < 4; ++k) { // traverse all options.
                    int r = x + d[k], c = y + d[k + 1]; // board[r][c] is the neighbor of '0'.
                    if (r >= 0 && r < height && c >= 0 && c < width) {
                        char[] ch = str.toCharArray();
                        ch[i] = ch[r * width + c]; // r * width + c is the string index of board[r][c].
                        ch[r * width + c] = '0'; // assign '0' to the neighbor of board[x][y].
                        s = String.valueOf(ch);
                        if (seen.add(s)) q.offer(s); // if not duplicate, add s to the queue.
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SlidingPuzzle sp = new SlidingPuzzle();
        // int[][] test = {{3, 1, 2}, {6, 4, 5}, {9, 7, 8}, {0, 10, 11}};
        int[][] test1 = {{1, 6, 3}, {8, 7, 2}, {4, 0, 5}};

        System.out.println(sp.slidingPuzzle(test1));
    }
}