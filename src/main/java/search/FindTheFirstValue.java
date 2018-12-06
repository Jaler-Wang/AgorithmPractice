package search;

import org.junit.Test;

public class FindTheFirstValue {
    public int findTheFirstValue(int[] data, int value) {
        if (data == null || data.length == 0) return -1;
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            if (data[mid] == value) {
                if (mid == 0 || data[mid - 1] != value) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                if (data[mid] < value) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void findTheFirstValueTest() {
        int[] data = new int[]{1, 2, 2, 2, 2};
        int theFirstValue = findTheFirstValue(data, 2);
        System.out.println(theFirstValue);
    }
}
