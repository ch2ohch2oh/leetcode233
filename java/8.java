/**
 * id: 8 string to integer (atoi)
 * tags: string
 * date: 2021-04-26
 */
class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int high = (1 << 31) - 1;
        int low = - (1 << 31);
        
        int sign = 1;
        long value = 0;
        int idx = 0;
        while(idx < s.length() && Character.isWhitespace(s.charAt(idx))) {
            idx++;
        }
        if(idx == s.length()) {
            return 0;
        }
        if(s.charAt(idx) == '+') {
            sign = 1;
            idx++;
        } else if(s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        }
        while(idx < s.length()) {
            char c = s.charAt(idx++);
            if(!Character.isDigit(c)) {
                break;
            }
            value *= 10;
            value += c - '0';
            if(value * sign > high) {
                return high;
            } else if(value * sign < low) {
                return low;
            }
        }
        return (int)(sign * value);
    }
}