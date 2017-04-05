package useful.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 Solution: for the sorted array, we can use binary search to find the kth data;

 */
public class KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        while(low < high){
            int mid = low + (high - low)/2;
            int count = 0;
            int j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++){
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += j+1;
            }
            if(count < k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }

    @Test
    public void test() {
//        int[][] matrix = {{1,  5,   9},
//                          {10, 11, 13},
//                          {12, 13, 15}};
        int[][] matrix = {{1,2},
                          {1,3}};
        int result = kthSmallest(matrix, 2);

        Assert.assertEquals(1, result);
    }
}
