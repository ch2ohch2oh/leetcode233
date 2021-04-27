/**
 * id: 1836 remove duplicates from an unsorted linked list
 * tags: hashmap
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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // Count the number of occurrences
        HashMap<Integer, Integer> counter = new HashMap<>();
        ListNode node = head;
        while(node != null) {
            if(counter.containsKey(node.val)) {
                counter.put(node.val, counter.get(node.val) + 1);
            } else {
                counter.put(node.val, 1);
            }
            node = node.next;
        }
        // Construct new linked list
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        node = head;
        while(node != null) {
            if(counter.get(node.val) == 1) {
                current.next = node;
                node = node.next;
                current = current.next;
                current.next = null;
            } else {
                node = node.next;    
            }
        }
        return newHead.next;
    }
}