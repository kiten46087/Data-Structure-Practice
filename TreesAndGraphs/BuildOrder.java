package TreesAndGraphs;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class BuildOrder {
    List<Node> nodes = new ArrayList<>();

    // Add all new nodes. Helper method.
    public void initializeNodes(int num) {
        for (int i = 0; i < num; i++) {
            nodes.add(new Node(i));
        }
    }
    
    
    // Connect the nodes. Helper method.
    public void connectNodes(int[][] pairs) {
        for (int i = 0; i < pairs.length; i++) {
            int from = pairs[i][1];
            int to = pairs[i][0];
            nodes.get(from).out += 1;
            nodes.get(to).in += 1;
            
            nodes.get(from).adjacentList.add(nodes.get(to));
        }
    }
    
    /* My Solution using extra nodes, but we can still use two array like in array and out array to check. */
    /* !!!!!!!! We don't acutally needs the out array!!!!!!! */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        initializeNodes(numCourses);
        connectNodes(prerequisites);
        
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> q = new LinkedList<>();
        
        // Get the starting nodes with 0 input and add them to the queue.
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).in == 0) {
                q.add(nodes.get(i));
                res.add(nodes.get(i).val);
            }
        }
        
        
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (Node v : u.adjacentList) {
                    if (v.state == -1 && v.in == 1) {
                        res.add(v.val);
                        v.state = 0;
                        q.add(v);
                    }
                    
                    if (v.state == -1 && v.in != 1) {
                        v.in -= 1;
                    }
                }
                u.state = 1;
            }
        }
        
        // The case when it is impossible to finish all courses.
        if (res.size() != numCourses) {
            return new int[] {};
        }
        
        // Transfter the arrayList to arary and return the array.
        int[] ret = new int[res.size()]; 
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        
        return ret;
    }
}

