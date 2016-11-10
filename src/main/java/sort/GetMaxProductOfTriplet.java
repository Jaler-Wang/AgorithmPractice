package sort;


import sort.basic.HeapSort;

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
        if(array == null || array.length < 3){
            return -1;
        }
        new HeapSort().heapSort(array);
        int max1 = array[0]*array[1]*array[array.length - 1];
        int max2 = array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
        return max1 > max2? max1 : max2;
    }

}
