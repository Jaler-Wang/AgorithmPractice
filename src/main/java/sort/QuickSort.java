package sort;

import org.junit.Test;

public class QuickSort {
    public void quickSort(int[] data) {
        if(data == null || data.length <= 1) return;
        quickSort(data, 0, data.length-1);
    }

    private void quickSort(int[] data, int start, int end) {
        if(start >= end) return;
        int mid = sort(data, start, end);
        quickSort(data, start, mid-1);
        quickSort(data, mid+1, end);
    }

    private int sort(int[] data, int start, int end) {
        int value = data[end];
        int index = start;
        for(int i = start; i <= end - 1; i++) {
            if (data[i] < value) {
                int temp = data[index];
                data[index] = data[i];
                data[i] = temp;
                index++;
            }
        }
        data[end] = data[index];
        data[index] = value;
        return index;
    }

    @Test
    public void test1(){
        int[] data = new int[]{1,5,2,4};
        quickSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test(){
        int[] data = new int[]{1,5,2,1,0,5,7,8,9,2,8};
        quickSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
