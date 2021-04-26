/**
 * id: 953 verifying an alien dictionary
 * tags: sort, string
 * date: 2021-04-25
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1) {
            return true;
        }
        Map<Character, Integer> orderMap = new HashMap<>();
        for(int i=0; i<order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        for(int i=0; i<words.length-1; i++) {
            String a = words[i];
            String b = words[i + 1];
            int len = Math.min(a.length(), b.length());
            int j = 0;
            while(j < len) {
                int oa = orderMap.get(a.charAt(j));
                int ob = orderMap.get(b.charAt(j));
                if(oa > ob) {
                    return false;
                } else if(oa < ob) {
                    break;
                }
                j += 1;
            }
            if(j == len && a.length() > b.length()) {
                return false;
            }
        }
        return true;
    }
}