package LinkedList;

public class Intersection {
    /**
     * Return the node where list1 and list2 intersect.
     */
    public Node intersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;

            if (p1 == null && p2 == null) return null;
            else if (p1 == null) p1 = head2;
            else if (p2 == null) p2 = head1;
        }

        return p1;
    }


    /* This method first finds the length and then compare. 
        This method is from the CC189.
    */
    public Node findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;

        InterResult r1 = getTailAndSize(head1);
        InterResult r2 = getTailAndSize(head2);

        if (r1.tail != r2.tail) return null;

        Node shorter = r1.size < r2.size ? head1 : head2;
        Node longer = r1.size < r2.size ? head2 : head1; 

        /* This line reduce the long linkedlist to the same length of the short list. */
        longer = getKthNode(longer, Math.abs(r1.size - r2.size));

        while (longer != shorter) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }


    /* Helper method that reduce the length of head. */
    private Node getKthNode(Node head, int size) {
        Node cur = head;
        while (size > 0 && cur != null) {
            cur = cur.next;
            size -= 1;
        }
        return cur;
    }

    /* Helper method to get the tail and size inside a wrapper class. */
    private InterResult getTailAndSize(Node head) {
        if (head == null) return null;

        int size = 1;
        Node cur = head;
        while (cur.next != null) {
            size += 1;
            cur = cur.next;
        }

        return new InterResult(cur, size);
    }
}


/**
 * This is the wrapper class that contains the tail and the length of the list.
 */
class InterResult {
    public Node tail;
    public int size;
    public InterResult(Node tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}