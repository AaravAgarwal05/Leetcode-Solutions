class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;

        while(r < nums.length) {
            while(map.containsKey(nums[r]) && map.get(nums[r]) >= k) {
                map.put(nums[l], map.get(nums[l++]) - 1);
            }

            map.put(nums[r], map.getOrDefault(nums[r++], 0) + 1);
            maxLength = Math.max(maxLength, r - l);
        }

        return maxLength;
    }
}