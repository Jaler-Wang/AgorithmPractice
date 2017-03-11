package interview.amazons;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by U0148394 -Jianle.Wang on 3/8/2017.
 * Given a set of distinct integers, nums, return all possible subsets.
 *
 * solution:
 * for the give subset {A, B, C} if there have one new element i, then the new added
 * element should be {Ai, Bi, Ci, i};
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            results.add(new ArrayList<Integer>());
            return results;
        }
        for(int i = 0; i < nums.length; i++){
            int size = results.size();
            for(int j = 0; j < size; j++){
                List<Integer> element = results.get(j);
                List<Integer> newOne = new ArrayList<Integer>(element);
                newOne.add(nums[i]);
                results.add(newOne);
            }
            List<Integer> newElement = new ArrayList<Integer>();
            newElement.add(nums[i]);
            results.add(newElement);
        }
        results.add(new ArrayList<Integer>());
        return results;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }
}
