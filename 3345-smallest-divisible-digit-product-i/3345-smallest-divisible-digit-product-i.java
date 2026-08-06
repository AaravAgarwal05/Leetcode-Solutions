class Solution {
    public int smallestNumber(int n, int t) {
        while(true) {
            int product = productOfDigits(n);
            
            if(product % t == 0) {
                return n;
            }

            n++;
        }
    }

    public int productOfDigits(int num) {
        int product = 1;

        while(num > 0) {
            product *= num % 10;
            num /= 10;
        }

        return product;
    }
}