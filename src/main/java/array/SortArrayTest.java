package array;

import org.junit.Test;

import java.util.Random;

public class SortArrayTest {
    SortArray sortArray = new SortArray(10);
    @Test
    public void findLocationTest(){
        for(int i = 0; i < 10; i++){
            sortArray.add(i);
        }
        sortArray.output();
        sortArray.delete(5);
        sortArray.delete(0);
        sortArray.delete(9);
        sortArray.update(6, 17);
        sortArray.update(19, 18);
        sortArray.output();
    }

    @Test
    public void sortWithRandomData(){
        Random random = new Random();
        for(int i = 0; i < 10; i++){
            int d = random.nextInt(11);
            sortArray.add(d);
        }
        sortArray.output();

    }
}
