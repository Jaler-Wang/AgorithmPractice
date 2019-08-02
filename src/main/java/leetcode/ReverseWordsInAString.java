package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.reverse;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s == null|| s.trim() == null) return null;
        s = s.trim().replaceAll("\\s+", " ");
        char[] data = s.toCharArray();
        reverseString(data, 0, data.length - 1);
        reverseWords(data);
        return new String(data);
    }

    private void reverseWords(char[] data) {
        int start = 0;
        int end = 0;
        while(start < data.length) {
            end = findSpaceEnd(data, start + 1);
            reverseString(data, start, end);
            start = end + 2;
        }
    }

    private int findSpaceEnd(char[] data, int start){
        int index = start;
        while(index < data.length && data[index] != ' '){
            index++;
        }
        return index - 1;
    }
    private void reverseString(char[] data, int start, int end) {
        while (start < end) {
            char tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;
            start++;
            end--;
        }
    }

    @Test
    public void test(){
        String result = reverseWords("the sky is blue");
        System.out.println(result);
        String[] data = new String[]{"hello", "world"};
        reverse(Arrays.asList(data));
        for (String s : data) {
            System.out.println(s);
        }
    }
}
