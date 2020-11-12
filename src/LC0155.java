import java.util.Stack;

public class LC0155 {
    class MinStack1 {
        Stack<Integer> stack;
        Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack1() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                minStack.push(Math.min(minStack.peek(), x));
            }

            stack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MinStack {            //TODO: Generics
        private Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            int min = 0;

            if (stack.isEmpty()) {
                min = Integer.MAX_VALUE;
            } else {
                min = stack.peek();
            }

            stack.push(x);
            stack.push(Math.min(min, x));            //  push order matters
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }

            stack.pop();
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty()) {
                return Integer.MAX_VALUE;
            }

            int[] tmp = new int[2];
            tmp[0] = stack.pop();
            tmp[1] = stack.pop();
            stack.push(tmp[1]);
            stack.push(tmp[0]);

            return tmp[1];
        }

        public int getMin() {
            return stack.peek();
        }
    }
}
