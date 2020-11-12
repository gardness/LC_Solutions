import java.util.HashSet;

public class LC0142 {
    public ListNode detectCycle(ListNode head) {
        // cc
        if (head == null || head.next == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }

        return null;
    }
}
