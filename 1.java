// One pass using hashmap
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        int [] res = null;
        for(int i = 0 ; i < nums.length; i++) {
            int num = nums[i];
            // complement is a better name
            int other = target - num;
            if(seen.containsKey(other) && seen.get(other) != i) {
                return new int [] {seen.get(other), i};
            }
            seen.put(num, i);
        }
        return null;
    }
}