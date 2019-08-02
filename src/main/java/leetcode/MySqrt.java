package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class MySqrt {
    public int mySqrt(int x) {
        if( x == 0) return 0;
        int start = 1;
        int end = x/2 + 1;
        while (start < end) {
            int mid = (end - start)/ 2 + start;
            if(mid <= x/mid && (mid + 1) > x/(mid+1)) return mid;
            if(mid < x/mid){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }

    @Test
    public void test(){
        Assert.assertEquals(2, mySqrt(8));
    }
}
