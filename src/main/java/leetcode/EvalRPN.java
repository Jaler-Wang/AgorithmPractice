package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("-?\\d+")) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int op1 = stack.pop();
                int op2 = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op2 - op1);
                        break;
                    case "*":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op2 / op1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    @Test
    public void test1() {
        String[] data = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Assert.assertEquals(22, evalRPN(data));
        data = new String[]{"2", "1", "+", "3", "*"};
        Assert.assertEquals(9, evalRPN(data));
        data = new String[]{"4", "13", "5", "/", "+"};
        Assert.assertEquals(6, evalRPN(data));

    }
}
