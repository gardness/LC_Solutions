import java.util.List;
import java.util.PriorityQueue;

public class LC0023 {
    //  1->4->5,
    //  1->3->4,
    //  2->6
    public ListNode mergeKLists(ListNode[] lists) {
        // cc
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((x, y) -> x.val - y.val);

        for (ListNode l : lists) {
            if (l != null) {
                pq.offer(l);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            cur.next = tmp;
            cur = cur.next;

            if (tmp.next != null) {
                pq.offer(tmp.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);

        m1.next = m2;
        m2.next = m3;

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(6);

        l1.next = l2;

        ListNode[] lists = {n1, m1, l1};
        LC0023 solution = new LC0023();
        solution.mergeKLists(lists);
    }
}
