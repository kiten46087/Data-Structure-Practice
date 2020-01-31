package LinkedList;

public class Partition {
    
    /**
     * Arrange the node in their original order.
     */
    public Node partitionWithOrder(Node head, int d) {
        Node cur = head;
    
        Node before = new Node(0);
        Node after = new Node(0);

        Node beforeP = before;
        Node afterP = after;

        while (cur != null) {
            if (cur.data < d) {
                beforeP.next = new Node(cur.data) ;
                beforeP = beforeP.next;
            } else {
                afterP.next = new Node(cur.data);
                afterP = afterP.next;
            }

            cur = cur.next;
        }

        afterP.next = null;

        beforeP.next = after.next;
        
        return before.next;
    }

    /**
     * Still in doubt  ???????
     * Partition without keeping the original order.
     */
    public Node partitionNoOrder(Node node, int d) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.data < d) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        tail.next = null;
        
        return head;

    }

    public static void main(String[] args) {
        removeDup list = new removeDup();
        Partition par = new Partition();

        Node head = list.generateUnsortedList(10);
        head.printList();

        head = par.partitionNoOrder(head, 4);
        head.printList();
    }
}