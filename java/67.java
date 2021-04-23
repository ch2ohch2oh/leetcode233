/**
 * id: 67 add binary numbers
 * tag: string
 * date: 2021-04-21
 */
class Solution {
    public String addBinary(String a, String b) {
        int minlen = Math.min(a.length(), b.length());
        List<Integer> ans = new ArrayList<Integer>();
        int carry = 0;
        for(int i=1; i<=minlen; i++) {
            int d1 = Character.getNumericValue(a.charAt(a.length() - i));
            int d2 = Character.getNumericValue(b.charAt(b.length() - i));
            int d = d1 + d2 + carry;
            carry = d / 2;
            ans.add(d % 2);
        }
        // Let a be the longer string
        if(b.length() > a.length()) {
            a = b;
        }
        for(int i=minlen + 1; i <= a.length(); i++) {
            int d1 = Character.getNumericValue(a.charAt(a.length() - i));
            int d = d1 + carry;
            carry = d / 2;
            ans.add(d % 2);
        }
        if(carry > 0) {
            ans.add(carry);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=ans.size() - 1; i>=0; i--) {
            sb.append(ans.get(i).toString());
        }
        return sb.toString();
    }
}