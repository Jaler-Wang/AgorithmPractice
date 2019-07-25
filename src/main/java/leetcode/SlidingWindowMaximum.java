package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0 || nums.length < k) return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if(!list.isEmpty() && i - list.get(0) + 1 > k){
                list.remove(0);
            }
            while(!list.isEmpty() && nums[list.getLast()] < nums[i]){
                list.removeLast();
            }
            list.add(i);
            if(i + 1 >= k){
                result[i - k + 1] = nums[list.get(0)];
            }
        }
        return result;
    }

    @Test
    public void test(){
        int[] data = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(data, k);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println();
        Assert.assertArrayEquals(new int[]{3,3,5,5,6,7}, result);
    }

    @Test
    public void test1(){
        int[] data = new int[]{1,3,1,2,0,5};
        int k = 3;
        int[] result = maxSlidingWindow(data, k);
        Assert.assertArrayEquals(new int[]{3,3,2,5}, result);
    }
}
