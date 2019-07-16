package array;

import org.junit.Test;

public class MergeArray {
    public static int[] merge(int[] data1, int[] data2){
        if(data1 == null || data1.length == 0) return data2;

        if(data2 == null || data2.length == 0) return data1;
        int[] result = new int[data1.length + data2.length];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while(index1 < data1.length || index2 < data2.length){
            if(index1 == data1.length){
                while(index2 < data2.length){
                    result[index++] = data2[index2++];
                }
                break;
            }
            if(index2 == data2.length){
                while(index1 < data1.length){
                    result[index++] = data1[index1++];
                }
                break;
            }
            result[index++] = (data1[index1] < data2[index2]) ? data1[index1++]:data2[index2++];
        }
        return result;
    }

    @Test
    public void test(){
        int[] data1 = new int[]{1,3,5,7,8};
        int[] data2 = new int[]{2,4,6,8,10};
        int[] result = merge(data1, data2);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
        }
    }
}
