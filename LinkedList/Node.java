package LinkedList;

class Node {
    Node next = null;
    int data;

    public Node (int d) {
        data = d;
    }

    /**
     * Add a node with value d to the tail of the LinkedList
     */
    void addLast(int d) {
        Node end = new Node(d);
        Node cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = end;
    }

    /**
     * Delete the node with valued from the LinkedList start with head.
     * And return the head of the new LinkedList.
     */
    Node deleteNode(Node head, int d) {
        if (head == null) return null;

        Node cur = head;
        if (cur.data == d) return cur.next;

        while (cur.next != null) {
            if (cur.next.data == d) {
                cur.next = cur.next.next;
                return head;
            }
            cur = cur.next;
        }

        return head;
    }
}