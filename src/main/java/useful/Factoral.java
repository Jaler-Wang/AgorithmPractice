package useful;

import org.junit.Assert;
import org.junit.Test;

public class Factoral {

    public long factoral(int n){
        return factoral(n, 1);
    }

    public long factoral(int n, long result){
        if(n == 0 || n == 1) return result;
        return factoral(n-1, result * n);
    }

    @Test
    public void test(){
        Assert.assertEquals(1, factoral(1));
        Assert.assertEquals(6, factoral(3));
        Assert.assertEquals(1, factoral(0));
    }
}
