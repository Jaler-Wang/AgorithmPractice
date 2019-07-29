package sort;

import org.junit.Test;

public class MergeSort {
    public void mergeSort(int[] data){
        if(data == null || data.length < 2) return;
        sort(data, 0, data.length);

    }

    public void sort(int[] data, int start, int end) {
        if(end - start <= 1) return;
        int mid = (end - start)/2 + start;
        sort(data, start, mid);
        sort(data, mid, end);
        merge(data, start, mid, end);
    }

    private void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start];
        int index = 0;
        int index1 = start;
        int index2 = mid;
        while (index1 < mid || index2 < end) {
            if (index1 == mid) {
                temp[index++] = data[index2++];
                continue;
            }
            if (index2 == end) {
                temp[index++] = data[index1++];
                continue;
            }
            temp[index++] = (data[index1] < data[index2]) ? data[index1++] : data[index2++];
        }
        for(int i = start; i < end; i++) {
            data[i] = temp[i - start];
        }
    }

    @Test
    public void test(){
        int[] data = new int[]{1,5,2,1,0,5,7,8,9,2,8};
        mergeSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
