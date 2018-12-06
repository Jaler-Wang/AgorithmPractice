package search;

import org.junit.Test;

public class FindValueInCycleArray {
    public int findValueInCycleArray(int[] data, int value) {
        if (data == null || data.length == 0) {
            return -1;
        }
        int start = findStart(data);
        System.out.println("first index " + start);
        int end = start + data.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(data[mid%data.length] == value) return mid%data.length;
            if(data[mid%data.length] < value){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    private int findStart(int[] data) {
        int start = 0;
        int end = data.length - 1;
        if(data[end] > data[start]) return 0;
        int endValue = data[end];
        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (mid == 0 || (data[mid - 1] > endValue && data[mid] <= endValue)) {
                System.out.println(mid);
                return mid;
            } else {
                if (data[mid] > endValue) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void findValueInCycleArrayTest(){
        int[] data = new int[]{2, 3, 4, 5, 6, 1};
        int index = findValueInCycleArray(data, 1);
        System.out.println(index);
    }
}
