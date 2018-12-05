package sort.basic;

import org.junit.Test;

public class MergeSort {
    public void mergeSort(int[] data, int start, int end){
        if (start >= end){
            return;
        }
        int mid = (end - start)/2 + start;
        mergeSort(data, start, mid);
        mergeSort(data, mid + 1, end);
        merge(data, start, mid, end);
    }

    private void merge(int[] data, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int index = 0;
        int start1 = start;
        int start2 = mid + 1;
        while(start1 <= mid || start2 <= end){
            if(start1 > mid){
                while(start2 <= end){
                    temp[index++] = data[start2++];
                }
                break;
            }
            if(start2 > end){
                while(start1 <= mid){
                    temp[index++] = data[start1++];
                }
                break;
            }
            if(data[start1] <= data[start2]){
                temp[index++] = data[start1++];
            }
            else {
                temp[index++] = data[start2++];
            }
        }
        for(int i = start; i <= end; i++){
            data[i] = temp[i - start];
        }
    }

    @Test
    public void sortTest(){
        int[] data = new int[]{11,8,3,9,7,1,2,5};
        mergeSort(data, 0, data.length-1);
        for(int ele : data){
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}
