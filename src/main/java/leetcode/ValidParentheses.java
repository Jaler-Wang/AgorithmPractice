package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                stack.push(chars[i]);
            } else if (chars[i] == '}' || chars[i] == ']' || chars[i] == ')') {
                if(stack.isEmpty()) return false;
                Character previous = stack.pop();
                if (map.get(chars[i]) != previous) return false;
            }
        }
        return stack.isEmpty() ? true : false;
    }

    @Test
    public void test(){
        Assert.assertTrue(isValid("()[]{}"));
        Assert.assertFalse(isValid(")[]{}"));
        Assert.assertFalse(isValid("()[]{"));
        Assert.assertFalse(isValid("()[]}"));
        Assert.assertFalse(isValid("}"));
    }
}
