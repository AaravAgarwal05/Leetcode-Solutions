class Solution {
    public long sumAndMultiply(int n) {
        int revNum = 0;
        while(n > 0) {
            if(n % 10 != 0) {
                revNum = revNum * 10 + (n % 10);
            }
            n /= 10;
        }
        n = 0;
        int sum = 0;
        while(revNum > 0) {
            n = n * 10 + (revNum % 10);
            sum += revNum % 10;
            revNum /= 10;
        }
        long result = 1;
        return result * n * sum;
    }
}