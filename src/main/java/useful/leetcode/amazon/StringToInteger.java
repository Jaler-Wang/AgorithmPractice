package useful.leetcode.amazon;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/12 0012.
 * Implement atoi to convert a string to an integer.
 * Solution:
 * 1> When increase one digit in the end, result = result * 10 + newDigit;
 * 2> pay attention to the max and min value, it maybe overflow
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int sign = 1;
        int index = 0;
        while(str.charAt(index) == ' ') index++;

        if(str.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        else if(str.charAt(index) == '+'){
            index++;
        }
        int result = 0;
        while( index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && str.charAt(index) > '7')){
                if(sign > 0) return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(index) - '0');
            index++;
        }
        return result * sign;
    }
    @Test
    public void test(){
        System.out.print(myAtoi("2147483648"));
    }
}
