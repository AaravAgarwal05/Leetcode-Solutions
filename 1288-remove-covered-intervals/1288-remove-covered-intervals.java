class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int count = 0;
        int lastIndex = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[lastIndex][0] <= intervals[i][0] && intervals[i][1] <= intervals[lastIndex][1]) {
                count++;
            } else {
                lastIndex = i;
            }
        }
        return intervals.length - count;
    }
}