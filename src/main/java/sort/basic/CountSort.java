package sort.basic;

import org.junit.Test;

/**
 * Created by Jaler on 11/12/2016.
 */
public class CountSort {
    @Test
    public void countSortTest(){
        int[] data = new int[]{2,5,3,0,2,3,0,3};
        sort(data);
    }

    private void output(int[] data) {
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void sort(int[] data){
        if(data == null || data.length < 2) return;
        int[] result = new int[data.length];
        int maxValue = getMaxValue(data);
        countSort(data, result, maxValue);
        output(result);
    }

    private void countSort(int[] data, int[] result, int maxValue) {
        int[] count = new int[maxValue+1];
        for(int i = 0; i < count.length; i++){
            count[i] = 0;
        }

        for(int i = 0; i < data.length; i++){
            count[data[i]]++;
        }
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }
        output(count);
        for(int i = 0; i < data.length; i++){
            result[count[data[i]]-1] = data[i];
            count[data[i]]--;
        }
    }

    private int getMaxValue(int[] data) {
        int max = data[0];
        for(int i = 1; i < data.length; i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        return max;
    }

}
