package sort.basic;

import org.junit.Test;

public class FindTheKMaxData {
    public int findTheKMaxData(int[] data, int start, int end, int k){
        if(start >= end) return -1;
        int pivotIndex = partition(data, start, end);
        if (pivotIndex + 1 == k) return data[pivotIndex];
        if(pivotIndex + 1 < k){
            return findTheKMaxData(data, pivotIndex + 1, end, pivotIndex);
        }
        else{
            return findTheKMaxData(data, start, pivotIndex - 1, pivotIndex);
        }
    }

    private int partition(int[] data, int start, int end) {
        int pivot = data[end];
        int index = start;
        for(int i = start; i < end; i++){
            if(data[i] >= pivot){
                int temp = data[i];
                data[i] = data[index];
                data[index++] = temp;
            }
        }
        data[end] = data[index];
        data[index] = pivot;
        return index;
    }

    @Test
    public void find3rdMaxValue(){
        int[] data = new int[]{8,10,2,3,6,1,5};
        int theKMaxData = findTheKMaxData(data, 0, data.length - 1, 4);
        System.out.println(theKMaxData);
    }
}
