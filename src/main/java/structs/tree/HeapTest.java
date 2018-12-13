package structs.tree;

import org.junit.Test;

public class HeapTest {
    @Test
    public void heapTest(){
        Heap heap = new Heap(5);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.output();
        heap.removeMax();
        heap.output();
    }

    @Test
    public void buildHeapTest(){
        int[] array = new int[]{0, 5,4,3,2,1};
//        Heap.buildHeap(array, 5);
        output(array);
        Heap.sort(array, 5);
        output(array);
    }

    private void output(int[] array) {
        for(int i = 1; i < array.length; i++){
            System.out.print(array[i] +" ");
        }
        System.out.println();
    }
}
