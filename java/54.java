/**
 * id: 54 spiral order
 * tags: array
 * date: 2021-04-21
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        boolean [][] seen = new boolean[nrows][ncols];
        int [][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        int dir = 0;
        for(int i=0; i<nrows*ncols; i++) {
            res.add(matrix[row][col]);
            // System.out.println("row=" + row + "col=" + col);
            seen[row][col] = true;
            int nextRow = row + moves[dir][0];
            int nextCol = col + moves[dir][1];
            if(nextRow < 0 || nextRow >= nrows || nextCol < 0 || nextCol >= ncols || seen[nextRow][nextCol]) {
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