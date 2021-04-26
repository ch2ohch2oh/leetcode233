/**
 * id: 763 partition labels
 * tags: two pointers
 * date: 2021-04-26
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lastseen = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<S.length(); i++) {
            Character c = S.charAt(i);
            lastseen.put(c, i);
        }
        int start = 0;
        int end = 0;
        for(int i=0; i<S.length(); i++) {
            Character c = S.charAt(i);
            end = Math.max(lastseen.get(c), end);
            if(end == i) {
                ans.add(end - start + 1);
                start = end = end + 1;
            }
        }
        return ans;
    }
}