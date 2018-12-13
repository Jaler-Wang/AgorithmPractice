package structs.tree;

import org.junit.Test;

public class Heap {
    private int[] data;
    private int capacity;
    private int count = 0;

    public Heap(int capacity){
        if(capacity <= 0 ) return;
        this.capacity = capacity;
        data = new int[capacity + 1];
    }

    public void insert(int value){
        if(count >= capacity) return ;
        data[++count] = value;
        int current = count;
        int parentIndex = count/2;
        while(parentIndex > 0 && data[parentIndex] < value){
            data[current] = data[parentIndex];
            data[parentIndex] = value;
            current = parentIndex;
            parentIndex = current/2;
        }
    }

    public static void buildHeap(int[] array, int n){
        if(array == null || array.length < 2) return;
        for(int i = n/2; i >= 1; i--){
            heapify(array, n, i);
        }
    }
    public static void sort(int[] array, int n){
        buildHeap(array, n);
        if(array == null || array.length < 2) return;
        while(n > 1){
            swap(array, 1, n--);
            heapify(array, n, 1);
        }
    }
    private static void heapify(int[] array, int n, int i) {
        while(true){
            int maxIndex = i;
            if(i * 2 <= n && array[i*2] > array[maxIndex]) {
                maxIndex = i * 2;
            }
            if(i*2 + 1 <= n && array[i*2+1] > array[maxIndex]){
                maxIndex = i * 2 + 1;
            }
            if(maxIndex == i) break;
            swap(array, i, maxIndex);
            i = maxIndex;
        }
    }

    private static void swap(int[] array, int i, int maxIndex) {
        int temp = array[i];
        array[i] = array[maxIndex];
        array[maxIndex] = temp;
    }

    public void removeMax(){
        if(count <= 0) return;
        data[1] = data[count--];
        int current = 1;
        while(true){
            int maxIndex = current;
            if(current *2 <= count && data[current *2] > data[maxIndex]) {
                maxIndex = current * 2;
            }
            if(current *2 + 1 <= count && data[current * 2 + 1] > data[maxIndex]) {
                maxIndex = current * 2 + 1;
            }
            if(maxIndex == current) break;
            int temp = data[current];
            data[current] = data[maxIndex];
            data[maxIndex] = temp;
            current = maxIndex;
        }
    }

    public void output(){
        for(int i = 1; i <= count; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}