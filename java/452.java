/**
 * id: 452 minimum number of arrrows to burst ballons
 * tags: greedy
 * date: 2021-04-26
 * note: similar to 425 but NOT the same. 
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        int start = points[0][0];
        int end = points[0][1];
        for(int i=1; i<points.length; i++) {
            if(points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                count += 1;
                end = points[i][1];
            }
        }
        return count;
    }
}