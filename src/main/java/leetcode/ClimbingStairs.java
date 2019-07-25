package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class ClimbingStairs {
    public int climbStairs(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        if(n > 1) list.add(2);
        for(int i = 3; i <= n; i++){
            list.add(list.getFirst() + list.getLast());
            list.removeFirst();
        }
        return list.getLast();
    }

    @Test
    public void test(){
        Assert.assertEquals(2, climbStairs(2));
        Assert.assertEquals(3, climbStairs(3));
    }
}
