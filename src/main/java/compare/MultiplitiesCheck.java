package compare;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two arrays a and b write a function comp(a, b) (compSame(a, b) in Clojure)
 * that checks whether the two arrays have the "same" elements, with the same multiplicities.
 * "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
 * .
 */
public class MultiplitiesCheck {
    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        System.out.println(comp(a, b));
    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) {
            return false;
        }
        if (a.length != b.length) {
            return false;
        }
        List<Integer> list = new ArrayList<Integer>(a.length);
        for(int i = 0; i < b.length; i++){
            list.add(b[i]);
        }
        for(int i = 0; i < a.length; i++){
            Integer result = a[i]*a[i];
            if(list.contains(result)){
                list.remove(result);
            }
            else{
                return false;
            }
        }
        if(list.size() == 0){
            return true;
        }
        return false;
    }
}
