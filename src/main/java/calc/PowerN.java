package calc;

/**
 * Created by U0148394 -Jianle.Wang on 2/3/2017.
 */
public class PowerN {
    //14*18%5=14%5 * 18%5=4*3%5=2
    public int powerMod(int x, int n, int mod){
        long ans = 1;
        while(n > 0){
            if((n & 1) != 0){
                ans = (ans * x) % mod;
            }
            x = (int) (((long)x*x) % mod);
            n = n >> 1;
        }
        return (int) ans;
    }
}
