class Solution {
    public boolean winnerSquareGame(int n) {
        List<Integer> squares = new ArrayList<>();
        boolean[] dp = new boolean[n + 1];

        for(int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        for(int i = 1; i <= n; i++) {
            for(int square : squares) {
                if(square > i) {
                    break;
                }
                
                if(!dp[i - square]) {
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}