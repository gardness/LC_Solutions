public class LC0203 {
    // 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6, val = 6
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
