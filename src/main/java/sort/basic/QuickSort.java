package sort.basic;

import org.junit.Test;

public class QuickSort {
    public void quickSort(int[] data, int start, int end) {
        if (start >= end) return;
        int pivot = partition(data, start, end);
        quickSort(data, start, pivot - 1);
        quickSort(data, pivot + 1, end);
    }

    private int partition(int[] data, int start, int end) {
        int pivot = data[end];
        int index = start;
        for(int i = start; i <= end - 1; i++){
            if(data[i] <= pivot){
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
                index++;
            }
        }
        data[end] = data[index];
        data[index] = pivot;
        return index;
    }

    @Test
    public void quickSortTest() {
        int[] data = new int[]{8,10,2,3,6,1,5};
        quickSort(data, 0, data.length - 1);
        output(data);
    }

    private void output(int[] data) {
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
