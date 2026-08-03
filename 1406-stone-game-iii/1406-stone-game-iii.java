class Solution {
    private String[] candidates = {"Bob", "Tie", "Alice"};

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[4];

        for(int i = n - 1; i >= 0; i--) {
            dp[i & 3] = stoneValue[i] - dp[(i + 1) & 3];

            if(i + 2 <= n) {
                dp[i & 3] = Math.max(dp[i & 3], stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) & 3]);
            }

            if(i + 3 <= n) {
                dp[i & 3] = Math.max(dp[i & 3], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) & 3]);
            }
        }

        return candidates[(dp[0] > 0 ? 2 : (dp[0] == 0) ? 1 : 0)];
    }
}