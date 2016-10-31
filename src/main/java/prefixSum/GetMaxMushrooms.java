package prefixSum;

/**
 * Problem: You are given a non-empty, zero-indexed array A of n (1 ¬ n ¬ 100 000) integers
 * a0, a1, . . . , an−1 (0 ¬ ai ¬ 1 000). This array represents number of mushrooms growing on the
 * consecutive spots along a road. You are also given integers k and m (0 ¬ k, m < n).
 * A mushroom picker is at spot number k on the road and should perform m moves. In
 * one move she moves to an adjacent spot. She collects all the mushrooms growing on spots
 * she visits. The goal is to calculate the maximum number of mushrooms that the mushroom
 * picker can collect in m moves.
 * For example, consider array A such that:
 * 2 3 7 5 1 3 9
 * The mushroom picker starts at spot k = 4 and should perform m = 6 moves. She might
 * move to spots 3, 2, 3, 4, 5, 6 and thereby collect 1 + 5 + 7 + 3 + 9 = 25 mushrooms. This is the
 * maximal number of mushrooms she can collect.
 * source from: https://codility.com/media/train/3-PrefixSums.pdf
 */

public class GetMaxMushrooms {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 7, 5, 1, 3, 9};
        int start = 4;
        int moves = 6;

        System.out.println(Integer.MAX_VALUE);
        for(int i = 1; i < a.length; i++){
            a[i] += a[i-1];
        }
        int max = 0;
        for(int i = 0; i < moves; i++){
            int left = Math.max(0, start - i - 1);
            int right = Math.min(a.length - 1, start + (moves - i*2));
            int sum = a[right] - a[left];
            if(sum > max){
                max = sum;
            }
        }
        System.out.println("max mushromm he can get is " + max);
    }
}
