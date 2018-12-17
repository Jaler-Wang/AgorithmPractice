package string;

import java.util.HashMap;

public class BM {
    public HashMap<Character, Integer> generateBC(char[] pattern){
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        if(pattern == null || pattern.length == 0){
            return hashMap;
        }
        for(int i = 0; i < pattern.length; i++){
            hashMap.put(pattern[i], i);
        }
        return hashMap;
    }

    public int bm(char[] source, char[] pattern){
        HashMap<Character, Integer> hashMap = generateBC(pattern);
        int[] suffix = new int[pattern.length];
        boolean[] prefix = new boolean[pattern.length];
        generatesGS(pattern, suffix, prefix);
        if(source == null || pattern == null) return -1;

        int start = 0;
        while(start <= source.length - pattern.length){
            int index = pattern.length - 1;
            while(index >= 0){
                if(source[start + index] != pattern[index]){
                    break;
                }
                index--;
            }
            if(index < 0) return start;
            //bad character move step
            int si = index;
            int xi = (hashMap.get(source[start + index])) == null? -1 : hashMap.get(source[start + index]);
            int bcStep = si - xi;
            //good suffix move step
            int gsStep = 0;
            if(index < pattern.length - 1){
                gsStep = moveByGS(index, pattern.length, suffix, prefix);
            }
            start = start + Math.max(bcStep, gsStep);
        }
        return -1;
    }

    private int moveByGS(int index, int length, int[] suffix, boolean[] prefix) {
        int suffixLength = length - index - 1;
        if(suffix[suffixLength - 1] != -1){
            return suffixLength;
        }
        while(suffixLength > 0){
            if(prefix[suffixLength - 1]){
                return suffixLength;
            }
            suffixLength--;
        }
        return suffixLength;
    }

    public void generatesGS(char[] pattern, int[] suffix, boolean[] prefix){
        for(int i = 0; i < pattern.length; i++){
            suffix[i] = -1;
            prefix[i] = false;
        }
        //find the common suffix for pattern[0, i] with pattern[0, pattern.length-1]
        for(int i = 0; i < pattern.length; i++){
            int matchIndex = i;
            int matchedLength = 0;
            while(matchIndex >= 0 && pattern[matchIndex] == pattern[pattern.length - 1 - matchedLength]){
                suffix[matchedLength] = matchIndex;
                matchedLength++;
                matchIndex--;
            }
            if(matchIndex < 0){
                prefix[i] = true;
            }
        }
    }

}
