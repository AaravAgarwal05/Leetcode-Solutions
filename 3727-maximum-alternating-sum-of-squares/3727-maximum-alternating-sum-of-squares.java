class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        long sum = 0;
        int s = 0;
        int e = nums.length - 1;
        
        while(s < e) {
            sum += nums[e] * nums[e];
            sum -= nums[s] * nums[s];
            e--;
            s++;
        }

        if(s == e) {
            sum += nums[s] * nums[s];
        }

        return sum;
    }
}