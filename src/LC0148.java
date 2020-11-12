public class LC0148 {
    // -1 -> 5 -> 3 -> 4 -> 0
    // Top Bottom Merge Sort, Recursion
    public ListNode sortList(ListNode head) {
        // Corner Case && Base Case
        if (head == null || head.next == null) {
            return head;
        }

        // find the mid
        ListNode mid = findMid(head);
        ListNode sHead = mid.next;
        mid.next = null;

        // sort first half
        ListNode fHead = sortList(head);

        // sort second half
        sHead = sortList(sHead);

        // merge both
        head = mergeLists(fHead, sHead);

        return head;
    }

    // -1 -> 5 -> 3 -> 4 -> 0
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // -1 -> 5
    //  0 -> 3 -> 4

    private ListNode mergeLists(ListNode fHead, ListNode sHead) {   //TODO: without dummy
        ListNode head = null;
        ListNode cur = head;

        while (fHead != null && sHead != null) {
            if (cur == null) {
                if (fHead.val < sHead.val) {
                    head = fHead;
                    cur = head;
                    fHead = fHead.next;
                } else {
                    head = sHead;
                    cur = head;
                    sHead = sHead.next;
                }
            } else {
                if (fHead.val < sHead.val) {
                    cur.next = fHead;
                    cur = cur.next;
                    fHead = fHead.next;
                } else {
                    cur.next = sHead;
                    cur = cur.next;
                    sHead = sHead.next;
                }
            }
        }

        if (fHead != null) {
            cur.next = fHead;
        }

        if (sHead != null) {
            cur.next = sHead;
        }

        return head;
    }

    // -1 -> 5
    //  0 -> 3 -> 4

    private ListNode mergeLists1(ListNode fHead, ListNode sHead) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (fHead != null && sHead != null) {
            if (fHead.val < sHead.val) {
                cur.next = fHead;
                cur = cur.next;
                fHead = fHead.next;
            } else {
                cur.next = sHead;
                cur = cur.next;
                sHead = sHead.next;
            }
        }

        if (fHead != null) {
            cur.next = fHead;
        }

        if (sHead != null) {
            cur.next = sHead;
        }

        return dummy.next;
    }


    // -1 -> 5 -> 3 -> 4 -> 0
    // Bottom Up Merge Sort, Iteration
    ListNode tail = new ListNode();
    ListNode nextSubList = new ListNode();

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int n = getCount(head);
        ListNode start = head;
        ListNode dummyHead = new ListNode();
        for (int size = 1; size < n; size = size * 2) {
            tail = dummyHead;
            while (start != null) {
                if (start.next == null) {
                    tail.next = start;
                    break;
                }
                ListNode mid = split(start, size);
                merge(start, mid);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }

    ListNode split(ListNode start, int size) {
        ListNode midPrev = start;
        ListNode end = start.next;
        //use fast and slow approach to find middle and end of second linked list
        for (int index = 1; index < size && (midPrev.next != null || end.next != null); index++) {
            if (end.next != null) {
                end = (end.next.next != null) ? end.next.next : end.next;
            }
            if (midPrev.next != null) {
                midPrev = midPrev.next;
            }
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        nextSubList = end.next;
        end.next = null;
        // return the start of second linked list
        return mid;
    }

    void merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode newTail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                list1 = list1.next;
                newTail = newTail.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
                newTail = newTail.next;
            }
        }
        newTail.next = (list1 != null) ? list1 : list2;
        // traverse till the end of merged list to get the newTail
        while (newTail.next != null) {
            newTail = newTail.next;
        }
        // link the old tail with the head of merged list
        tail.next = dummyHead.next;
        // update the old tail to the new tail of merged list
        tail = newTail;
    }

    int getCount(ListNode head) {
        int cnt = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        LC0148 solution = new LC0148();
        ListNode res = solution.sortList(n1);
    }
}
