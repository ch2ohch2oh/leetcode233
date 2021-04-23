/**
 * id: 59 generate spiral matrix
 * tags: array
 * date: 2021-04-21
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        int dir = 0;
        int [][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        for(int i=1; i<=n*n; i++) {
            res[row][col] = i;
            int nextRow = row + moves[dir][0];
            int nextCol = col + moves[dir][1];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || res[nextRow][nextCol] > 0) {
                dir = (dir + 1) % 4;
                nextRow = row + moves[dir][0];
                nextCol = col + moves[dir][1];
            }
            row = nextRow;
            col = nextCol;
        }
        return res;
    }
}