/**
 * id: 3 longest substring without repeating characters
 * tags: hashmap
 * date: 2021-04-22
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> lastSeen = new HashMap<>();
        int longest = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
                start = lastSeen.get(c) + 1;
            } 
            longest = Math.max(longest, i - start + 1);
            lastSeen.put(c, i);
        }
        return longest;
    }
}