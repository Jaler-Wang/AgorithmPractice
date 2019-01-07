package dp;

import org.junit.Test;

public class BeiBao {
    /*private int maxValue = Integer.MIN_VALUE;
    private int[] weight = new int[]{2,2,4,6,3};
    private int[] value = new int[]{3,4,8,9,6};
    private int n = weight.length;
    private int w = 9;
    public void fun(int i, int cw, int cv) {
        if(i == n || cw == w) {
            if (maxValue < cv) {
                maxValue = cv;
            }
            return;
        }
        fun(i+1, cw, cv);
        if(cw + weight[i] <= w) {
            fun(i + 1, cw + weight[i], cv + value[i]);
        }
    }*/

    public int maxValue(int[] weight, int[] value, int mv) {
        int[] status = new int[mv + 1];
        for (int j = 0; j <= mv; j++) {
            status[j] = -1;
        }
        status[0] = 0;
        status[weight[0]] = value[0];
        for (int i = 1; i < weight.length; i++) {
            for (int j = mv - weight[i]; j >=0; j--) {
                if (status[j] != -1) {
                    int v = status[j] + value[i];
                    if (v > status[j + weight[i]]) {
                        status[j + weight[i]] = v;
                    }
                }
            }
        }
        int maxValue = 0;
        for (int i = mv; i >= 0; i--) {
            if (status[i] > maxValue) {
                maxValue = status[i];
            }
        }
        return maxValue;
    }

    @Test
    public void test() {
        int[] weight = new int[]{2, 2, 4, 6, 3};
        int[] value = new int[]{3, 4, 8, 9, 6};
        int m = maxValue(weight, value, 9);
        System.out.println(m);
    }
}
