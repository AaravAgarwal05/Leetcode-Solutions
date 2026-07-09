class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] components = new int[n];
        int counter = 0;
        components[0] = counter;
        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[i - 1] <= maxDiff) {
                components[i] = counter;
            } else {
                components[i] = ++counter;
            }
        }
        boolean[] r = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++) {
            r[i] = components[queries[i][0]] == components[queries[i][1]];
        }
        return r;
    }
}