class Solution {  
    private final int MOD = 1_000_000_007;

    class State {
        int maxScore;
        int numberOfPaths;
        
        State(int maxScore, int numberOfPaths) {
            this.maxScore = maxScore;
            this.numberOfPaths = numberOfPaths;
        }
    }

    public void update(State[][] dp, int n, int x, int y, int nx, int ny) {
        if(nx >= n || ny >= n || dp[nx][ny].maxScore == -1) {
            return;
        }
        if(dp[nx][ny].maxScore > dp[x][y].maxScore) {
            dp[x][y].maxScore = dp[nx][ny].maxScore;
            dp[x][y].numberOfPaths = dp[nx][ny].numberOfPaths;
        } else if(dp[nx][ny].maxScore == dp[x][y].maxScore) {
            dp[x][y].numberOfPaths = (dp[nx][ny].numberOfPaths + dp[x][y].numberOfPaths) % MOD;
        }
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        State[][] dp = new State[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = new State(-1, 0);
            }
        }
        dp[n - 1][n - 1] = new State(0, 1);
        for(int i = n - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(!(i == n - 1 && j == n - 1) && board.get(i).charAt(j) != 'X') {
                    update(dp, n, i, j, i + 1, j);
                    update(dp, n, i, j, i, j + 1);
                    update(dp, n, i, j, i + 1, j + 1);
                    if(dp[i][j].maxScore != -1) {
                        dp[i][j].maxScore += board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0';
                    }
                }
            }
        }
        return dp[0][0].maxScore == -1 ? new int[]{0, 0} : new int[]{dp[0][0].maxScore, dp[0][0].numberOfPaths};
    }
}