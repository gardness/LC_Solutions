public class LC0328 {
    // 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    public ListNode oddEvenList(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddDummy = new ListNode();
        ListNode evenDummy = new ListNode();
        ListNode oddCur = oddDummy;
        ListNode evenCur = evenDummy;
        ListNode cur = head;

        while (cur != null) {
            oddCur.next = cur;
            oddCur = oddCur.next;
            cur = cur.next;

            if (cur != null) {
                evenCur.next = cur;
                evenCur = evenCur.next;
                cur = cur.next;
            }
        }

        evenCur.next = null;
        oddCur.next = evenDummy.next;

        return oddDummy.next;
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    public ListNode oddEvenList1(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode oddCur = oddHead;
        ListNode evenHead = head.next;
        ListNode evenCur = evenHead;
        ListNode cur = head.next.next;

        while (cur != null) {
            oddCur.next = cur;
            oddCur = oddCur.next;
            cur = cur.next;

            if (cur != null) {
                evenCur.next = cur;
                evenCur = evenCur.next;
                cur = cur.next;
            }
        }

        evenCur.next = null;
        oddCur.next = evenHead;

        return oddHead;
    }
}
