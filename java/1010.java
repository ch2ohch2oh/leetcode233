/**
 * id: 1010 pairs of songs with total durations divisible by 60
 * tags: array
 * date: 2020-04-22
 * note: Can use an array as the hashmap
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : time) {
            int mod = t % 60;
            if(map.containsKey(mod)) {
                map.put(mod, map.get(mod) + 1);
            } else {
                map.put(mod, 1);
            }
        }
        
        int count = 0;
        for(Integer mod : map.keySet()) {
            if(mod == 0 || mod == 30) {
                int c = map.get(mod);
                count += c * (c - 1) / 2;
            } else if (mod < 30) {
                int c1 = map.get(mod);
                int c2 = map.containsKey(60 - mod) ? map.get(60 - mod) : 0;
                count += c1 * c2;
            }
        }
        
        return count;
    }
}
