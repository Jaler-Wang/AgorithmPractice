package leetcode;

import org.junit.Test;

public class MyCircularDeque {
    private int[] data;
    private int head;
    private int tail;
    private int count = 0;
    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        data = new int[k];
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = previous();
        data[head] = value;
        count++;
        return true;
    }

    private int previous() {
        return (head - 1 + data.length) % data.length;
    }

    private int next() {
        return (tail + 1) % data.length;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = next();
        count++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        head = (head + 1) % data.length;
        count--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        tail = (tail - 1 + data.length) % data.length;
        count--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (isEmpty()) return -1;
        return data[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (isEmpty()) return -1;
        return data[(tail - 1 + data.length)%data.length];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return count==0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));            // return true
        System.out.println(circularDeque.insertLast(2));            // return true
        System.out.println(circularDeque.insertFront(3));            // return true
        System.out.println(circularDeque.insertFront(4));            // return false, the queue is full
        System.out.println(circularDeque.getRear());            // return 2
        System.out.println(circularDeque.isFull());                // return true
        System.out.println(circularDeque.deleteLast());            // return true
        System.out.println(circularDeque.insertFront(4));            // return true
        System.out.println(circularDeque.getFront());            // return 4
    }
}