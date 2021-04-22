/**
 * id: 2 add two numbers
 * tags: linked list
 * date: 2021-04-22
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            current.next = new ListNode(val % 10);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null && l2 != null) {
            l1 = l2;
        }
        while(l1 != null) {
            int val = l1.val + carry;
            carry = val / 10;
            current.next = new ListNode(val % 10);
            current = current.next;
            l1 = l1.next;
        }
        if(carry > 0) {
            current.next = new ListNode(carry);
        }
        return head.next;
    }
}