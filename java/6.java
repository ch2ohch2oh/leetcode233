/**
 * id: 6 zigzag conversion
 * tags: array
 * date: 2021-04-25
 * note: take a look at the solution - the exact zig-zag shape actually does not matter.
 */
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        
        int n = s.length();
        int rep = n / (2 * numRows - 2);
        int remainder = n % (2 * numRows - 2);
        int numCols = (numRows - 1) * rep;
        if(remainder == 0) {
            // do nothing
        } else if(remainder <= numRows) {
            numCols += 1;
        } else {
            numCols += remainder - numRows + 1;
        }
        
        char [][] board = new char[numRows][numCols];
        int idx = 0;
        int col = 0;
        while(idx < n) {
            for(int i=0; i<numRows && idx < n; i++) {
                board[i][col] = s.charAt(idx++);
            }
            for(int i=1; i<numRows-1 && idx <n; i++) {
                board[numRows -i-1][col+i] = s.charAt(idx++);
            }
            col += numRows - 1;
        }
        
        StringBuilder builder = new StringBuilder();
        
        // for(int i=0; i<numRows; i++) {
        //     for(int j=0; j<numCols; j++) {
        //         if(board[i][j] != '\0') {
        //             System.out.print(board[i][j]);
        //         } else {
        //             System.out.print(' ');
        //         }
        //     }
        //     System.out.println();
        // }
        
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numCols; j++) {
                if(board[i][j] != '\0') {
                    builder.append(board[i][j]);
                }
            }
        }
        return builder.toString();
    }
}