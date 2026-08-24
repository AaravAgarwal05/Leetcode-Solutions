class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] pSum = new int[n];
        pSum[0] = stones[0];
        int[] result = new int[n];

        for(int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + stones[i];
        }

        result[n - 1] = pSum[n - 1];

        for(int i = n - 2; i >= 1; i--) {
            result[i] = Math.max(result[i + 1], pSum[i] - result[i + 1]);
        }

        return result[1];
    }
}