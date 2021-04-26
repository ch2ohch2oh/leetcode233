/**
 * id: 445 add two numbers ii
 * tags: linked list
 * date: 2021-04-25
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    private Stack<ListNode> numToStack(ListNode head) {
        Stack<ListNode> num = new Stack<ListNode>();
        while(head != null) {
            num.push(head);
            head = head.next;
        }
        return num;
    }   
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> num1 = numToStack(l1);
        Stack<ListNode> num2 = numToStack(l2);
        Stack<ListNode> res = new Stack<ListNode>();
        int carry = 0;
        while(num1.size() > 0 && num2.size() > 0) {
            int n1 = num1.pop().val;
            int n2 = num2.pop().val;
            int n = n1 + n2 + carry;
            carry = n / 10;
            res.push(new ListNode(n % 10));
        }
        while(num1.size() > 0) {
            int n = num1.pop().val + carry;
            carry = n / 10;
            res.push(new ListNode(n % 10));
        }
        while(num2.size() > 0) {
            int n = num2.pop().val + carry;
            carry = n / 10;
            res.push(new ListNode(n % 10));
        }
        if(carry > 0) {
            res.push(new ListNode(carry));
        }
        
        ListNode head = new ListNode();
        ListNode current = head;
        while(res.size() > 0) {
            current.next = new ListNode(res.pop().val);
            current = current.next;
        }
        return head.next;
    }
}