/**
 * id: 528 random pick with weight
 * tags: math
 * date: 2021-04-24
 */
class Solution {
    private double [] cdf;
    private Random rand = new Random();
    
    public Solution(int[] w) {
        int n = w.length;
        int total = 0;
        for(int i=0; i<n; i++) {
            total += w[i];
        }
        
        cdf = new double[n];
        for(int i=0; i<n; i++) {
            if(i == 0) {
                cdf[i] = (double)w[i] / total;
            } else {
                cdf[i] = cdf[i-1] + (double)w[i] / total;
            }
        }
    }
    
    public int pickIndex() {
        double r = rand.nextDouble();
        for(int i=0; i<cdf.length; i++) {
            if(r <= cdf[i]) {
                return i;
            }
        }
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */