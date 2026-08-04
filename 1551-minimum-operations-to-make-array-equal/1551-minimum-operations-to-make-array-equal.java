class Solution {
    public int minOperations(int n) {
        int ops = 0;
        int counter = 1;

        for(int i = 1; i <= n; i = (2 * counter++) + 1) {
            ops += Math.abs(n - i);
        }

        return ops;
    }
}