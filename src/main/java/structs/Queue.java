package structs;

/**
 * Created by U0148394 on 11/14/2016.
 */
public class Queue {
    private int[] array;
    private int head;
    private int tail;

    public Queue(int size){
        array = new int[size];
        head = tail = 0;

    }

    public boolean isEmpty(){
        if(head == tail){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if((tail + 1)%array.length == head){
            return true;
        }
        return false;
    }

    public void enqueue(int data){
        if(!isFull()){
            array[tail++] = data;
        }
        else{
            throw new RuntimeException("queue is full");
        }
    }

    public int dequeue(){
        if(!isEmpty()){
            return array[head--];
        }
        else{
            throw new RuntimeException("queue is empty");
        }
    }

}
