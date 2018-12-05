package leetcode;

import org.junit.Test;

public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int maxTemp = nums[0];
        int minTemp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxTemp > max) {
                max = maxTemp;
            }
            if (minTemp < min) {
                min = minTemp;
            }
            if (maxTemp * nums[i] > maxTemp) {
                maxTemp = maxTemp * nums[i];
            }
            if (minTemp * nums[i] > maxTemp) {
                maxTemp = minTemp * nums[i];
            }
            if (maxTemp * nums[i] < minTemp) {
                minTemp = maxTemp * nums[i];
            }
            if (minTemp * nums[i] < minTemp) {
                minTemp = minTemp * nums[i];
            }
            if(maxTemp == 0){
                maxTemp = nums[i];
            }
            if(minTemp == 0)
            maxTemp = nums[i];

        }
        max = Math.max(max, maxTemp);
        min = Math.max(min, minTemp);
        return Math.max(max, min);
    }

    @Test
    public void test() {
        int[] data = new int[]{-2, 0, -1};
        System.out.println(maxProduct(data));
    }
}
