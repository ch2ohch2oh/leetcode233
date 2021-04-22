/**
 * id: 23 merge k sorted lists
 * tags: sort, heap
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        int k = lists.length;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(k, (a, b) -> a.val - b.val);
        for(ListNode head : lists) {
            if(head != null) {
                q.add(head);    
            }
        }
        
        ListNode head = new ListNode();
        ListNode current = head;
        while(q.size() > 0) {
            ListNode node = q.poll();
            if(node.next != null) {
                q.add(node.next);
            }
            current.next = node;
            current = current.next;
        }
        current.next = null;
        return head.next;
        
    }
}