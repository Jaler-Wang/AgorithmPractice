package dp;

import org.junit.Test;

/**
 * Created by U0148394 -Jianle.Wang on 2/1/2017.
 */
public class LCS {
    public int lcs(String x, String y){
        if(x == null || y == null) return 0;
        int[][] distance = new int[x.length() + 1][y.length() + 1];
        for(int i = 0; i <= x.length(); i++){
            for(int j = 0; j <= y.length(); j++){
                if(i == 0 || j == 0){
                    distance[i][j] = 0;
                    continue;
                }
                if(x.charAt(i-1) == y.charAt(j-1)){
                    distance[i][j] = distance[i-1][j-1] + 1;
                }
                else{
                    distance[i][j] = Math.max(distance[i-1][j], distance[i][j-1]);
                }
            }
        }
        output(distance);
        return distance[x.length()][y.length()];
    }

    private void output(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    @Test
    public void given2StringThen4(){
        String x = "ABCBDAB";
        String y = "BDCABA";
        int sameStringLength = lcs(x, y);
        System.out.println(sameStringLength);

    }
}
