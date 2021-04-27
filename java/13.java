/**
 * id: 13 roman to integer
 * tags: math
 * date: 2021-04-27
 */
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        int value = 0;
        for(int i=0; i<s.length(); i++) {
            if(i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                value += roman.get(s.charAt(i + 1)) - roman.get(s.charAt(i));
                i++;
            } else {
                value += roman.get(s.charAt(i));
            }
        }
        return value;
        
    }
}