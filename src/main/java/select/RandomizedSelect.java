package select;

import org.junit.Assert;
import org.junit.Test;

import java.util.Queue;

/**
 * Created by U0148394 on 11/12/2016.
 */
public class RandomizedSelect {
    @Test
    public void getThe3LargeData(){
        int[] data = new int[]{3,4,1,5,9,6};
        int result = getTheISmallestElement(data, 0, data.length - 1, 2);
        System.out.println(result);
        Assert.assertEquals(4, result);
        Queue queue;
    }
    public int getTheISmallestElement(int[] data, int start, int end, int i) {
        if (start == end) {
            return data[start];
        }
        int mid = partition(data, start, end);
        if (mid == i) return data[i];
        if (mid > i) {
            return getTheISmallestElement(data, start, mid - 1, i);
        } else {
            return getTheISmallestElement(data, mid + 1, end, i);
        }
    }

    private int partition(int[] data, int start, int end) {
        int index = (int) ((Math.random() * (end - start)) + start);
        int i = start - 1;
        int mid = data[index];
        data[index] = data[end];
        for (int j = start; j < end; j++) {
            if (data[j] <= mid) {
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        data[end] = data[i + 1];
        data[i + 1] = mid;
        return i + 1;
    }
}
