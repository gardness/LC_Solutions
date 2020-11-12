public class LC0369 {
    // 1, 2, 3
    public ListNode plusOne(ListNode head) {
        // cc
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        boolean carry = helper(dummy.next);

        if (carry == true) {
            ListNode tmp = new ListNode(1);
            tmp.next = head;
            dummy.next = tmp;
        }

        return dummy.next;
    }

    // 1, 2, 3
    public boolean helper(ListNode head) {
        // cc
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            if (head.val == 9) {
                head.val = 0;
                return true;
            } else {
                head.val++;
                return false;
            }
        }

        boolean carry = helper(head.next);

        if (carry == true) {
            if (head.val == 9) {
                head.val = 0;
                return true;
            } else {
                head.val++;
                return false;
            }
        }

        return false;
    }
}