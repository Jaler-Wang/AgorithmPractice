package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> elements = new HashMap<Character, Integer>();
        int length = s.length();
        int maxLength=0;
        int low = 0;

        for(int i = 0; i < length; i++){
            if(elements.containsKey(s.charAt(i))){
                low = Math.max(low, elements.get(s.charAt(i)) + 1);
            }
            maxLength = Math.max(maxLength, i - low + 1);
            elements.put(s.charAt(i), i);
        }
        return maxLength;
    }

    @Test
    public void test(){
        String input = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(input));
    }
    @Test
    public void test1(){
        String input = "bbbbb";
        System.out.println(lengthOfLongestSubstring(input));
    }
}
