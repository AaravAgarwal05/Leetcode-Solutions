class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int right = Integer.MIN_VALUE;
        int count = 0;

        for(int[] interval : intervals) {
            if(interval[0] >= right) {
                right = interval[1];
                count++;
            }
        }

        return intervals.length - count;
    }
}