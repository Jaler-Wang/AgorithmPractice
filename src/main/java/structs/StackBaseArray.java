package structs;

import org.junit.Assert;
import org.junit.Test;

public class StackBaseArray {
    int[] data;
    int top = 0;
    public StackBaseArray(){
    }

    public void init(int size){
        data = new int[size];
    }

    public void push(int value){
        if(top == data.length){
            System.out.println("stack is full");
        }
        else{
            data[top++] = value;
        }
    }

    public int pop(){
        if(top > 0){
            return data[--top];
        }
        else{
            System.out.println("stack is empty");
            return -1;
        }
    }

    @Test
    public void test(){
        StackBaseArray stack = new StackBaseArray();
        stack.init(2);
        int value = stack.pop();
        Assert.assertSame(-1, value);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
        Assert.assertEquals(-1, stack.pop());
    }
}
