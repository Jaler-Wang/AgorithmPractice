package search;

import org.junit.Test;

public class FindTheFirstGreatOrEqualValue {
    public int findTheFirstGreatOrEqaulValue(int[] data, int value){
        if(data == null ||data.length == 0) return -1;
        int start = 0;
        int end = data.length - 1;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            if(data[mid] < value){
                start = mid + 1;
            }
            else{
                if(mid == 0 || data[mid - 1] < value){
                    return mid;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void findTheFirstGreatOrEqualValue(){
        int[] data = new int[]{1,2,2,3,3,3,4};
        int theLastValue = findTheFirstGreatOrEqaulValue(data, 3);
        System.out.println(theLastValue);
    }
}
