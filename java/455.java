/**
 * id: 455 assign cookies
 * tags: greedy
 * date: 2021-04-26
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(s.length == 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i < g.length && j < s.length) {
            if(g[i] <= s[j]) {
                ans += 1;
                i += 1;
                j += 1;
            } else {
                j+= 1;
            }
        }
        return ans;
    }
}