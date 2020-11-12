import java.util.LinkedList;
import java.util.Queue;

public class LC0225 {
    class MyStack {
        Queue<Integer> fQueue;
        Queue<Integer> sQueue;

        /** Initialize your data structure here. */
        public MyStack() {
            fQueue = new LinkedList<>();
            sQueue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            while (!sQueue.isEmpty()) {
                fQueue.offer(sQueue.poll());
            }

            sQueue.offer(x);

            while (!fQueue.isEmpty()) {
                sQueue.offer(fQueue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (sQueue.isEmpty()) {
                return Integer.MIN_VALUE;
            }

            return sQueue.poll();
        }

        /** Get the top element. */
        public int top() {
            return sQueue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return sQueue.isEmpty();
        }
    }
}
