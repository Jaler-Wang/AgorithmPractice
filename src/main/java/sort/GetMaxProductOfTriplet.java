package sort;


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
//        quickSort(array, );
        return -1;
    }

    private static void quickSort(int[] array) {

    }

}
