import java.util.*;

public class LC0206 {

    // 1 <- 2 <- 3
    public ListNode reverseList(ListNode head) {
        // Corner Case
        if (head == null || head.next == null) {
            return head;
        }

        // Remember to use return value to keep track of the new head
        ListNode newHead = reverseList(head.next);
        ListNode succ = head.next;
        succ.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

    }
}
