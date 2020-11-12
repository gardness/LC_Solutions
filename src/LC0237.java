public class LC0237 {
    // head = [4,5,1,9], node = 5
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
