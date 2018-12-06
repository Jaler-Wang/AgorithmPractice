package sort.basic;

import org.junit.Test;

import java.util.Collections;

public class CalculateSort {
    public void sort(int[] data){
        if (data == null || data.length <= 1) return;
        int max = data[0];
        for(int i = 0; i < data.length; i++){
            if(data[i] > max){
                max = data[i];
            }
        }
        int[] count = new int[max + 1];
        for(int i = 0; i < count.length; i++){
            count[i] = 0;
        }

        for(int i = 0; i < data.length; i++){
            count[data[i]]++;
        }

        for(int i = 1; i < count.length; i++ ){
            count[i] += count[i - 1];
        }
        int[] temp = new int[data.length];
        for(int i = data.length - 1; i >= 0; i--){
            temp[count[data[i]] - 1] = data[i];
            count[data[i]]--;
        }
        for(int i = 0; i < data.length; i++){
            data[i] = temp[i];
        }
    }

    @Test
    public void test(){
        int[] data = new int[]{2,5,3,0,2,3,0,3};
        sort(data);
        for(int ele : data){
            System.out.print(ele + " ");
        }
    }
}
