package dp;

import org.junit.Test;

public class FindMaxLengthSeq {
    public int maxSubSeqLength(int[] data){
        if(data == null || data.length == 0) return 0;
        int n = data.length;
        int[] states = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                states[j] = 1;
            }
        }
        states[0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(data[j] < data[i]){
                    int newLength = states[j] + 1;
                    if(newLength > states[i]){
                        states[i] = newLength;
                    }
                }
            }
        }
        int maxLength = 0;

        for(int i = 0; i < n; i++){
            if(states[i] > maxLength){
                maxLength = states[i];
            }
        }
        return maxLength;
    }

    @Test
    public void test(){
        int[] data = new int[]{2,9,3,6,5,1,7};
        int maxLength = maxSubSeqLength(data);
        System.out.println(maxLength);
    }
}
