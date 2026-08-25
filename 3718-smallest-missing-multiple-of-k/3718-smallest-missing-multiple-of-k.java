class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] isPresent = new boolean[101];
        int m = k;

        for(int num : nums) {
            isPresent[num] = true;
        }

        while(m < 101 && isPresent[m]) {
            m += k;
        }

        return m;
    }
}