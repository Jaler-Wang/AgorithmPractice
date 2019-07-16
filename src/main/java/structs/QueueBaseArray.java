package structs;

import org.junit.Assert;
import org.junit.Test;

public class QueueBaseArray {
    private int[] data;
    private int head = 0;
    private int tail = 0;

    public QueueBaseArray() {

    }

    public void init(int size) {
        data = new int[size];
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }
        data[tail] = value;
        tail = (tail +1)%data.length;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("queue is empty");
            return -1;
        }
        int result = data[head];
        head = (head + 1) % data.length;
        return result;
    }

    public boolean isFull() {
        return ((tail + 1) % data.length == head) ? true : false;
    }

    public boolean isEmpty() {
        return (head == tail) ? true : false;

    }

    @Test
    public void test() {
        QueueBaseArray queue = new QueueBaseArray();
        queue.init(4);
        Assert.assertTrue(queue.isEmpty());
        Assert.assertFalse(queue.isFull());
        Assert.assertEquals(-1, queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
        Assert.assertEquals(-1, queue.dequeue());
    }

}
