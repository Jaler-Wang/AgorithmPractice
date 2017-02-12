import org.junit.Test;

/**
 * Created by U0148394 -Jianle.Wang on 2/5/2017.
 */
public class Solution {

    public static int totalScore(String[] blocks, int n) {
        // WRITE YOUR CODE HERE
        if (n == 0) return 0;
        int lastIndex = -1;
        for (int i = 0; i < blocks.length; i++) {
            if(blocks[i].matches("-?\\d*")){  //should use \\d+
                blocks[++lastIndex] = blocks[i];
                continue;
            }
            if (blocks[i].equals("Z")) {
                if (lastIndex >= 0) {
                    lastIndex--;
                }
                continue;
            }
            if (blocks[i].equals("X")) {
                if(lastIndex > -1){
                    int result = Integer.parseInt(blocks[lastIndex]) * 2;
                    blocks[++lastIndex] = String.valueOf(result);
                }
                continue;
            }
            if(blocks[i].equals("+")){
                int result = 0;
                if(lastIndex < 0){
                    continue;
                }
                if(lastIndex > 1){  //should be >=
                    result = Integer.parseInt(blocks[lastIndex]) + Integer.parseInt(blocks[lastIndex - 1]);
                    blocks[++lastIndex] = String.valueOf(result);
                    continue;
                }
                blocks[++lastIndex] = blocks[lastIndex - 1];
            }
        }
        int totalScore = 0;
        for(int i = 0; i <= lastIndex; i++){
            totalScore += Integer.parseInt(blocks[i]);
        }
        return totalScore;
    }

    public static int bstDistance(int[] values, int n, int node1, int node2)
    {
        if(n == 0) return -1;
        int commomParent = -1;
        int commonParentIndex = -1;
        boolean node1Exist = false;
        boolean node2Exist = false;
        for(int i = 0; i < n; i++){
            if(values[i] == node1){
                node1Exist = true;
            }
            if(values[i] == node2){
                node2Exist = true;
            }
        }
        if(!node1Exist || !node2Exist) return -1;
        for(int i = 0; i < n; i++){
            if(values[i] > node1 && values[i] <= node2 ||
                    values[i] <= node1 && values[i] > node2){
                commomParent = values[i];
                commonParentIndex = i;
                break;
            }
        }
        if(commomParent == -1) return -1;
        int node1Length = 0;
        int node2Length = 0;
        if(node1 < commomParent){
            node1Length = findInLeft(values, n, commonParentIndex + 1, commomParent, node1);
        }
        else if(node1 > commomParent){
            node1Length = findInRight(values, n, commonParentIndex + 1, commomParent, node1);
        }

        if(node2 < commomParent){
            node2Length = findInLeft(values, n, commonParentIndex + 1, commomParent, node2);
        }
        else if(node2 > commomParent){
            node2Length = findInRight(values, n, commonParentIndex + 1, commomParent, node2);
        }
        return node1Length + node2Length;
    }

    private static int findInLeft(int[] values, int n, int index, int parent, int node) {
        if(index >= n) return 0;
        while(parent < values[index] && index < n){
            index++;
        }
        if(values[index] == node) return 1;
        if(node < values[index]){
            return findInLeft(values, n, index+1, values[index], node) + 1;
        }
        else{
            return findInRight(values, n, index+1, values[index], node) + 1;
        }
    }

    private static int findInRight(int[] values, int n, int index, int parent, int node) {
        if(index >= n) return 0;
        while(parent > values[index] && index < n){
            index++;
        }
        if(values[index] == node) return 1;
        if(node < values[index]){
            return findInLeft(values, n, index+1, values[index], node) + 1;
        }
        else{
            return findInRight(values, n, index+1, values[index], node) + 1;
        }
    }

    @Test
    public void test() {
//        String[] blocks = new String[]{"5", "-2", "4", "Z", "X", "9", "+", "+"};
////        totalScore(blocks, 8);
//        System.out.println(totalScore(blocks, 8));
        int[] values = new int[]{5, 6, 3, 1,2,4};
        System.out.println(bstDistance(values, 6, 2, 4));
    }
}
