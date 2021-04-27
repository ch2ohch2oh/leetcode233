/**
 * id: 142 linked list cycle ii
 * tags: slow fast pointers, hashmap
 * date: 2021-04-27
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        int pos = 0;
        while(head != null && !seen.contains(head)) {
            seen.add(head);
            head = head.next;
            pos += 1;
        }
        return head;
    }
}