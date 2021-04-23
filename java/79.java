/**
 * id: 79 word search
 * tag: dfs
 * date: 2021-04-21
 */
class Solution {
    private boolean [][] seen;
    public boolean exist(char[][] board, String word) {
        int nrows = board.length;
        int ncols = board[0].length;
        seen = new boolean[nrows][ncols];        
        for(int i=0; i<nrows; i++) {
            for(int j=0; j<ncols; j++){
               if(findWord(board, word, i, j, 0)) {
                   return true;
               }
            }
        }
        return false;
    }
    
    private boolean findWord(char[][] board, String word, int row, int col, int index) {
        if(word.length() <= index) {
            return true;
        } else if(board[row][col] != word.charAt(index)) {
            return false;
        }
        if(word.length() == index + 1) {
            return true;
        }
        seen[row][col] = true;
        int [][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i=0; i<moves.length; i++) {
            int nextRow = row + moves[i][0];
            int nextCol = col + moves[i][1];
            if(nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length
               && !seen[nextRow][nextCol]) {
                if(findWord(board, word, nextRow, nextCol, index + 1)) {
                    return true;
                }
            }
        }
        seen[row][col] = false;
        return false;
    }
}
