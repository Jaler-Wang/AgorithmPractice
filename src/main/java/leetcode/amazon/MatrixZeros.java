package leetcode.amazon;

/**
 * Created by Administrator on 2017/3/11 0011.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * solution:
 * since it not allow to user extra space, it is easy to think about use the first line to represet whether zero's the corresponding column
 * use the first coulum to represent whether to zero's the corresponding row;
 * the key point is the [0, 0], both the first row and first column include it. You can use it only once.
 */
public class MatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int firstCol = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstCol = 0;
            }
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (firstCol == 0) {
                matrix[i][0] = 0;
            }
        }

    }
}
