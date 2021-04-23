/**
 * id: 200 number of islands
 * tags: dfs
 * date: 2021-04-21
 */
class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i=0; i < grid.length; i++) {
            for(int j=0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    clearIsland(grid, i, j);
                    num += 1;
                }
            }
        }
        return num;
    }
    
    private void clearIsland(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        int [][] moves = {{0, 1}, {0, -1}, {-1, 0,}, {1, 0}};
        for(int k=0; k < moves.length; k++) {
            clearIsland(grid, i + moves[k][0], j + moves[k][1]);
        }
    }
}