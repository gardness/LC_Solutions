package ADT;

import java.util.Arrays;
import java.util.Comparator;

public class MinHeap {  //TODO: generics, unlimited, comparator
    // fields
    int[] array;
    int size;
    Comparator<Integer> comparator;

    static final int DEFAULT_CAPACITY = 10;

    // methods
    MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    MinHeap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can not be negative.");
        }

        array = new int[capacity];
        size = 0;
    }

    MinHeap(int capacity, Comparator<Integer> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    MinHeap(int[] array) {
        this.array = Arrays.copyOf(array, array.length * 2);    //  You don't have to expand the array now.
        heapify();
    }

    public void offer(int val) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        array[size] = val;
        size++;
        siftUp(size);
    }

    public int poll() throws Exception {
        if (size == 0) {
            throw new Exception("MinHeap is empty.");
        }

        int res = array[0];
        array[0] = array[size - 1];
        size--;
        siftDown(0);

        return res;
    }

    public boolean update(int index, int val) {
        // cc
        if (index < 0 || index > size - 1) {
            return false;
        }

        int tmp = array[index];
        array[index] = val;

        if (tmp > val) {
            siftUp(index);
        } else if (tmp < val) {
            siftDown(index);
        }

        return true;
    }

    // Time Complexity : O(n)
    private void heapify() {
        for (int i = size - 1; (i - 1) / 2 >= 0; i--) {
            siftDown((i - 1) / 2);
        }
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (array[parent] > array[index]) {
                swap(array, parent, index);
            } else {
                break;
            }

            index = parent;
        }
    }

    private void siftDown(int index) {
        while (index <= (size - 2) / 2) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int swapIndex = left;

            if (right < size) {
                if (array[right] < array[left]) {
                    swapIndex = right;
                }
            }

            if (array[index] < array[swapIndex]) {
                swap(array, index, swapIndex);
            } else {
                break;
            }

            index = swapIndex;
        }
    }

    private void swap(int[] array, int fst, int snd) {
        int tmp = array[fst];
        array[fst] = array[snd];
        array[snd] = tmp;
    }
}
