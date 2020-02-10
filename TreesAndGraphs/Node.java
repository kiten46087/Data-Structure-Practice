package TreesAndGraphs;

import java.util.LinkedList;

public class Node {

    public String name;
    public LinkedList<Node> adjacent;
    /* Univisted: -1, visiting: 0. visited: 1 */
    public int state = -1;

    public LinkedList<Node> getAdjacentList() {
        return adjacent;
    }
}