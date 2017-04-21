package useful.leetcode;

import org.junit.Test;

/**
 * Created by U0148394 -Jianle.Wang on 4/20/2017.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 0;
        int row = dungeon.length - 1;
        int col = dungeon[0].length - 1;
        while (row >= 0 || col >= 0){
            int i = row;
            int j = col - 1;
            while(i >= 0 && col >= 0){
                int min = getMin(dungeon, col, i, i + 1, col + 1);
                dungeon[i][col] = Math.max(1, min - dungeon[i][col]);
                i--;
            }

            while(j >= 0 && row >= 0){
                int min = getMin(dungeon, j, row, row + 1, j + 1);
                dungeon[row][j] = Math.max(1, min - dungeon[row][j]);
                j--;
            }
            if(row >= 0) row--;
            if(col >= 0) col--;
        }
        output(dungeon);
        return dungeon[0][0];
    }

    private void output(int[][] dungeon) {
        for(int i = 0; i < dungeon.length; i++){
            for(int j = 0; j < dungeon[0].length; j++){
                System.out.print(dungeon[i][j] + " ");
            }
            System.out.println();
        }
    }

    private int getMin(int[][] dungeon, int col, int row, int downRow, int rightCol) {
        int down = getLast(downRow, col, dungeon);
        int right = getLast(row, rightCol, dungeon);
        if(down < 0 && right < 0) return 1;
        if(down < 0) return right;
        if(right < 0) return down;
        return Math.min(down, right);
    }

    private int getLast(int i, int j, int[][] dungeon) {
        if(i >= dungeon.length || j >= dungeon[0].length || i < 0 || j < 0){
            return -1;
        }
        return dungeon[i][j];
    }

    @Test
    public void test(){
        int[][] data = new int[][]{
//                {-200}
                {2, 1},
                {1, -1}
        };
        System.out.println(calculateMinimumHP(data));
    }
}

class Status{
    int min;
    int remain;
    public Status(){

    }
    public Status(int remain, int min){
        this.remain = remain;
        this.min = min;
    }

    public int compare(Status data){
        if(min < data.min) return -1;
        if(min == data.min){
            if (remain >= data.remain) return -1;
            return 1;
        }
        return 1;

    }
}