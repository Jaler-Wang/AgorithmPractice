package sort.basic;

import org.junit.Test;

/**
 * Created by U0148394 on 11/9/2016.
 */
public class HeapSort {
    public void maxHeapify(int[] data, int index, int heapSize) {
        int left = index * 2;
        int right = index * 2 + 1;
        int largestDataIndex = index;
        if (left <= heapSize && data[largestDataIndex] < data[left]) {
            largestDataIndex = left;
        }
        if (right <= heapSize && data[largestDataIndex] < data[right]) {
            largestDataIndex = right;
        }

        if (largestDataIndex != index) {
            int temp = data[index];
            data[index] = data[largestDataIndex];
            data[largestDataIndex] = temp;
            maxHeapify(data, largestDataIndex, heapSize);
        }
    }

    public void buildMaxHeap(int[] data) {
        if (data == null || data.length < 2) {
            return;
        }
        int max = data.length / 2;
        for (int i = max; i >= 0; i--) {
            maxHeapify(data, i, data.length - 1);
        }
    }

    public void heapSort(int[] data) {
        buildMaxHeap(data);
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[i];
            data[i] = data[0];
            data[0] = temp;
            maxHeapify(data, 0, i - 1);
        }
    }

    public void outputArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void heapSortTest() {
        int[] data = new int[]{5, 13, 2, 25, 7, 17, 20, 8, 4};
        heapSort(data);
        outputArray(data);
    }

}
