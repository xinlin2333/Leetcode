package Top100;

public class removeNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            x = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode start = head;
        ListNode end = head;
        while (n > 0) {
            end = end.next;
        }
        if (end.next == null) {
            return head.next;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return head;
    }
}
