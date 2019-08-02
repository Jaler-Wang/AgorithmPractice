package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class ReverseString {
    public void reverseString(char[] s) {
        if(s == null || s.length == 0) return;
        int start = 0;
        int end = s.length -1;
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void whenIncludeOneElementChangeNothing(){
        char[] data = new char[]{'a'};
        reverseString(data);
        Assert.assertArrayEquals(new char[]{'a'}, data);
    }

    @Test
    public void whenInputABThenOutputBA(){
        char[] data = new char[]{'a', 'b'};
        reverseString(data);
        Assert.assertArrayEquals(new char[]{'b', 'a'}, data);
    }
}
