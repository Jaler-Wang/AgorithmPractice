package dp;

import org.junit.Test;

/**
 * Created by U0148394 -Jianle.Wang on 1/31/2017.
 */
public class RodCut {
    public int maxRevenue (int[] prices, int length, int[] size){
        int[] revenue = new int[length + 1];
        revenue[0] = 0;
        for(int i = 1; i <= length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(max < prices[j] + revenue[i - j - 1]){
                    max = prices[j] + revenue[i - j - 1];
                    size[i] = j+1;
                }
            }
            revenue[i] = max;
        }
//        output(revenue);
        return revenue[length];
    }

    private void output(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void whenGivenLength4ThenReturn10(){
        int[] prices = new int[]{1,5,8,9, 10, 17, 17, 20, 24, 30};
        System.out.println(maxRevenue(prices, 4, new int[5]));
    }

    @Test
    public void whenGivenLength10ThenReturn30(){
        int[] prices = new int[]{1,5,8,9, 10, 17, 17, 20, 24, 30};
        int[] cuts = new int[11];
        System.out.println(maxRevenue(prices, 10, cuts));
        output(cuts);
    }
}
