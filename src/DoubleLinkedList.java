class DoubleLinkedListNode<T> {
    T val;
    DoubleLinkedListNode<T> prev;
    DoubleLinkedListNode<T> next;

    DoubleLinkedListNode() {}

    DoubleLinkedListNode(T val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    DoubleLinkedListNode(T val, DoubleLinkedListNode prev, DoubleLinkedListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

public class DoubleLinkedList<T> {
    private int size;
    private DoubleLinkedListNode<T> head;
    private DoubleLinkedListNode<T> tail;

    DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    DoubleLinkedList(int size) {
        this.size = size;

        if (size <= 0) {
            return;
        }

        DoubleLinkedListNode<T> head = new DoubleLinkedListNode();
        tail = head;

        while (--size > 0) {
            DoubleLinkedListNode<T> tmp = new DoubleLinkedListNode();
            tail.next = tmp;
            tail = tmp;
        }
    }

    public int getSize() {
        return size;
    }

    public T getVal(int idx) {
        // cc
        if (size == 0 || idx < 0 || idx >= size) {
            throw new IllegalArgumentException("getVal()");
        }

        DoubleLinkedListNode<T> cur = head;

        while (idx-- > 0) {
            cur = cur.next;
        }

        return cur.val;
    }

    public boolean isEmpty() {
        return head == null && tail == null;
    }

    public void addHead(T val) {
        if (head == null) {
            head = new DoubleLinkedListNode<T>(val);
            tail = head;
        } else {
            DoubleLinkedListNode<T> tmp = new DoubleLinkedListNode<>(val);
            tmp.next = head;
            head.prev = tmp;
            head = tmp;
        }

        size++;
    }

    public void addTail(T val) {
        if (tail == null) {
            head = new DoubleLinkedListNode<T>(val);
            tail = head;
        } else {
            DoubleLinkedListNode<T> tmp = new DoubleLinkedListNode<T>(val);
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }

        size++;
    }


}
