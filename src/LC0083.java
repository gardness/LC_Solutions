public class LC0083 {
    // 1 -> 2 -> 3 -> 3
    //           p
    //                   c
    public ListNode deleteDuplicates(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (pre.val != cur.val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                while (cur != null && cur.val == pre.val) {
                    cur = cur.next;
                }

                pre.next = cur;
                pre = pre.next;
                if (cur != null) {
                    cur = cur.next;
                }
            }
        }

        return head;
    }

    // 1 -> 2 -> 3 -> 3
    //           p
    //                   c
    public ListNode deleteDuplicates1(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
