import org.junit.Test;

public class KnapSack {
    public int knapSack(int[] items, int w) {
        int n = items.length;
        boolean[] status = new boolean[w + 1];
        status[0] = true;
        status[items[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = w - items[i]; j >= 0; j--) {
                if (status[j]) {
                    status[j + items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; i--) {
            if (status[i] == true) return i;
        }
        return -1;
    }

    public int knapSack1(int[] weight, int[] value, int n, int w) {
        int[] currentValue = new int[w + 1];
        for (int i = 0; i <= w; i++) {
            currentValue[i] = -1;
        }
        currentValue[0] = 0;
        currentValue[weight[0]] = value[0];
        for (int i = 1; i < n; i++) {
            for (int j = w - weight[i]; j >= 0; j--) {
                int cw = currentValue[j] + value[i];
                if (cw > currentValue[j + weight[i]]) {
                    currentValue[j + weight[i]] = cw;
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i <= w; i++) {
            if (currentValue[i] > maxValue) {
                maxValue = currentValue[i];
            }
        }
        return maxValue;
    }


    @Test
    public void test() {
        int[] weight = new int[]{2, 2, 4, 6, 3};
        int[] value = new int[]{3, 4, 8, 9, 6};
        int maxValue = knapSack1(weight, value, 5, 9);
        System.out.println(maxValue);

    }
}
