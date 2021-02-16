package ADT;

import java.util.List;

public class Stack_SingleLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this(val, null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class MyStack {
        // fields
        ListNode head;
        int size;

        // methods
        MyStack(ListNode head, int size) {
            this.head = head;
            this.size = size;
        }


        public void push(int val) {
            ListNode tmp = new ListNode(val);

            tmp.next = head;
            head = tmp;
            size++;
        }

        public int pop() throws Exception {
            if (head == null) {
                throw new Exception("Stack is empty!");
            }

            ListNode top = head;

            head = head.next;
            top.next = null;
            size--;

            return top.val;
        }

        public int peek() throws Exception {
            if (head == null) {
                throw new Exception("Stack is empty!");
            }

            return head.val;
        }
    }


    // Generic Type
    class MyNode<T> {
        T val;
        MyNode next;

        MyNode(T val) {
            this.val = val;
            this.next = null;
        }
    }

    class NewStack<T> {
        // fields
        MyNode<T> head;
        int size;

        // methods
        NewStack() {
            head = null;
            size = 0;
        }

        public void push(T val) {
            MyNode<T> tmp = new MyNode<>(val);

            tmp.next = head;
            head = tmp;
            size++;
        }

        public T pop() throws Exception {
            if (head == null) {
                throw new Exception("Stack is Empty!");
            }

            MyNode<T> top = head;
            head = head.next;
            top.next = null;
            size--;

            return top.val;
        }

        public T peek() throws Exception {
            if (head == null) {
                throw new Exception("Stack is Empty!");
            }

            return head.val;
        }
    }
}
