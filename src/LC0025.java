public class LC0025 {
    /*      1 -> 2 -> 3 -> 4 -> 5 -> null    k = 2
                                |
                     cur
       |
      prev
            |
           idx
       |
      next

           1 -> null    k = 1
                 |
                cur
           |
          idx
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Corner Case, list has less than k nodes
        int cnt = 0;
        ListNode cur = head;
        while (cur != null && cnt < k) {
            cur = cur.next;
            cnt++;
        }

        if (cnt < k) {
            return head;
        }

        // List has at least k nodes
        ListNode prev = reverseKGroup(cur, k);
        ListNode idx = head;
        ListNode next = null;

        while (cnt-- > 0) {
            next = idx.next;
            idx.next = prev;
            prev = idx;
            idx = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = null;
        ListNode next = new ListNode(5);

        for (int i = 4; i > 0; i--) {
            head = new ListNode(i, next);
            next = head;
        }

        LC0025 solution = new LC0025();

        ListNode res = solution.reverseKGroup(head, 2);
    }
}
