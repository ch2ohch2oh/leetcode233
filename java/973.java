/**
 * id: 973 k closets points to origin
 * tags: heap
 * date: 2021-04-21
 */
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> queue = new PriorityQueue<>(points.length, (a, b) -> a[2] - b[2]);
        for(int i=0; i<points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist2 = x * x + y * y;
            queue.add(new int [] {x, y, dist2});
        }
        int [][] res = new int[k][2];
        for(int i=0; i<k; i++) {
            int [] item = queue.poll();
            res[i][0] = item[0];
            res[i][1] = item[1];
        }
        return res;
    }
}