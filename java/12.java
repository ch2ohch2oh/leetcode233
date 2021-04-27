/**
 * id: 12 integer to roman
 * tags: math
 * date: 2021-04-25
 * note: see solution for method without hardcoding the digits
 */
class Solution {
    public String intToRoman(int num) {
        String[][] roman = {
            new String [] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            new String [] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            new String [] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            new String [] {"", "M", "MM", "MMM"}
        };
        StringBuilder builder = new StringBuilder();
        int idx = 0;
        while(num > 0) {
            builder.insert(0, roman[idx][num % 10]);
            num /= 10;
            idx += 1;
        }
        return builder.toString();
    }
}