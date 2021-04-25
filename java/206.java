/**
 * id: 206 reverse linked list
 * tags: linked list
 * date: 2021-04-24
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode revHead = head;
        head = head.next;
        revHead.next = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = revHead;
            revHead = head;
            head = next;
        }
        return revHead;
    }
}