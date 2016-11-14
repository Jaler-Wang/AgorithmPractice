package structs;

/**
 * Created by U0148394 on 11/14/2016.
 */
public class Stack {
    private int[] array;
    private int top = -1;
    public Stack(int size){
        array = new int[size];
    }

    public boolean isEmpty(){
        if(top < 0){
            return true;
        }
        return false;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("stack underflow");
        }
        return array[top--];
    }
    public void push(int data){
        if(top >= array.length - 1){
            throw new RuntimeException("stack overflow");
        }
        array[++top] = data;
    }
}
