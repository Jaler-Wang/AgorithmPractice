package sort;

import org.junit.Test;

public class InsertSort {
    public void insertSort(int[] data) {
        if(data == null || data.length < 2) return;
        for(int i = 1; i < data.length; i++) {
            int index = i - 1;
            int value = data[i];
            while (index >= 0 && data[index] > value) {
                data[index + 1] = data[index];
                index--;
            }
            data[index+1] = value;
        }
    }

    @Test
    public void test() {
        int[] data = new int[]{3, 2, 4, 3, 5, 9, 1};
        insertSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
