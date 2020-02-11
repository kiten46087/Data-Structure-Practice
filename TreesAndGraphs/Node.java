package TreesAndGraphs;

import java.util.LinkedList;

public class Node {
    public int val;
    public String name;
    public LinkedList<Node> adjacentList;
    int in;
    int out;
    /* Univisted: -1, visiting: 0. visited: 1 */
    public int state = -1;

    public Node(int val) {
        this.val = val;
        adjacentList = new LinkedList<>();
        in = 0;
        out = 0;
        state = -1;
    }

    public LinkedList<Node> getAdjacentList() {
        return adjacentList;
    }
}