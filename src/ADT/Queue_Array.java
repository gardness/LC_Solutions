package ADT;

public class Queue_Array {
    class ArrayQueue {
        // fields
        int[] arr;
        int head;
        int tail;
        int size;

        private static final int DEFAULT_CAPACITY = 10;

        // methods
        ArrayQueue() {
            this(DEFAULT_CAPACITY);
        }

        ArrayQueue(int capacity) {
            this.arr = new int[capacity];
            head = 0;
            tail = 0;
            size = 0;
        }

        public void offer(int val) {
            if (size == arr.length) {
                this.arr = expand();
            }

            arr[tail] = val;
            tail = (tail + 1) % arr.length;
            size++;
        }

        public int[] expand() {
            int[] newArr = new int[arr.length * 2];
            int i = 0;

            while (head != tail) {
                newArr[i++] = arr[head];
                head = (head + 1) % arr.length;
            }

            head = 0;
            tail = arr.length;

            return newArr;
        }

        public int poll() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is Empty!");
            }

            int res = arr[head];

            head = (head + 1) % arr.length;

            return res;
        }

        public int peek() throws Exception {
            if (size == 0) {
                throw new Exception("Queue is Empty!");
            }

            return arr[head];
        }
    }
}
