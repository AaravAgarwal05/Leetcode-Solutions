class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] suff = new long[n];
        suff[n - 1] = nums[n - 1];
        int counter = n - 1;

        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + nums[i];
        }

        while(counter >= 0 && suff[counter] > 0) {
            counter--;
        }

        return counter == -1 ? n : n - counter - 1;
    }
}