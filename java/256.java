/**
 * id: 256 paint house
 * tags: dp
 * date: 2021-04-26
 */
class Solution {
    public int minCost(int[][] costs) {
        int nHouses = costs.length;
        int nColors = costs[0].length;
        int[][] total = new int[nHouses][nColors];
        System.arraycopy(costs[0], 0, total[0], 0, nColors);
        for(int i=1; i<nHouses; i++) {
            for(int j=0; j<nColors; j++) {
                for(int k=0; k<nColors; k++) {
                    if(j==k) {
                        continue;
                    }
                    if(total[i][j] == 0) {
                        total[i][j] = costs[i][j] + total[i-1][k];
                    } else {
                        total[i][j] = Math.min(total[i][j], total[i-1][k] + costs[i][j]);
                    }
                }
            }
        }
        int ans = total[nHouses-1][0];
        for(int i=0; i<nColors; i++) {
            ans = Math.min(ans, total[nHouses-1][i]);
        }
        return ans;
    }
}
