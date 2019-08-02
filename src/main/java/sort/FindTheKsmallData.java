package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class FindTheKsmallData {
    public int findTheKSmallData(int[] data, int k) {
        if (data == null || data.length < k) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (d1, d2) -> d2 - d1);
        for (int i = 0; i < k; i++) {
            heap.add(data[i]);
        }

        for (int i = k; i < data.length; i++) {
            if (data[i] < heap.peek()) {
                heap.poll();
                heap.add(data[i]);
            }
        }
        return heap.peek();
    }

    @Test
    public void test() {
        int[] data = new int[]{5, 3, 7, 2, 9, 1};
        Assert.assertEquals(3, findTheKSmallData(data, 3));
    }
}
