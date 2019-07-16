package structs;

import link.Data;
import org.junit.Assert;
import org.junit.Test;

public class QueueBaseLink {
    private Data head = new Data();
    private Data tail = head;

    public void enqueue(int value){
        Data ele = new Data(value);
        tail.next = ele;
        tail = ele;
    }

    public int dequeue(){
        if(head == tail) return -1;
        if(head.next == tail) tail = head;
        int result = head.next.value;
        head.next = head.next.next;
        return result;
    }

    @Test
    public void test(){
        QueueBaseLink queue = new QueueBaseLink();
        Assert.assertEquals(-1, queue.dequeue());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(2, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
        Assert.assertEquals(-1, queue.dequeue());
    }
}
