package LinkedList;

public class DelMidNode {

    /**
     * Only get access to the node, cannot get access to the head node.
     * return nothing. the original list has already been changed.
     */
    public void delMidNode(Node middle) {
        if (middle == null) return;

        // The middle node cannot be the last node.
        if (middle.next == null) return;

        middle.data = middle.next.data;
        middle.next = middle.next.next;
        
    }
}