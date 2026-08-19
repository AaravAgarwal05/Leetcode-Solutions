class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        final int maxLimit = (int)(4 * 1e6);
        boolean[] isNotPrime = new boolean[maxLimit + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        int maxPrime = 0;

        for(int i = 2; i * i <= maxLimit; i++) {
            if(isNotPrime[i]) {
                continue;
            }

            for(int p = i * i; p <= maxLimit; p += i) {
                isNotPrime[p] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && (i + j) != n - 1) {
                    continue;
                }

                int num = nums[i][j];

                if(!isNotPrime[num] && num > maxPrime) {
                    maxPrime = num;
                }
            }
        }

        return maxPrime;
    }
}