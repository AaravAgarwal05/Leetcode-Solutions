class Solution {
    public int maximumPrimeDifference(int[] nums) {
        final int LIMIT = 100;
        boolean[] isNotPrime = new boolean[LIMIT + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for(int i = 2; i * i <= LIMIT; i++) {
            if(isNotPrime[i]) {
                continue;
            }

            for(int p = i * i; p <= LIMIT; p += i) {
                isNotPrime[p] = true;
            }
        }

        int first = 0;
        int last = nums.length - 1;

        while(isNotPrime[nums[first++]]); 
        while(isNotPrime[nums[last--]]);

        return last - first + 2; 
    }
}