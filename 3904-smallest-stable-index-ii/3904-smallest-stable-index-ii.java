class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n + 1];
        int[] min = new int[n];
        min[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
        }

        for(int i = 0; i < n; i++) {
            max[i + 1] = Math.max(max[i], nums[i]);

            if(max[i + 1] - min[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}