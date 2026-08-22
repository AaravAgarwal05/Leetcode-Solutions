class Solution {
    public boolean checkDivisibility(int n) {
        int sum = sumOfPandS(n);
        
        return n % sum == 0;
    }

    public int sumOfPandS(int n) {
        int sum = 0;
        int product = 1;

        while(n > 0) {
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }

        return sum + product;
    }
}