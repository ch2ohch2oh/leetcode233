/**
 * id: 20 valid parentheses
 * tags: stack
 * date: 2021-04-22
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String pairs = "(){}[]";
        for(int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            int index = pairs.indexOf(c);
            if(index % 2 == 0) {
                // we received a left paren
                stack.push(c);
            } else if(stack.empty()) {
                return false;
            } else {
                // we received a right paren
                Character top = stack.pop();
                if(top != pairs.charAt(index - 1)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
