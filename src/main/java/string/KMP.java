package string;

public class KMP {
    public int kmp(char[] source, char[] pattern) {
        if (source == null || pattern == null) return -1;
        int[] next = getNext(pattern);
        int index = 0;
        for (int sIndex = 0; sIndex < source.length; sIndex++) {
            while (index > 0 && source[sIndex] != pattern[index]) {
                index = next[index - 1] + 1;
            }
            if (source[sIndex] == pattern[index]) {
                index++;
            }
            if (index == pattern.length) {
                return sIndex - pattern.length + 1;
            }
        }
        return -1;
    }

    private int[] getNext(char[] pattern) {
        if(pattern == null) return null;
        int[] next = new int[pattern.length];
        for(int i = 0; i < next.length; i++){
            next[i] = -1;
        }
        int k = -1;
        for(int i = 1; i < pattern.length; i++){
            while(k != -1 && pattern[k + 1] != pattern[i]){
                k = next[k];
            }
            if(pattern[k + 1] == pattern[i]){
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
