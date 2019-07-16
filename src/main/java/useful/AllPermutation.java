package useful;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation {
    public void allPermutation(List<Integer> data){
        allPermutation(data, new StringBuilder());
    }
    public void allPermutation(List<Integer> data, StringBuilder sb){
        if(data.size() == 1) {
            System.out.println(sb.append(data.get(0)).toString());
            return;
        }
        for (Integer ele : data) {
            StringBuilder sub = new StringBuilder(sb);
            List<Integer> newList = new ArrayList<>(data);
            newList.remove(ele);
            allPermutation(newList, sub.append(ele));
        }
    }

    @Test
    public void test(){
        List<Integer> data = new ArrayList<Integer>();
        data.add(5);
        data.add(6);
        data.add(7);

        allPermutation(data);
    }
}
