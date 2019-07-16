package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        int index = 0;
        int data = nums[index];
        while(data <= 0 && index < nums.length - 2){
            int sum = 0 - data;
            int start = index + 1;
            int end = nums.length - 1;
            while(start < end){
                int remain = nums[start] + nums[end];
                if (remain == sum) {
                    list.add(generateEle(data, nums[start], nums[end]));
                    while(start < end && nums[start] == nums[start + 1]) start++;
                    while(start < end && nums[end] == nums[end-1]) end--;
                    start++;
                    end--;
                }
                else if( remain < sum){
                    start++;
                }
                else{
                    end--;
                }
            }
            while(nums[index] == nums[index+1] && index < nums.length - 2) index++;
            data = nums[++index];
        }
        return list;
    }

    private List<Integer> generateEle(int data, int num, int num1) {
        List<Integer> ele = new ArrayList<Integer>();
        ele.add(data);
        ele.add(num);
        ele.add(num1);
        return ele;
    }

    @Test
    public void test(){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
}
