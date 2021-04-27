/**
 * id: 203 remove linked list elements
 * tags: linked list
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;
        while(head != null) {
            if(head.val != val) {
                current.next = head;
                head = head.next;
                current = current.next;
                current.next = null;
            } else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }
}