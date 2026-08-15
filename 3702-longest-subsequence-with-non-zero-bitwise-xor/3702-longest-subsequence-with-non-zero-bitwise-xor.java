class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int n = nums.length;
        long sum = 0;

        for(int num : nums) {
            xor ^= num;
            sum += num;
        }

        if(xor != 0) {
            return n;
        }

        return sum == 0 ? 0 : n - 1;
    }
}