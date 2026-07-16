class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long max = Integer.MIN_VALUE;
        long[] gcd = new long[n];
        int s = 0;
        int e = n - 1;
        long totalGCD = 0;

        for(int i = 0; i < n; i++) {
            max = Math.max(max, (long)nums[i]);
            gcd[i] = (long) calcGCD(max, (long)nums[i]);
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

    public long calcGCD(long a, long b) {
        if(b == 0) {
            return a;
        }

        return calcGCD(b, a % b);
    }
}