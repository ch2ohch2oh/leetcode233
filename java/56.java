/**
 * id: 56 merge intervals
 * tags: array, two pointers
 * date: 2021-04-22
 * note: Use List.toArray to convert from List to Array
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int []> resList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0] > end) {
                resList.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        // Add the last interval
        resList.add(new int[] {start, end});
        return resList.toArray(new int[0][2]);
    }
}