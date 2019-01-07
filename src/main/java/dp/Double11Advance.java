package dp;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

public class Double11Advance {
    private int[][] data = new int[][]{{1,3,5,9},{2,1,3,4}, {5,2,6,7},{6,8,4,3}};
    private int n = 4;
    private int[][] mem = new int[4][4];

    public int minDist(int i, int j){
        if(i == 0 && j == 0) return data[0][0];
        if(mem[i][j] > 0){
            return mem[i][j];
        }
        int leftMin = Integer.MAX_VALUE;
        if(i > 0){
            leftMin = minDist(i-1, j);
        }
        int topMin = Integer.MAX_VALUE;
        if(j > 0){
            topMin = minDist(i, j - 1);
        }
        mem[i][j] = data[i][j] + Math.min(leftMin, topMin);
        return mem[i][j];
    }
    public int minDistanceDP(int[][] matrix, int n){
        int[][] states = new int[n][n];
        states[0][0] = matrix[0][0];
        for(int i = 1; i < n; i++){
            states[0][i] = states[0][i - 1] + matrix[0][i];
            states[i][0] = states[i-1][0] + matrix[i][0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                states[i][j] = matrix[i][j] + Math.min(states[i-1][j], states[i][j-1]);
            }
        }
        return states[n-1][n-1];
    }
    @Test
    public void test(){
        int[][] matric = new int[][]{{1,3,5,9},{2,1,3,4}, {5,2,6,7},{6,8,4,3}};
        int minDistanceDP = minDistanceDP(matric, 4);
        System.out.println(minDistanceDP);
        minDistanceDP = minDist(3, 3);
        System.out.println(minDistanceDP);
    }
}
