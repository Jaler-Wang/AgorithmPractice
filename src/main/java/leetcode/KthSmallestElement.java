package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 Solution1: for the sorted array, we can use binary search to find the kth data;
Solution2:  in fact, this matrix equals to find the nth smallest data in n sorted array
 */
public class KthSmallestElement {
    //usring binary search method
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

    //using priority queue
    public int kthSmallestWithPriortyQueue(int[][] matrix, int k) {
        PriorityQueue<Data> queue = new PriorityQueue<Data>();
        for(int i = 0; i < matrix.length; i++){
            queue.add(new Data(0, i, matrix[0][i]));
        }
        while(k-- > 1){
            Data data = queue.poll();
            if(data.x == matrix.length-1) continue;
            queue.add(new Data(data.x + 1, data.y, matrix[data.x + 1][data.y]));
        }
        return queue.poll().value;
    }

    class Data implements Comparable<Data> {
        int x;
        int y;
        int value;

        public Data(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int compareTo(Data that) {
            return this.value - that.value;
        }
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

    @Test
    public void test1() {
//        int[][] matrix = {{1,  5,   9},
//                          {10, 11, 13},
//                          {12, 13, 15}};
        int[][] matrix = {{1,2},
                {1,3}};
        int result = kthSmallestWithPriortyQueue(matrix, 2);

        Assert.assertEquals(1, result);
    }
}
