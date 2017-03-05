package useful.leetcode.google;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15 3sum
 * Created by Administrator on 2017/3/5 0005.
 * Given an array S of n integers,
 * are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * idea:
 * if the array is not sort, we cannot sure whether data[i] + data[i+n] equals or not equals sum;
 * but if it's sort, then if data[i] + data[i+n} < sum, we should add data[i], else we should minus data[i+n];
 *
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3){
            return list;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int sum = 0 - nums[i];
                int startIndex = i + 1;
                int endIndex = nums.length - 1;
                while(startIndex < endIndex){
                    if(nums[startIndex] + nums[endIndex] == sum){
                        List<Integer> element = new ArrayList<Integer>();
                        element.add(nums[i]);
                        element.add(nums[startIndex]);
                        element.add(nums[endIndex]);
                        list.add(element);
                        while(startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]) startIndex++;
                        while(endIndex > startIndex && nums[endIndex] == nums[endIndex - 1]) endIndex--;
                        startIndex++;
                        endIndex--;
                        continue;
                    }
                    if(nums[startIndex] + nums[endIndex] < sum){
                        startIndex++;
                    }
                    else{
                        endIndex--;
                    }
                }
            }
        }
        return list;
    }
@Test
    public void test(){
        int[] data = new int[]{1,-1,-1,0};
        System.out.print(threeSum(data));
}
}
