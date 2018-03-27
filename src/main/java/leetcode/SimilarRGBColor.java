package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimilarRGBColor {
    // https://leetcode.com/articles/similar-rgb-color/
    public String similarRGBColor(String input){
        if(input.length() < 7){
            return input;
        }
        String result = "#";
        List<Character> metadata = Arrays.asList('F', 'E', 'D', 'C', 'B', 'A', '9', '8', '7'
        ,'6', '5', '4', '3', '2', '1', '0');

        for(int i = 2; i < input.length(); i+=2){
            Character c = input.charAt(i);
            Character lastC = input.charAt(i-1);
            if(metadata.indexOf(c) <= 7){
                result += lastC;
            }
            else{
                if(lastC == '0'){
                    result += '0';
                }
                else{
                    result += metadata.get(metadata.indexOf(lastC)+1);
                }
            }
        }
        return result;
    }

    @Test
    public void test(){
        String input = "#F1FC08";
        System.out.println(similarRGBColor(input));
    }
}
