/**
 * id: 435 non-overlapping intervals
 * tags: greedy
 * date: 2021-04-26
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < end) {
                count += 1;
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }
}