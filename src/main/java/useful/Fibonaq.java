package useful;

import org.junit.Assert;
import org.junit.Test;

public class Fibonaq {
    public int fib(int n) {
        if(n == 0 || n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    @Test
    public void test(){
        Assert.assertEquals(1, fib(0));
        Assert.assertEquals(1, fib(1));
        Assert.assertEquals(2, fib(2));
    }
}
