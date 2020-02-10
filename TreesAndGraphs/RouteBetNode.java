package TreesAndGraphs;

import java.util.LinkedList;

public class RouteBetNode {
    public static final int UNIVISTED = -1;
    public static final int VISITING = 0;
    public static final int VISITED = -1;
    // enum State {visited, unvisited, visiting};

    /* BFS Approach. */
    public boolean routeBetNode(Graph g, Node start, Node end) {
        if (start == end) return true;
        
        LinkedList<Node> q = new LinkedList<>();

        /* Initialize all nodes to unvisited. */
        for (Node u : g.getNodes()) {
            u.state = UNIVISTED;
        }

        start.state = VISITING;
        q.add(start);

        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.getAdjacentList()) {
                    if (v.state == UNIVISTED) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = VISITING;
                            q.add(v);
                        }
                    }
                }
                u.state = VISITED;
            }
        }

        return false;    
    }
}