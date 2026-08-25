class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int e = 0;
        int o = 1;
        int[] res = new int[nums.length];

        for(int x : nums) {
            if(x % 2 == 0) {
                res[e] = x;
                e += 2;
            } else {
                res[o] = x;
                o += 2;
            }
        }

        return res;
    }
}