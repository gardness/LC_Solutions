import java.util.HashSet;

public class LC0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // cc
        if (headA == null || headB == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<>();

        while (headA != null && headB != null) {
            if (set.contains(headA)) {
                return headA;
            } else {
                set.add(headA);
                headA = headA.next;
            }

            if (set.contains(headB)) {
                return headB;
            } else {
                set.add(headB);
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (set.contains(headA)) {
                return headA;
            } else {
                set.add(headA);
                headA = headA.next;
            }
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                set.add(headB);
                headB = headB.next;
            }
        }

        return null;
    }

    // 1, 3, 5, 7, 9, 11
    //             p2
    // 2, 4, 9, 11
    //       p1
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // cc
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            p1 = p1 != null ? p1.next : headB;
            p2 = p2 != null ? p2.next : headA;
        }

        return p1;
    }
}
