import java.util.List;

public class LC0143 {
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7-> null
    public void reorderList(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return;
        }

        // find mid
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode secHead = reverseList(slow.next);
        slow.next = null;

        // merge two list
        mergeLists(head, secHead);
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode post = null;

        while (cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }

        return pre;
    }

    // 1 -> 2
    // 5 -> 4 -> 3
    private void mergeLists(ListNode fHead, ListNode sHead) {
        ListNode sPre = null;
        while (fHead != null && sHead != null) {
            ListNode fNext = fHead.next;
            ListNode sNext = sHead.next;
            fHead.next = sHead;
            sHead.next = fNext;
            sPre = sHead;
            fHead = fNext;
            sHead = sNext;
        }

        sPre.next = sHead;
    }
}
