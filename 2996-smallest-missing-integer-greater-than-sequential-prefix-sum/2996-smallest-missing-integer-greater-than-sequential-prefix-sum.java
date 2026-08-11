class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int pSum = nums[0];
        Set<Integer> seen = new HashSet<>();

        for(int num : nums) {
            seen.add(num);
        }

        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[i - 1] + 1) {
                break;
            }

            pSum += nums[i];
        }

        while(seen.contains(pSum++));

        return pSum - 1;
    }
}