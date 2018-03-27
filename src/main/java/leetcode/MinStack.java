package leetcode;

import java.util.LinkedList;

/**
 * Created by U0148394 -Jianle.Wang on 2/13/2017.
 */
public class MinStack {
    private LinkedList<Long> list;
    private long min;
    public MinStack(){
        list = new LinkedList<Long>();
    }
    public void push(int value){
        if(list.size() == 0){
            list.addFirst(0L);
            min = value;
        }
        else{
            list.addFirst(value - min);
            if(value < min) min = value;
        }
    }

    public void pop(){
        if(list.size() == 0){
            return;
        }
        long value = list.removeFirst();
        if(value < 0){
            min = min - value;
        }
    }

    public int top(){
        long topValue = list.getFirst();
        if(topValue > 0) return (int) (topValue + min);
        return (int) min;
    }

    public int getMin(){
        return (int) min;
    }
}
