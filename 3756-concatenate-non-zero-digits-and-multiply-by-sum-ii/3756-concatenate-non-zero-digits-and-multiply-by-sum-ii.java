class Solution {
    private final int MOD = (int) (1e9 + 7);
    
    public int[] sumAndMultiply(String s, int[][] queries) {
        int nonZero = 0;
        int n = s.length();
        int[] prefixSum = new int[n + 1];
        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) - '0');
            if(s.charAt(i) != '0') {
                prefix[i + 1] = (prefix[i] * 10 + (s.charAt(i) - '0')) % MOD;
                nonZero++;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }
        long[] pow10 = new long[n + 1];
        pow10[0] = nonZero;
        for(int i = 0; i < n; i++) {
            pow10[i + 1] = s.charAt(i) == '0' ? pow10[i] : pow10[i] - 1;
        }
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int sum = prefixSum[r] - prefixSum[l];
            long num = (prefix[r] - (prefix[l] * 1L * power(10, pow10[l] - pow10[r])) % MOD + MOD) % MOD;
            result[i] = (int) ((sum * num) % MOD);
        }
        return result;
    }

    private int power(long a, long b) {
        long result = 1;
        a %= MOD;
        while(b > 0) {
            if((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
    return (int) result;
}
}