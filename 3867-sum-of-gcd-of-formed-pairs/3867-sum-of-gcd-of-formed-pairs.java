class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] gcd = new int[n];
        int s = 0;
        int e = n - 1;
        long totalGCD = 0;

        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            gcd[i] = calcGCD(max, nums[i]);
        }

        Arrays.sort(gcd);

        while(s < e) {
            if(s == e) {
                break;
            }

            totalGCD += calcGCD(gcd[s++], gcd[e--]);
        }

        return totalGCD;
    }

    public int calcGCD(int a, int b) {
        if(b == 0) {
            return a;
        }

        return calcGCD(b, a % b);
    }
}