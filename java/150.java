/**
 * id: 150 evaluate reverse polish notation
 * tags: stack
 * date: 2021-04-26
 * note: I think the exception handling makes the code slow
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for(String t: tokens) {
            try {
                int value = Integer.parseInt(t);
                nums.push(value);
            } catch(NumberFormatException e) {
                int b = nums.pop();
                int a = nums.pop();
                if(t.equals("+")) {
                    nums.push(a + b);    
                } else if(t.equals("-")) {
                    nums.push(a - b);
                } else if(t.equals("*")) {
                    nums.push(a * b);
                } else if(t.equals("/")) {
                    nums.push(a / b);
                }
            }
        }
        return nums.pop();
    }
}