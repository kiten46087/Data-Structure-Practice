package LinkedList;

public class Palindrome {
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd situation.
        if (fast != null) {
            slow = slow.next;
        }

        Node newList = reverse(slow);
        while (newList != null) {
            if (newList.data != head.data) {
                return false;
            } else {
                newList = newList.next;
                head = head.next;
            }
        }
        
        return true;
    }

    /**
     * Return the reversed version of the head node.
     */
    public Node reverse(Node head) {
        Node cur = head;
        Node prev = null;

        while (cur != null) {
            Node temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}