package useful;

import java.util.ArrayList;
import java.util.List;

/**
    for most of substring problem, we are given a string
    and need to find a substring of it which satisfy some restrictions.
    the general method is we use two point startPoint and endPoint to include the substring
 `  then move the endPoint, if the new substring don't match the rule then move forward the startPoint to
    make the substring match the rule again

 */


public class subString {
    public List<Integer> findAnagrams(String s, String p){
        if(s == null || p == null) return null;
        List<Integer> result = new ArrayList<Integer>();
        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        int[] pattern = new int[258];
        for(int i = 0; i < pattern.length; i++){
            pattern[i] = 0;
        }
        for(int i = 0; i < p.length(); i++){
            pattern[p.charAt(i)]++;
        }

        while(endIndex < s.length()){
            if(pattern[s.charAt(endIndex)] > 0){
                count++;
            }
            pattern[s.charAt(endIndex)]--;
            endIndex++;

            if(count == p.length()){
                result.add(startIndex);
            }
            if(endIndex - startIndex == p.length()){
                if(pattern[s.charAt(startIndex)] >=0) {
                    count--;
                }
                pattern[s.charAt(startIndex)]++;
                startIndex++;
            }
        }
        return result;
    }
}
