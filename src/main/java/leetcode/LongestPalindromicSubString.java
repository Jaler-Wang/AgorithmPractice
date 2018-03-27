package leetcode;

import java.util.Random;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 For this kind of question, we need to consider both odd and even case,
 for the odd case no one equals to the middle one;
 for the even case the middle two equals;
 */
public class LongestPalindromicSubString {
    private int startIndex = 0;
    private int length = 0;
    public String longestPalindrome(String s) {
        int random = new Random().nextInt(10);

        if(s == null || s.length() == 1) return s;
        for(int i = 0; i < s.length(); i++){
            checkPalindrom(s, i, i);
            checkPalindrom(s, i, i+1);
        }
        return s.substring(startIndex, startIndex + length + 1);
    }

    private void checkPalindrom(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        if(length < end - start - 1){
            startIndex = start + 1;
            length = end - start - 1;
        }
    }
}
