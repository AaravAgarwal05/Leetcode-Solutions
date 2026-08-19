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
            int num1 = nums[i][i];
            int num2 = nums[i][n - 1 - i];

            if(!isNotPrime[num1] && num1 > maxPrime) {
                maxPrime = num1;
            }

            if(!isNotPrime[num2] && num2 > maxPrime) {
                maxPrime = num2;
            }
        }

        return maxPrime;
    }
}