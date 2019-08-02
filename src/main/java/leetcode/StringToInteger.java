package leetcode;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.trim() == null) return 0;
        str = str.trim();
        Pattern pattern = Pattern.compile("^([+-]?)0*(\\d+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String data = matcher.group(1) + matcher.group(2);
            if(data.length() > 13) return data.startsWith("-")? Integer.MIN_VALUE : Integer.MAX_VALUE;
            Long value = Long.parseLong(data);
            if(value > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(value < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return value.intValue();
        }
        return 0;
    }

    @Test
    public void test(){
        int result = myAtoi("-000000000000001");
        System.out.println(result);

    }
}
