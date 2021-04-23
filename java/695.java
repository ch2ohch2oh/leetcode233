/**
 * id: 695 max area of island
 * tags: dfs
 * date: 2021-04-22
 */
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = findAndClear(grid, i, j);
                    if(area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
    
    private int findAndClear(int[][] grid, int row, int col) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int area = 1;
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i=0; i<moves.length; i++) {
            area += findAndClear(grid, row + moves[i][0], col + moves[i][1]);
        }
        return area;
    }
}