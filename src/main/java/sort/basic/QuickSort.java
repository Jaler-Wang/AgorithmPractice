package sort.basic;

import org.junit.Test;

/**
 * Created by U0148394 on 11/11/2016.
 */
public class QuickSort {
    public void sort(int[] data, int start, int end) {
        if (start >= end) return;
        int mid = divide(data, start, end);
        sort(data, start, mid - 1);
        sort(data, mid + 1, end);

    }

    private int divide(int[] data, int start, int end) {
        int temp = data[end];
        int midIndex = start - 1;
        for (int i = start; i < end; i++) {
            if (data[i] <= temp) {
                midIndex++;
                int d = data[midIndex];
                data[midIndex] = data[i];
                data[i] = d;
            }
        }
        data[end] = data[midIndex + 1];
        data[midIndex + 1] = temp;
        return midIndex + 1;
    }

    @Test
    public void quickSortTest() {
        int[] data = new int[]{2, 1, 3, 8, 7, 5, 6, 4};
        sort(data, 0, data.length - 1);
        output(data);
    }

    private void output(int[] data) {
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

}
