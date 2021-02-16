package ADT;

public class Queue_DoubleLinkedList {
    class ListNode {    //TODO: generics
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }


    // Single Linked List
    class MyQueue {
        // fields
        ListNode head, tail;

        // methods
        MyQueue() {
            this.head = null;
            this.tail = null;
        }

        public void offer(int val) {
            ListNode tmp = new ListNode(val);

            if (tail == null) {
                tail = tmp;
                head = tmp;
            } else {
                tmp.next = tail;
                tail = tmp;
            }
        }

        public int poll() throws Exception {
            if (tail == null) {
                throw new Exception("Queue is Empty!");
            }

            int res = head.val;

            if (tail == head) {
                tail = null;
                head = null;

                return res;
            }

            ListNode cur = tail;

            while (cur.next != head) {
                cur = cur.next;
            }

            cur.next = null;
            head = cur;

            return res;
        }

        public int peek() throws Exception {
            if (tail == null) {
                throw new Exception("Queue is Empty!");
            }

            return head.val;
        }
    }


    // Double Linked List
    class MyQueue1 {
        // fields
        ListNode tail;
        ListNode head;

        // methods
        MyQueue1() {
            tail = null;
            head = null;
        }

        public void offer(int val) {
            ListNode cur = new ListNode(val);

            if (tail == null) {
                tail = cur;
                head = cur;
            }

            tail.prev = cur;
            cur.next = tail;
            tail = cur;
        }

        public int poll() throws Exception {
            if (tail == null) {
                throw new Exception("Queue is Empty!");
            }

            int res = head.val;

            if (tail == head) {
                tail = null;
                head = null;
            }

            ListNode newHead = head.prev;

            head.prev = null;
            newHead.next = null;
            head = newHead;

            return res;
        }

        public int peek() throws Exception {
            if (tail == null) {
                throw new Exception("Queue is Empty!");
            }

            return head.val;
        }
    }
}
