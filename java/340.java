/**
 * id: 340 longest substring with at most k distinct characters
 * tags: sliding window
 * date: 2021-04-22
 */
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k == 0) {
            return 0;
        }
        Map<Character, Integer> lastSeen = new HashMap<>();
        Set<Character> current = new HashSet<>();
        int longest = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(!current.contains(c)) {
                if(current.size() == k) {
                    // Find the char that needs to be removed
                    Character remove = current.iterator().next();
                    for(Character ch: current) {
                        if(lastSeen.get(ch) < lastSeen.get(remove)) {
                            remove = ch;
                        }
                    }
                    start = lastSeen.get(remove) + 1;
                    current.remove(remove);
                }
                current.add(c);
            }
            lastSeen.put(c, i);
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }
}