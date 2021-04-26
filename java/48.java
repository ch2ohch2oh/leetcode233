/**
 * id: 48 rotate image
 * tags: array
 * date: 2021-04-26
 * note: check the bounds carefully
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<(n+1)/2; i++) {
            int end = (n % 2 == 0 ? n/2 : (n-1)/2);
            for(int j=0; j<end; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-1-j][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
    }
}