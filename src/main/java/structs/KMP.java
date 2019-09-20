package structs;

import org.junit.Test;

public class KMP {
    public boolean isSubString(char[] p, int m, char[] q, int n){
        int[] matchPrefix = generateMatchPrefix(q, n);
        int j = 0;
        for (int i = 0; i < m; i++) {
            while(j > 0 && p[i] != q[j]){
                j = matchPrefix[j] + 1;
            }
            if(p[i] == q[j]){
                j++;
            }
            if(j == n){
                return true;
            }
        }
        return false;
    }

    private int[] generateMatchPrefix(char[] q, int n) {
        int[] matchPrefix = new int[n];
        matchPrefix[0] = -1;
        int k = -1;
        for (int i = 1; i < n; i++) {
            while(k >= 0 && q[i] != q[k+1]){
                k = matchPrefix[k];
            }
            if(q[i] == q[k+1]){
                k++;
            }
            matchPrefix[i] = k;
        }
        return matchPrefix;
    }

    @Test
    public void test(){

    }
}
