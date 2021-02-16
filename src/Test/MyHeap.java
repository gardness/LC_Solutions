package Test;

import java.util.*;

public class MyHeap {   // Todo: Generics
    // Fields
    int[] array;
    int size;
    Comparator<Integer> comparator;

    static final int DEFAULT_CAPACITY = 10;

    // Methods
    MyHeap() {
        this(DEFAULT_CAPACITY);
    }

    MyHeap(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    MyHeap(int capacity, Comparator<Integer> comparator) {
        this(capacity);
        this.comparator = comparator;
    }

    MyHeap(int[] array) {
        this.array = Arrays.copyOf(array, array.length * 2);
        heapify();
    }

    private void heapify() {
        for (int i = size - 1; (i - 1) / 2 >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftUp(int index) {
        while ((index - 1) / 2 >= 0) {
            int parent = (index - 1) / 2;

            if (array[index] < array[parent]) {
                swap(index, parent);
            } else {
                break;
            }

            index = parent;
        }
    }

    private void siftDown(int index) {
        while (index <= (size - 2) / 2) {
            int lChild = index * 2 + 1;
            int rChild = index * 2 + 2;
            int swapIdx = lChild;

            if (rChild < size) {
                if (array[rChild] < array[lChild]) {
                    swapIdx = rChild;
                }
            }

            if (array[swapIdx] < array[index]) {
                swap(index, swapIdx);
            } else {
                break;
            }

            index = swapIdx;
        }
    }

    private void swap(int fIdx, int sIdx) {
        int tmp = array[fIdx];

        array[fIdx] = array[sIdx];
        array[sIdx] = tmp;
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
            throw new Exception("Heap is Empty.");
        }

        int ret = array[0];

        array[0] = array[size - 1];
        size--;
        siftDown(0);

        return ret;
    }

    public boolean update(int index, int val) {
        if (index < 0 || index > size - 1) {
            return false;
        }

        int tmp = array[index];

        array[index] = val;

        if (tmp < val) {
            siftDown(index);
        } else {
            siftUp(index);
        }

        return true;
    }


}
