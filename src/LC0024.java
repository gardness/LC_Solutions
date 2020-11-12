public class LC0024 {
    public ListNode swapPairs(ListNode head) {
        // Corner Case & Base Case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode ret = swapPairs(next.next);
        next.next = head;
        head.next = ret;

        return next;
    }
}
