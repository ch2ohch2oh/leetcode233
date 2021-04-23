/**
 * id: 14 longest common prefix
 * tags: string
 * date: 2021-04-22
 * note:
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        } else if(strs.length == 1) {
            return strs[0];
        } else {
            int longest = strs[0].length();
            for(int i=1; i<strs.length; i++) {
                String a = strs[i-1];
                String b = strs[i];
                int pos = 0;
                while(pos<a.length() && pos < b.length() && a.charAt(pos) == b.charAt(pos)) {
                    pos++;
                }
                if(pos < longest) {
                    longest = pos;
                }
            }
            return strs[0].substring(0, longest);
        }
    }
}