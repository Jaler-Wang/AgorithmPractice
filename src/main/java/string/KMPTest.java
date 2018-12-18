package string;

import org.junit.Test;

public class KMPTest {
    @Test
    public void test(){
        char[] source = "abcacabcbcbacabc".toCharArray();
        char[] pattern = "cbacabc".toCharArray();
//        char[] source = "bacadaa".toCharArray();
//        char[] pattern = "aa".toCharArray();
        KMP kmp = new KMP();
        int index = kmp.kmp(source, pattern);
        System.out.println(index);
    }
}
