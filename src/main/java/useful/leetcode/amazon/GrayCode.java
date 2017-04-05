package useful.leetcode.amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11 0011.
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 soultion:
 we can use the dp to resolve this problme; if n = 1; then result is 0,1
 if n = 2, then the result is {n=1's result, n=1's result + 2^(n-1))
 ...
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if(n == 0) {
            list.add(0);
            return list;
        }
        list.add(0);
        list.add(1);
        int index = 1;
        while(index < n){
            for(int i = list.size() - 1; i >= 0; i--){
                list.add(list.get(i) + (int)Math.pow(2, index));
            }
            index++;
        }
        return list;
    }

    @Test
    public void test(){
        System.out.print(grayCode(2));
    }
}