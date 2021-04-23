/**
 * id: 159 longest substring with at most two distinct characters
 * tags: sliding window
 * date: 2021-04-22
 * related: 3, 340
 */
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        List<Character> current = new ArrayList<>();
        int start = 0;
        int longest = 0;
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if(current.size() == 2 && !current.contains(c)) {
                int remove = 0;
                // Find which lastSeen is early
                for(int j=0; j<current.size(); j++) {
                    if(lastSeen.get(current.get(j)) < lastSeen.get(current.get(remove))) {
                        remove = j;
                    }
                }
                start = lastSeen.get(current.get(remove)) + 1;
                current.remove(remove);
                current.add(c);
            } else if (current.size() < 2 && !current.contains(c)) {
                current.add(c);
            }
            lastSeen.put(c, i);
            longest = Math.max(longest, i - start + 1);
            // System.out.println(current.toString());
        }
        return longest;
    }
}