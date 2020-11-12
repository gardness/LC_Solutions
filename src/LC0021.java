public class LC0021 {
    // With dummy
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // cc
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return dummy.next;
    }


    // Without dummy
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // cc
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head = null;

        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode cur = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 != null) {
            cur.next = l1;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        return head;
    }


    // Recursion
    // [1,2,4]
    // [1,3,4]

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // Corner Case & Base Case
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
        }

        return l1.val < l2.val ? l1 : l2;
    }
}
