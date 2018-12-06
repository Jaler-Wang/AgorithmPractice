package search;

import org.junit.Test;

public class FindTheLastSmallOrEqualValue {
    public int findTheLastSmallOrEqualValue(int[] data, int value){
        if(data == null || data.length == 0) return -1;
        int start = 0;
        int end = data.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(data[mid] <= value){
                if(mid == data.length - 1 || data[mid + 1] > value){
                    return mid;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void findTheLastSmallOrEqualValue(){
        int[] data = new int[]{1,2,2,3,3,3,4};
        int theLastValue = findTheLastSmallOrEqualValue(data, 3);
        System.out.println(theLastValue);
    }
}
