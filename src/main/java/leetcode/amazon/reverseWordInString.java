package leetcode.amazon;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/7 0007.
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 solution:
    pay attention to the boundary; turn two times, the word will be the before one, so we can reverse all the words,
 then reverse eache word separately.
 */
public class reverseWordInString {
    public void reverseWords(char[] s) {
        int startIndex = 0;
        int endIndex = s.length - 1;
        reverseWord(s, startIndex, endIndex);
        startIndex = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverseWord(s, startIndex, i - 1);
                startIndex = i + 1;
            }
        }
        reverseWord(s, startIndex,s.length -1);
    }

    private void reverseWord(char[] s, int startIndex, int endIndex) {
        while(startIndex < endIndex){
            char temp = s[startIndex];
            s[startIndex] = s[endIndex];
            s[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    private void output(char[] data){
        for(char c : data){
            System.out.print(c);
        }
        System.out.println();
    }
    @Test
    public void test(){
        char[] data = "my name is Jaler Wang".toCharArray();
        reverseWords(data);
        for(char c : data){
            System.out.print(c);
        }
    }
}
