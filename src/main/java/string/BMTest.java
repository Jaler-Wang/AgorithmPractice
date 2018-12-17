package string;

import org.junit.Test;

public class BMTest {
    @Test
    public void test(){
        char[] source = "abcacabcbcbacabc".toCharArray();
        char[] pattern = "cbacabc".toCharArray();
//        char[] source = "bacadaa".toCharArray();
//        char[] pattern = "aa".toCharArray();
        BM bm = new BM();
        int index = bm.bm(source, pattern);
        System.out.println(index);
    }
}
