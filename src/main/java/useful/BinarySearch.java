package useful;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearch {
    public int binarySearch(int[] data, int value) {
        if (data == null || data.length == 0) return -1;
        int start = 0;
        int end = data.length;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if(data[mid] < value){
                start = mid + 1;
            }
            else{
                if(mid == 0 || data[mid - 1] < value) return mid;
                end = mid;
            }
        }
        return -1;
    }

    private int search(int[] data, int start, int end, int value) {
        if (start > end) return -1;
        int mid = (end - start) / 2 + start;
        if(data[mid] == value) return mid;
        if(data[mid] < value){
            return search(data, mid+1, end, value);
        }
        else{
            return search(data, start, mid, value);
        }
    }

    @Test
    public void test(){
        int[] data = new int[]{1,2,3,4,5,6,7};
        int result = binarySearch(data, 6);
        Assert.assertEquals(5, result);
    }

    @Test
    public void onlyOneData(){
        int[] data = new int[]{6};
        int result = binarySearch(data, 6);
        Assert.assertEquals(0, result);
    }
    @Test
    public void onlyOneDataAndNotEqual(){
        int[] data = new int[]{6};
        int result = binarySearch(data, 5);
        Assert.assertEquals(0, result);
    }

    @Test
    public void onlyOneDataAndLess(){
        int[] data = new int[]{4};
        int result = binarySearch(data, 5);
        Assert.assertEquals(-1, result);
    }
}
