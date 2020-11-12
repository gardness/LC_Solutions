public class ListNode {
    int val;
    ListNode next;

    ListNode(){}

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString(ListNode head) {
        String retStr = "LinkList :";

        while (head != null) {
            retStr += " " + head.val;
            head = head.next;
        }

        return retStr;
    }
}
