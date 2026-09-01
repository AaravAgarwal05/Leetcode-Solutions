class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);

        if(nums.length == 1) {
            return 0;
        }

        int first = nums[0];
        int last = nums[nums.length - 1];
        int diff = last - first;

        for(int i = 0; i < nums.length - 1; i++) {
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            int max = Math.max(nums[i] + k, nums[nums.length - 1] - k);
            diff = Math.min(diff, max - min);
        }

        return diff;
    }
}