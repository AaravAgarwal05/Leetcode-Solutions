class Solution {
    private final int MOD = (int) 1e9 + 7;

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int m = max(nums);
        int ans = 0;
        int[][] dp = new int[m + 1][m + 1];
        dp[0][0] = 1;

        for(int i = 0; i < n; i++) {
            int[][] ndp = new int[m + 1][m + 1];

            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= m; k++) {
                    int val = dp[j][k];

                    if(val == 0) {
                        continue;
                    }

                    int divisor1 = gcd(j, nums[i]);
                    int divisor2 = gcd(k, nums[i]);
                    ndp[j][k] = (ndp[j][k] + val) % MOD;
                    ndp[divisor1][k] = (ndp[divisor1][k] + val) % MOD;
                    ndp[j][divisor2] = (ndp[j][divisor2] + val) % MOD;
                }
            }

            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= m; k++) {
                    dp[j][k] = ndp[j][k];
                }
            }
        }

        for(int i = 1; i <= m; i++) {
            ans = (ans + dp[i][i]) % MOD;
        }

        return ans;
    }

    public int max(int[] nums) {
        int n = nums.length;
        int m = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            m = Math.max(m, nums[i]);
        }

        return m;
    }

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}