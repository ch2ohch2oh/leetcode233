/**
 * id: 82 remove duplicates from sorted list ii
 * tags: listed list
 * date: 2021-04-27
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        ListNode node = head;
        while(node != null) {
            if(node.next != null && node.val == node.next.val) {
                ListNode prev = node;
                while(node != null && node.val == prev.val) {
                    node = node.next;
                }
            } else {
                current.next = node;
                current = node;
                node = node.next;
                current.next = null;
            }
        }
        return newHead.next;
    }
}