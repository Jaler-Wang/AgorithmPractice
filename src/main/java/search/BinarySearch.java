package search;

import org.junit.Test;

public class BinarySearch {
    public int search(int[] data, int value){
        if(data == null || data.length == 0) return -1;
        int start = 0;
        int end = data.length - 1;
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(data[mid] == value){
                return mid;
            }
            if(data[mid] < value){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void findTest(){
        int[] data = new int[]{1,2,3,4,5,6};
        int index = search(data, 6);
        System.out.println(index);
    }
}
