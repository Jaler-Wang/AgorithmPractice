package sort;

import org.junit.Test;

public class BubbleSort {
    public void bubbleSort(int[] data) {
        if(data == null || data.length < 2) return;
        for(int i = 0; i < data.length - 1; i++) {
            int value = data[i];
            for(int j = i+1; j < data.length; j++) {
                if(data[j] < value){
                    int temp = data[j];
                    data[j] = value;
                    value = temp;
                }
            }
        }
    }

    @Test
    public void test(){
        int[] data = new int[]{3, 2, 4, 3, 5, 9, 1};
        bubbleSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
