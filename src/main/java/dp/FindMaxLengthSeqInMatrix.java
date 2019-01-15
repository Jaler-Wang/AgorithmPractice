package dp;

import org.junit.Test;

public class FindMaxLengthSeqInMatrix {
    public int maxSeq(int[][] data) {
        if (data == null) return -1;
        int row = data.length;
        int col = data[0].length;
        int[][] length = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                visited[i][j] = false;
                length[i][j] = 0;
            }
        }
        length[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                getMaxLength(data, length, visited, i, j);
            }
        }
        int maxLength = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(length[i][j] + ", ");
                if (length[i][j] > maxLength) {
                    maxLength = length[i][j];
                }
            }
            System.out.println();
        }
        return maxLength;
    }

    private int getMaxLength(int[][] data, int[][] length, boolean[][] visited, int i, int j) {
        if(visited[i][j] == true) return 0;
        visited[i][j] = true;
        int row = data.length;
        int col = data[0].length;
        int maxLength = 1;
        //go left
        if (j > 0 && data[i][j] < data[i][j - 1]) {
            if(visited[i][j-1] == false){
                maxLength = Math.max(maxLength, getMaxLength(data, length, visited, i, j - 1) + 1);
            }
            else{
                maxLength = Math.max(maxLength, length[i][j-1] + 1);
            }
        }
        //go up
        if (i > 0 && data[i][j] < data[i - 1][j]) {
            if(visited[i-1][j] == false){
                maxLength = Math.max(maxLength, getMaxLength(data, length, visited, i-1, j) + 1);
            }
            else{
                maxLength = Math.max(maxLength, length[i-1][j] + 1);
            }
        }
        //go right
        if (j < col-1 && data[i][j] < data[i][j + 1]) {
            if(visited[i][j+1] == false){
                maxLength = Math.max(maxLength, getMaxLength(data, length, visited, i, j + 1) + 1);
            }
            else{
                maxLength = Math.max(maxLength, length[i][j+1] + 1);
            }
        }
        //go down
        if (i < row-1 && data[i][j] < data[i + 1][j]) {
            if(visited[i+1][j] == false){
                maxLength = Math.max(maxLength, getMaxLength(data, length, visited, i + 1, j) + 1);
            }
            else{
                maxLength = Math.max(maxLength, length[i+1][j]);
            }
        }
        length[i][j] = maxLength;
        return maxLength;
    }

    @Test
    public void test() {
        int[][] data = new int[][]{{1, 2, 3, 4, 5},
                                    {16, 17, 24, 23, 6},
                                    {15, 18, 25, 22, 7},
                                    {14, 19, 20, 21, 8},
                                    {13, 12, 11, 10, 9}};
//       int[][] data = new int[][]{{3,4,5}, {3,2,6},{2,2,1}};
        int length = maxSeq(data);
        System.out.println(length);
    }
}
