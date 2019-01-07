import java.lang.reflect.Array;
import java.util.ArrayList;

public class Divide {
    public static void divide(int target, ArrayList<Integer> result){
        if(target <= 2){
            result.add(target);
            System.out.println(result);
            return;
        }
        for(int i = 2; i <= target; i++){
            if(target % i == 0){
                ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
                newResult.add(i);
                divide(target/i, newResult);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Divide.divide(8, result);
    }
}
