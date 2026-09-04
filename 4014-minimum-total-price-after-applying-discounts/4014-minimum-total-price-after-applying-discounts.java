class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int pIdx = prices.length - 1;
        int dIdx = discounts.length - 1;
        double bill = 0;

        while(pIdx >= 0 && dIdx >= 0) {
            int p = prices[pIdx--];
            int d = discounts[dIdx--];

            bill += (p * (100 - d) * 1.0) / 100.0;
        }

        while(pIdx >= 0) {
            bill += prices[pIdx--] * 1.0;
        }

        return bill;
    }
}