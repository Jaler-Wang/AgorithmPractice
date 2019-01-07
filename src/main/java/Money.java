import java.lang.reflect.Array;
import java.util.ArrayList;

public class Money {
    public static long[] rewards = new long[]{1,2,5,10};
    public static void get(long remainReward, ArrayList<Long> result){
        if(remainReward == 0){
            System.out.println(result);
            return;
        }
        if(remainReward < 0) return;
        for(int i = 0; i < rewards.length; i++){
            ArrayList<Long> newResult = (ArrayList<Long>) result.clone();
            newResult.add(rewards[i]);
            get(remainReward - rewards[i], newResult);
        }
    }

    public static void main(String[] args){
        Money.get(10, new ArrayList<Long>());
    }
}
