/**
 * id: 9 palindrome number
 * tags: math
 * date: 2021-04-25
 */
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        } else if(x < 10){
            return true;
        }
        List<Integer> num = new ArrayList<>();
        while(x > 0) {
            num.add(x % 10);
            x /= 10;
        }
        
        int n = num.size();
        for(int i=0; i<n-i-1; i++) {
            if(num.get(i) != num.get(n-i-1)) {
                return false;
            }
        }
        return true;
    }
}