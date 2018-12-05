package leetcode;

import org.junit.Test;

public class GetMedianValue {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int mid1 = (length1 + length2 + 1) / 2;
        int mid2 = (length1 + length2 + 2) / 2;

        return (getKth(nums1, 0, nums2, 0, mid1) + getKth(nums1, 0, nums2, 0, mid2)) / 2.0;

    }

    private double getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;

        if (start1 + k / 2 - 1 < nums1.length) mid1 = nums1[start1 + k / 2 - 1];
        if (start2 + k / 2 - 1 < nums2.length) mid2 = nums2[start2 + k / 2 - 1];

        if (mid1 < mid2) {
            return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

    @Test
    public void test(){
        int[] data1 = new int[]{1, 3};
        int[] data2 = new int[]{2, 4};
        double result = findMedianSortedArrays(data1, data2);
        System.out.println(result);
    }
}
