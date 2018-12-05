package leetcode;

import org.junit.Test;

public class ContinerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null) return 0;
        int left = 0;
        int right = height.length -1;
        int max = 0;
        while(left < right){
            int lower = Math.min(height[left], height[right]);
            max = Math.max(max, (right-left)*lower);
            if(lower == height[left]) left++;
            else{
                right--;
            }
        }
        return max;
    }

    @Test
    public void test(){
            int[] data = {1,2,3};
            System.out.println(maxArea(data));
    }
}
