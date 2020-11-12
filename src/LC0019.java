public class LC0019 {
    // 1 -> 2 -> 3 -> 4 -> 5 -> null  2
    //           l
    //                     r
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Corner Case
        if (head.next == null) {
            return null;
        }

        ListNode cur = head;
        ListNode next = head;
        while (n > 0 && next.next != null) {
            next = next.next;
            n--;
        }

        if (n != 0) {
            return head.next;
        } else {
            while (next != null && next.next != null) {
                next = next.next;
                cur = cur.next;
            }

            cur.next = cur.next.next;

            return head;
        }
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> null  1
    //                l
    //                     r
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // cc
        if (n > lengthOfList(head)) {
            throw new IllegalArgumentException();
        }

        ListNode l = head;
        ListNode r = head;

        while (n > 0 && r != null) {
            r = r.next;
            n--;
        }

        if (r == null) {
            return head.next;
        }

        while (r.next != null) {
            l = l.next;
            r = r.next;
        }

        l.next = l.next.next;
        return head;
    }

    private int lengthOfList(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            cnt++;
        }

        return cnt;
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> null
    //      s
    //                f
    public ListNode findMid1(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // dummy
    public ListNode findMid2(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // s = 0, f = 1 (an alternative to dummy node approach)
    public ListNode findMid3(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode prev = head;
        for (int i = 2; i < 5; i++) {
            ListNode cur = new ListNode(i);
            prev.next = cur;
            prev = prev.next;
        }
        System.out.println(head.toString(head));

        LC0019 solution = new LC0019();
        solution.removeNthFromEnd(head, 2);
//        System.out.println(solution.findMid1(head).val);
//        System.out.println(solution.findMid2(head).val);
//        System.out.println(solution.findMid3(head).val);
    }
}
