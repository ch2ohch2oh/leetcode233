/**
 * id: 398 random pick index
 * tags: hashmap
 * date: 2021-04-24
 * note: also checkout reservoir sampling
 */
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random rand = new Random();
    
    public Solution(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                // System.out.println("map contains " + nums[i]);
                List<Integer> indicies = map.get(nums[i]);
                // System.out.println("indicies = " + indicies);
                indicies.add(i);
            } else {
                // The List<T> returned by Arrays.asList() does not implement `add` method.                 
                map.put(nums[i], new ArrayList<Integer>(Arrays.asList(i)));
            }
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = map.get(target);
        return indices.get(rand.nextInt(indices.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */