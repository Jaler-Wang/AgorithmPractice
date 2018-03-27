package leetcode;

import org.junit.Test;

public class SmallestRotationWithHighestScore {
    /*
    *Given an array A, we may rotate it by a non-negative integer K so that the array becomes A[K], A[K+1], A{K+2], ... A[A.length - 1], A[0], A[1], ..., A[K-1].
    * Afterward, any entries that are less than or equal to their index are worth 1 point.
    For example, if we have [2, 4, 1, 3, 0], and we rotate by K = 2, it becomes [1, 3, 0, 2, 4].  This is worth 3 points because 1 > 0 [no points], 3 > 1 [no points], 0 <= 2 [one point], 2 <= 3 [one point], 4 <= 4 [one point].
    * */
    public int getHighestScore(int[] data){
        int size = data.length;
        int[] score = new int[size];
        for(int i = 0; i< size; i++){
            score[i] = 0;
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(data[i] <= (i + size - j)%size){
                    score[j]++;
                }
            }
        }
        int max = score[0];
        int moveIndex = 0;
        for(int i = 1; i < size; i++){
            if(score[i] > max){
                max = score[i];
                moveIndex = i;
            }
        }
        return moveIndex;
    }

    @Test
    public void test(){
        int[] data = new int[]{2, 3, 1, 4, 0};
        System.out.println(getHighestScore(data));
    }
}
