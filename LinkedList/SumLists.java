package LinkedList;

public class SumLists{
    /**
     * Get the sum LinkedList using the recursive way.
     */
    public Node sumListsR(Node n1, Node n2, int carry) {
        if (n1 == null && n2 == null) {
            if (carry == 0) return null;
            else return new Node(carry);
        }

        int sum = carry;
        sum = (n1 == null) ? sum : sum + n1.data;
        sum = (n2 == null) ? sum : sum + n2.data;

        carry = sum / 10;
        sum = sum % 10;

        Node node = new Node(sum);
        if (n1 == null)  
            node.next = sumListsR(n1, n2.next, carry);
        else if (n2 == null)
            node.next = sumListsR(n1.next, n2, carry);
        else
            node.next = sumListsR(n1.next, n2.next, carry);
        return node;
        
    }

    /**
     * Get the sum LinkedList using the iterative way.
     */
    public Node sumLists(Node n1, Node n2) {
        Node head = new Node(0);
        Node cur = head;

        Node p1 = n1;
        Node p2 = n2;
        int carry = 0;


        while (p1 != null || p2 != null) {
            int value1 = (p1 == null) ? 0 : p1.data;
            int value2 = (p2 == null) ? 0 : p2.data;

            int sum = carry + value1 + value2;

            cur.next = new Node(sum % 10);
            cur = cur.next;

            carry = sum / 10;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if (carry > 0) {
            cur.next = new Node(carry);
        }

        return head.next;
    }

     /**
     * Test method which being used to generate
     * A unsorted LinkedList with random nodes.
     */
    public Node generateUnsortedList(int count) {
        Node head = new Node((int) (Math.random() * 10));
        Node cur = head;
        
        while (count > 1) {
            cur.next = new Node((int) (Math.random() * 10));
            cur = cur.next;
            count -= 1;
        }
        
        return head;
    }

    public static void main(String[] args) {
        SumLists helperMethod = new SumLists();
        Node list1 = helperMethod.generateUnsortedList(6);
        Node list2 = helperMethod.generateUnsortedList(3);

        list1.printList();
        list2.printList();

        Node result = helperMethod.sumListsR(list1, list2, 0);
        result.printList();
    }
}