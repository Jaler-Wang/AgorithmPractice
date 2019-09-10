package useful;

public class Heap {
    private int[] a;
    private int n;
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
    }

    public void insert(int data){
        if(count >= n) return;
        count++;
        a[count] = data;
        int i = count;
        while(i/2 > 0 && a[i/2] < a[i]){
            int temp = a[i];
            a[i] = a[i/2];
            a[i/2] = temp;
            i = i/2;
        }
    }

    public void removeMax(){
        if(count == 0) return;
        a[1] = a[count];
        count--;
        heapify(1);
    }

    private void heapify(int i) {
        while (true) {
            int maxPos = i;
            if(i * 2 <= count && a[i] < a[i*2]) maxPos = i*2;
            if(i*2 + 1 <= count && a[i] < a[i*2 + 1]) maxPos = i*2 + 1;
            if(maxPos == i) break;
            swap(i, maxPos);
            i = maxPos;
        }
    }

    public void buildHeap() {
        for(int i = n/2; i >= 1; --i){
            heapify(i);
        }
    }
    private void swap(int i, int maxPos) {
        int temp = a[i];
        a[i] = a[maxPos];
        a[maxPos] = temp;
    }

    public void sort(){
        buildHeap();
        for(int i = n; i > 1; i--){
            swap(1, i);
            heapify(1);
        }
    }

}
