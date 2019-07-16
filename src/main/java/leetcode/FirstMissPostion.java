package leetcode;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.abs;

public class FirstMissPostion {
    //with O(n) space complex
    public int firstMissingPositive1(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current > length || current <= 0) {
                continue;
            }
            result[nums[i] - 1] = nums[i];
        }
        for (int i = 0; i < length; i++) {
            if (result[i] == 0) return i + 1;
        }
        return length + 1;
    }

    //with O(1) space complex
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++){
            nums[i] = nums[i] <= 0 ? size + 1 : nums[i];
        }

        for (int i = 0; i < size; i++){
            if (abs(nums[i]) > 0 && abs(nums[i]) <= size)
                nums[abs(nums[i]) - 1] = nums[abs(nums[i]) - 1] > 0 ? -nums[abs(nums[i]) - 1] : nums[abs(nums[i]) - 1];
        }
        for (int i = 0; i < size; i++)
            if (nums[i] > 0)
                return i + 1;
        return size + 1;
    }

    @Test
    public void withoutFirstTest() {
        int[] nums = new int[]{7, 8, 9, 11, 12};
        int result = firstMissingPositive(nums);
        System.out.println(result);
        Assert.assertEquals(1, result);
    }

    @Test
    public void withoutSecondTest() {
        int[] nums = new int[]{3, 4, -1, 1};
        int result = firstMissingPositive(nums);
        System.out.println(result);
        Assert.assertEquals(2, result);
    }

    @Test
    public void withoutLastTest() {
        int[] nums = new int[]{1, 2, 0};
        int result = firstMissingPositive(nums);
        System.out.println(result);
        Assert.assertEquals(3, result);
    }
}
