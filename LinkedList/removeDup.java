package LinkedList;

import java.util.HashSet;
import java.util.Set;

class removeDup {
    
    /**
     * Remove duplicates element from the
     * LinkedList that start with head node.
     * 
     * THIS METHOD USES EXTRA MEMORY!!!
     */
    Node removeDupSet(Node head) {
        Node newHead = head;
        Node cur = head;

        Set<Integer> set = new HashSet<>();
        set.add(cur.data);

        while (cur.next != null) {
            if (set.contains(cur.next.data)) {
                cur.next = cur.next.next;
            } else {
                set.add(cur.next.data);
                cur = cur.next;
            }
        }

        return newHead;
    }

    /**
     * This aproach uses two pointer which is faster and constant space complexity.
     * However this approach only works on the sorted LinkedList.
     */
    Node removeDupNoSet(Node head) {
        if (head == null) return null;

        Node newHead = head;
        Node cur = head;
        Node temp = head;

        while (cur != null && cur.next != null) {
            while (temp.next.data == cur.data) {
                temp = temp.next;
            }
            cur.next = temp.next;
            cur = cur.next;
            temp = cur;
        }

        return newHead;
    }

    /**
     * This Solution uses two pointers and constant space complexity.
     * But this is for the unsorted list so this time complexity is O(n^2).
     */
    Node removeDupNoSetUnsort(Node head) {
        Node cur = head;

        while (cur != null) {
            Node temp = cur;
            while (temp.next != null) {
                if (temp.next.data == cur.data) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }

        return head;
    }

    /**
     * Test method which being used to generate
     * A unsorted LinkedList with random nodes.
     */
    Node generateUnsortedList(int count) {
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
        removeDup test = new removeDup();

        // Test for removing duplicates nodes inside the LinkedList.

        // Node head = test.generateUnsortedList(10);
        // head.printList();

        // Node newHead = test.removeDup(head);
        // newHead.printList();
    }
}