package sort;


import java.util.Arrays;

/**
 * Created by Jaler on 11/8/2016.
 */
public class GetMaxProductOfTriplet {
    public static void main(String[] args) {
        int array[] = new int[]{-3, 1, 2, -2, 5, 6};
        int result = getMaxProduct(array);
        System.out.println(result);
    }

    private static int getMaxProduct(int[] array) {
        int[] negative = new int[array.length];
        int[] positive = new int[array.length];
        int negIndex = 0;
        int posIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= 0) {
                negative[negIndex++] = array[i];
            } else {
                positive[posIndex++] = array[i];
            }
        }
        if (negIndex > 1) {
            Arrays.sort(negative, 0, negIndex);
        }

        if (posIndex > 1) {
            Arrays.sort(positive, 0, posIndex);
        }
        if (negIndex == 0) {
            return positive[posIndex - 1] * positive[posIndex - 2] * positive[posIndex - 3];
        }
        if (posIndex == 0) {
            return negative[negIndex - 1] * negative[negIndex - 2] * negative[negIndex - 3];
        }
        if (negIndex > 1 && posIndex == 1) {
            return negative[0] * negative[1] * positive[0];
        }
        if (negIndex == 1 && posIndex > 1) {
            return positive[posIndex - 1] * positive[posIndex - 2] * positive[posIndex - 3];
        }
        int max1 = Integer.MIN_VALUE;
        if(posIndex > 2){
            max1 = positive[posIndex - 1] * positive[posIndex - 2] * positive[posIndex - 3];
        }
        int max2 = Integer.MIN_VALUE;
        if(negIndex > 2) {
            max2 = negative[0] * negative[1] * positive[posIndex - 1];
        }
        return max1 > max2 ? max1 : max2;
    }

}
