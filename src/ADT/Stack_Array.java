package ADT;

public class Stack_Array {
    class ArrayStack {
        // fields
        int[] arr;
        int head;

        private static final int DEFAULT_CAPACITY = 10;

        // methods
        ArrayStack() {
            this(DEFAULT_CAPACITY);
        }

        ArrayStack(int capacity) {
            arr = new int[capacity];
            head = 0;
        }

        public void offer(int val) {
            if (head == arr.length) {
                arr = expand();
            }

            arr[head++] = val;
        }

        private int[] expand() {
            int[] newArr = new int[arr.length * 2];

            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }

            head = arr.length;

            return newArr;
        }

        public int poll() throws Exception {
            if (head == 0) {
                throw new Exception("Stack is empty!");
            }

            return arr[--head];
        }

        public int peek() throws Exception {
            if (head == 0) {
                throw new Exception("Stack is empty!");
            }

            return arr[head - 1];
        }
    }
}
