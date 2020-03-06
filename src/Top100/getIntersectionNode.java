package Top100;

public class getIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (a.next != null) {
            len1++;
            a = a.next;
        }
        while (b.next != null) {
            len2++;
            b = b.next;
        }
        if (len1 > len2) {
            int dis = len1 - len2;
            while (dis > 0) {
                headA = headA.next;
                dis--;
            }
        } else if (len1 < len2) {
            int dis = len2 - len1;
            while (dis > 0) {
                headB = headB.next;
                dis--;
            }
        }
        while (headA != null && headB != null) {
            if (headB == headA) {
                return headB;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 解法二：将A、B分别切分成Aleft+Aright+Bleft = Bleft+Bright+Aleft;
     * 如果存在公共部分：那么就有等式成立：Aleft+common+Bleft = Bleft+common+Aleft
     */
    public ListNode getCommon(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (true) {
            if (a == null && b == null) {
                return null;
            }
            if (a == null) {
                a = b;
            }
            if (b == null) {
                b = a;
            }
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
    }
}
