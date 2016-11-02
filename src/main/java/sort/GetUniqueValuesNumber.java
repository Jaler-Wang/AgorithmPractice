package sort;

/**
 * You are given a zero-indexed array A consisting of n > 0 integers; you must return
 * the number of unique values in array A.
 */
public class GetUniqueValuesNumber {
    public static void main(String[] args) {
        int[] data = new int[]{1, 3, 2, 7, 9, 10, 4, 1, 2, 3};
        mergeSort(data, 0, data.length - 1);

        int count = 1;
        int value = data[0];
        for(int i = 1; i < data.length; i++){
            if(value != data[i]){
                count++;
                value = data[i];
            }
        }
        System.out.println(count);
    }

    private static void mergeSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(data, start, mid);
        mergeSort(data, mid + 1, end);
        merge(data, start, mid, end);
    }

    private static void merge(int[] data, int start, int mid, int end) {
        int[] left = new int[mid - start + 2];
        int[] right = new int[end - mid + 1];
        int lStart = start;
        int rStart = mid + 1;
        for (int i = 0; i < left.length - 1; i++) {
            left[i] = data[lStart++];
        }
        for (int i = 0; i < right.length - 1; i++) {
            right[i] = data[rStart++];
        }
        left[left.length - 1] = Integer.MAX_VALUE;
        right[right.length - 1] = Integer.MAX_VALUE;

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = start; i <= end; i++) {
            if (left[leftIndex] < right[rightIndex]) {
                data[i] = left[leftIndex++];
            } else {
                data[i] = right[rightIndex++];
            }
        }
    }

}
