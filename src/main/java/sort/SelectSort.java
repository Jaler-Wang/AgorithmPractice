package sort;

import org.junit.Test;

public class SelectSort {
    public void selectSort(int[] data) {
        if(data == null || data.length < 2) return;
        for(int i = 0; i < data.length; i++) {
            int value = data[i];
            int index = i;
            for(int j = i+1; j < data.length; j++) {
                if(data[j] < value){
                    value = data[j];
                    index = j;
                }
            }
            data[index] = data[i];
            data[i] = value;
        }
    }

    @Test
    public void test(){
        int[] data = new int[]{3, 2, 4, 3, 5, 9, 1};
        selectSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
