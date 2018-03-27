package leetcode;

import org.junit.Test;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * solution:
 * there have four direction to out of boundary,
 * top, right when go rightup;
 * bottom, left when go leftbottom;
 * once out of boundary there need to change the go direction;
 * and pay attention to the correct order when out of bounday in two direction
 * like top and right
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int total = rowNum * colNum;
        int[] result = new int[total];
        int rowIndex = 0;
        int colIndex = 0;
        int index = 0;
        int[][] dirs = new int[][]{{1, -1}, {-1, 1}};
        int d = 1;
        result[0] = matrix[0][0];
        while (index < total) {
            result[index++] = matrix[rowIndex][colIndex];
            rowIndex += dirs[d][0];
            colIndex += dirs[d][1];

            if (colIndex >= colNum) {
                colIndex = colNum - 1;
                rowIndex += 2;
                d = 1 - d;
            }
            if (rowIndex < 0) {
                rowIndex = 0;
                d = 1 - d;
            }

            if (rowIndex >= rowNum) {
                rowIndex = rowNum - 1;
                colIndex += 2;
                d = 1 - d;
            }
            if (colIndex < 0) {
                colIndex = 0;
                d = 1 - d;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] data = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] result = findDiagonalOrder(data);
        for(int ele : result){
            System.out.print(ele + " ");
        }
    }
}
