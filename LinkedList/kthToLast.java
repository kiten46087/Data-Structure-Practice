package LinkedList;

class kthToLast {

    /**
     * This iterative solution returns the node. 
     * Which is O(1) space complexity and O(n) time complexity
     */
    Node getKthToLastIterative(Node head, int k) {
        if (head == null) return null;

        Node fast = head;
        Node slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /**
     * When we don't need to RETURN the node rather, we 
     * just need to print the value of this node we can easily use the recrusive method.
     */
    int printKthToLast(Node head, int k) {
        if (head == null) return 0;

        int index = printKthToLast(head.next, k) + 1;
        if (index == k)
            System.out.println("The kth to last element is " + head.data);

        return index;
    }

}