import java.util.Stack;

public class LC0232 {
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    class MyQueue {
        Stack<Integer> fStack;
        Stack<Integer> sStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            fStack = new Stack<>();
            sStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!fStack.isEmpty()) {
                sStack.push(fStack.pop());
            }

            fStack.push(x);

            while (!sStack.isEmpty()) {
                fStack.push(sStack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (fStack.isEmpty()) {
                return Integer.MIN_VALUE;
            }

            return fStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return fStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return fStack.isEmpty();
        }
    }
}
