package useful.leetcode;

import org.junit.Test;

/**
 * 240. Search a 2D Matrix II
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchInMartix {
    public boolean  search(int[][] matrix, int value) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int width = 0;
        int height = matrix[0].length - 1;

        while(width < matrix.length && height >= 0){
            if(value > matrix[width][height]){
                width++;
            }
            else if(value < matrix[width][height]){
                height--;
            }
            else{
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] data = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(search(data, 5));
    }
}
