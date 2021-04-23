/**
 * id: 41 first missing positive
 * tags: array
 * date: 2021-04-22
 * note: There is another constant space solution.
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        // since the length is 300 max, largest answer is 301
        int size = 302;
        boolean [] seen = new boolean[size];
        for(int num: nums) {
            if(num > 0 && num < size) {
                seen[num] = true;
            }
        }
        for(int i=1; i<size; i++) {
            if(!seen[i]) {
                return i;
            }
        }
        return 0;
    }
}