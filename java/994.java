/**
 * id: 994 rotting oranges
 * tags: array
 * date: 2021-04-25
 * note: bfs also works.
 */
class Solution {
    private int[][] evolve(int[][] grid) {
        int nrows = grid.length;
        int ncols = grid[0].length;
        int [][] newGrid = new int[nrows][ncols];
        for(int i=0; i<nrows; i++) {
            for(int j=0; j<ncols; j++) {
                newGrid[i][j] = grid[i][j];
                if(grid[i][j] != 1) {
                    continue;
                }
                if((i-1 >=0 && grid[i-1][j] == 2) || 
                   (i+1 < nrows && grid[i+1][j] == 2) || 
                   (j-1>=0 && grid[i][j-1] == 2) || 
                   (j+1 < ncols && grid[i][j + 1] == 2)) {
                    newGrid[i][j] = 2;
                }
            }
        }
        return newGrid;
    }
    
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    fresh += 1;
                }
            }
        }
        
        while(fresh > 0) {
            time += 1;
            grid = evolve(grid);
            int currentFresh = 0;
            // for(int i=0; i<grid.length; i++) {
            //     for(int j=0; j<grid[0].length; j++) {
            //         System.out.print(grid[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j] == 1) {
                        currentFresh += 1;
                    }
                }
            }
            if(fresh == currentFresh) {
                return -1;
            }
            fresh = currentFresh;
        }
        return time;
    }
}