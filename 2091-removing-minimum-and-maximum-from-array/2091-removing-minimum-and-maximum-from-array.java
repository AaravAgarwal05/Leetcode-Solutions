class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int idxMax = -1;
        int idxMin = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(nums[i] > max) {
                max = nums[i];
                idxMax = i;
            }

            if(nums[i] < min) {
                min = nums[i];
                idxMin = i;
            }
        }

        int r = Math.max(idxMax, idxMin);
        int l = Math.min(idxMax, idxMin);
        
        return Math.min(Math.min(r + 1, n - l), l + 1 + n - r);
    }
}