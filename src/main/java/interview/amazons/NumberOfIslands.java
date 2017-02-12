package interview.amazons;

/**
 * Created by U0148394 -Jianle.Wang on 2/9/2017.
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded
 * by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid){
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    turn(i, j, grid);
                }
            }
        }
        return count;
    }

    private void turn(int i, int j, char[][] grid) {
        if(i < 0 || i > grid.length){
            return;
        }
        if(j < 0 || j > grid[0].length){
            return;
        }
        if(grid[i][j] == '0') return;
        grid[i][j] = '0';
        turn(i - 1, j, grid);
        turn(i + 1, j, grid);
        turn(i, j + 1, grid);
        turn(i, j - 1, grid);
    }
}
