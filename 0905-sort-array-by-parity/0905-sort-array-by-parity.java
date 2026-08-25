class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int[] res = new int[e + 1];

        for(int x : nums) {
            if(x % 2 == 0) {
                res[s++] = x;
            } else {
                res[e--] = x;
            }
        }

        return res;
    }
}