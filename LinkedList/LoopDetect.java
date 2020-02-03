package LinkedList;

public class LoopDetect {
    public boolean loopDetect(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }

        return false;
    }
}