public class LC0092 {
    // d -> 2 -> 1    NULL, m = 1, n = 2
    // c
    //                 i
    //                 n
    //           p
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // cc
        if (head == null || head.next == null || m == n) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        int cnt = m - 1;
        while (cnt > 0) {
            cur = cur.next;
            cnt--;
        }

        ListNode newTail = cur.next;
        ListNode idx = newTail;
        ListNode prev = cur;
        ListNode next = null;
        cnt = n - m + 1;

        while (cnt > 0 && idx != null) {
            next = idx.next;
            idx.next = cur.next;
            cur.next = idx;
            prev = idx;
            idx = next;
            cnt--;
        }

        newTail.next = idx;

        return dummy.next;
    }

    public static void main(String[] args) {
//        ListNode head = null;
//        ListNode next = new ListNode(5);
//
//        for (int i = 4; i > 0; i--) {
//            head = new ListNode(i);
//            head.next = next;
//            next = head;
//        }
        ListNode tmp = new ListNode(2);
        ListNode head = new ListNode(1, tmp);

        LC0092 solution = new LC0092();
        solution.reverseBetween(head,1, 2);
    }
}
