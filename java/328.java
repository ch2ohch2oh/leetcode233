/**
 * id: 328 odd even linked list
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode evenHead = new ListNode();
        ListNode oddHead = new ListNode();
        ListNode evenEnd = evenHead;
        ListNode oddEnd = oddHead;
        ListNode node = head;
        while(node != null && node.next != null) {
            evenEnd.next = node;
            oddEnd.next = node.next;
            node = node.next.next;
            evenEnd = evenEnd.next;
            evenEnd.next = null;
            oddEnd = oddEnd.next;
            oddEnd.next = null;
        }
        if(node != null) {
            evenEnd.next = node;
            evenEnd = evenEnd.next;
        }
        evenEnd.next = oddHead.next;
        return evenHead.next;
    }
}