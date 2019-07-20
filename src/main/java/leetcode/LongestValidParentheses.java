package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int open=0;
        int[] match = new int[chars.length + 1];
        for (int i = 0; i <= chars.length; i++) {
            match[i] = 0;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                open++;
            } else {
                if (open == 0) continue;
                open--;
                int last = i-2-match[i-1];
                match[i] = match[i - 1] + 2 + ((last > 0) ? match[last] : 0);
                if (i - match[i] > 0) {
                    match[i] += match[i - match[i]];
                }
            }
        }
        int maxLength = 0;
        for (int i = match.length - 1; i >= 0; i--) {
            if(match[i] != 0) maxLength = Math.max(maxLength, match[i]);
        }
        return maxLength;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, longestValidParentheses("(()))())("));
        Assert.assertEquals(2, longestValidParentheses("(()(((()"));
        Assert.assertEquals(4, longestValidParentheses(")()())()()("));
        Assert.assertEquals(4, longestValidParentheses(")()())"));
        Assert.assertEquals(0, longestValidParentheses("))"));
        Assert.assertEquals(2, longestValidParentheses("(()"));
    }
}
