package link;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LRU {
    Queue<Integer> queue;
    int size;

    public LRU(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public void add(int value) {
        if (queue.contains(value)) {
            queue.remove(value);
        }
        else{
            if (queue.size() == size) {
                queue.remove();
            }
        }
        queue.add(value);
    }

    public void output(){
        System.out.println(queue);
    }

    public static void main(String... args) {
        LRU lru = new LRU(3);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.output();
        lru.add(4);
        lru.output();
        lru.add(2);
        lru.output();
    }
}
