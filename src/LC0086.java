public class LC0086 {
    // 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
    public ListNode partition(ListNode head, int x) {
        // cc
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode lessDummy = new ListNode();
        ListNode lessCur = lessDummy;
        ListNode noLessDummy = new ListNode();
        ListNode noLessCur = noLessDummy;

        while (cur != null) {
            if (cur.val < x) {
                lessCur.next = cur;
                lessCur = lessCur.next;
            } else {
                noLessCur.next = cur;
                noLessCur = noLessCur.next;
            }
            cur = cur.next;
        }

        lessCur.next = noLessDummy.next;
        noLessCur.next = null;

        return lessDummy.next;
    }
}
