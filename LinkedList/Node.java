package LinkedList;

public class Node {
    Node next = null;
    int data;

    public Node (int d) {
        data = d;
    }

    /**
     * Print out the value of the LinkedList for testing
     */
    public void printList() {
        Node cur = this;
        while (cur.next != null) {
            System.out.print(cur.data +  " ");
            cur = cur.next;
        }
        System.out.print(cur.data +  " ");
        System.out.println();
    }

    /**
     * Add a node with value d to the tail of the LinkedList
     */
    public void addLast(int d) {
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
    public Node deleteNode(Node head, int d) {
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


    /**
     * Delete the node between the head node and tail node and return the head node.
     */
    public void delMidNode(Node middle) {
        Node cur = this;

        while (cur.next != null) {
            if (cur.next.data == middle.data) {
                cur.next = cur.next;
                break;
            }
            cur = cur.next;
        }

    }
}