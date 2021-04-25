/**
 * id: 215 k-th largest element in an array
 * tags: heap
 * date: 2021-04-24
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        for(int num : nums) {
            q.add(-num);
        }
        for(int i=0; i<k-1; i++) {
            q.poll();
        }
        return - q.poll();
    }
}
