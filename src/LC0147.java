import java.util.List;

public class LC0147 {
    // -1    5    3 -> 4 -> 0
    //       c
    //  i
    //  Without dummy
    public ListNode insertionSortList(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode retHead = head;
        ListNode cur = head.next;
        ListNode idx = head;
        ListNode pre = null;

        retHead.next = null;

        while (cur != null) {
            pre = null;
            idx = retHead;

            while (idx != null) {
                if (cur.val < idx.val && idx == retHead) {
                    retHead = cur;
                    ListNode tmp = cur.next;
                    cur.next = idx;
                    cur = tmp;
                    break;                                  //  Could also be idx = idx.next;
                } else if (cur.val >= idx.val && idx.next != null) {
                    pre = idx;
                    idx = idx.next;
                } else if (cur.val < idx.val) {
                    ListNode tmp = cur.next;
                    cur.next = idx;
                    pre.next = cur;
                    cur = tmp;
                    break;
                } else if (cur.val >= idx.val && idx.next == null){
                    ListNode tmp = cur.next;
                    cur.next = idx.next;
                    idx.next = cur;
                    cur = tmp;
                    break;                                  //  Could also be idx = idx.next;
                }
            }
        }

        return retHead;
    }

    // -1 -> 5 -> 3 -> 4 -> 0
    // With dummy
    public ListNode insertionSortList1(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode cur = head;

        while (cur != null) {
            ListNode pre = dummy;
            ListNode idx = dummy.next;

            while (idx != null) {
                if (cur.val > idx.val) {
                    break;
                } else {
                    pre = idx;
                    idx = idx.next;
                }
            }

            ListNode tmp = cur.next;
            cur.next = idx;
            pre.next = cur;
            cur = tmp;
        }

        return dummy.next;
    }

    // 1 -> 2 -> 3 -> 5 -> null    4
    public ListNode insert(ListNode head, int value) {
        // cc
        ListNode tmp = new ListNode(value);
        if (head == null || value < head.val) {
            tmp.next = head;
            return tmp;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && cur.val < value) {
            pre = cur;
            cur = cur.next;
        }

        if (cur == null) {
            pre.next = tmp;
        } else {
            tmp.next = cur;
            pre.next = tmp;
        }

        return head;
    }

    // 1 -> 2 -> 3 -> 5 -> null    4
    // Without dummy, template from class
    public ListNode insert1(ListNode head, int value) {
        // cc
        ListNode tmp = new ListNode(value);
        if (head == null || value < head.val) {
            tmp.next = head;
            return tmp;
        }

        ListNode pre = head;
        while (pre.next != null || value > pre.next.val) {
            pre = pre.next;
        }

        tmp.next = pre.next;
        pre.next = tmp;

        return head;
    }

    // 1 -> 2 -> 3 -> 5 -> null    4
    // With dummy, template from class
    public ListNode insert2(ListNode head, int value) {
        ListNode tmp = new ListNode(value);
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null && value > cur.val) {
            pre = cur;
            cur = cur.next;
        }

        tmp.next = cur;
        pre.next = tmp;

        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        ListNode tmp = new ListNode();

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        LC0147 solution = new LC0147();
        solution.insertionSortList1(n1);
    }
}
