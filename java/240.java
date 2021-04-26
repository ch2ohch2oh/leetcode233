/**
 * id: 240 search a 2d matrix ii
 * tags: binary search
 * date: 2021-04-26
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // start from top right corner
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        int row = 0;
        int col = ncols - 1;
        while(row >= 0 && row < nrows && col >= 0 && col < ncols) {
            if(target < matrix[row][col]) {
                col -= 1;
            } else if(target > matrix[row][col]) {
                row += 1;
            } else {
                return true;
            }
        }
        return false;
    }
}