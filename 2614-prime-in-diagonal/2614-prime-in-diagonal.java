class Solution {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int maxPrime = 0;

        for(int i = 0; i < n; i++) {
            int num1 = nums[i][i];
            int num2 = nums[i][n - 1 - i];

            if(isPrime(num1) && num1 > maxPrime) {
                maxPrime = num1;
            }

            if(isPrime(num2) && num2 > maxPrime) {
                maxPrime = num2;
            }
        }

        return maxPrime;
    }

    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}