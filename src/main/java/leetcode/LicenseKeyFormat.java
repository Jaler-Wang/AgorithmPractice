package leetcode;

import org.junit.Test;

/**
 * Created by U0148394 -Jianle.Wang on 2/18/2017.
 */
public class LicenseKeyFormat {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                index++;
                sb.append(Character.toUpperCase(S.charAt(i)));
                if (index == K) {
                    sb.append("-");
                    index = 0;
                }
            }
        }
        if(sb.length() == 0) return "";
        if(sb.charAt(sb.length() - 1) == '-'){
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(licenseKeyFormatting("2-4A0r7-4k", 4));
    }
}
