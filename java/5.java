/**
 * id: 5 longest palindromic string
 * tags: string
 * date: 
 */
class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int longest = 0;
        // even length
        for(int i=0; i+1 < s.length(); i++) {
            int j=0;
            for(; i-j>=0 && i+1+j<s.length(); j++) {
                if(s.charAt(i-j) != s.charAt(i+j+1)) {
                    break;
                }
            }
            if(2 * j > longest) {
                longest =  2 * j;
                start = i - j + 1;
            }
        }
        
        // odd length
        for(int i=0; i<s.length(); i++) {
            int j=0;
            for(; i-j>=0 && j+i <s.length(); j++) {
                if(s.charAt(i-j) != s.charAt(i+j)) {
                    break;
                }
            }
            if(2*j - 1 > longest) {
                longest = 2 *j  -1;
                start = i - j + 1;
            }
        }
        return s.substring(start, start + longest);
    }
}