package structs;

import link.Data;
import org.junit.Assert;
import org.junit.Test;

public class StackBaseLink {
    private Data head = new Data();

    public void push(int value) {
        Data ele = new Data(value);
        ele.next = head.next;
        head.next = ele;
    }

    public int pop() {
        if(head.next == null) return -1;
        int result = head.next.value;
        head.next = head.next.next;
        return result;
    }

    @Test
    public void test(){
        StackBaseLink stack = new StackBaseLink();
        Assert.assertEquals(-1, stack.pop());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
        Assert.assertEquals(-1, stack.pop());
    }
}
