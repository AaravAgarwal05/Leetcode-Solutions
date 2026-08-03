class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i <= amount; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for(int j = 0; j < coins.length; j++) {
                if(coins[j] > amount || i + coins[j] > amount) {
                    continue;
                }

                dp[i + coins[j]] = Math.min(dp[i + coins[j]], 1 + dp[i]);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}