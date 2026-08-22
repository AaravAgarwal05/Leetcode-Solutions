class Solution {
    public boolean uniformArray(int[] nums1) {
        int smOdd = Integer.MAX_VALUE;
        int allEven = 0;
        int allOdd = 0;

        for(int x : nums1) {
            if(x % 2 == 1 && x < smOdd) {
                smOdd = x;
            }
        }

        for(int x : nums1) {
            if(x % 2 == 0 || (x - smOdd >= 1 && (x - smOdd) % 2 == 0)) {
                allEven++;
            }
        }

        if(allEven == nums1.length) {
            return true;
        }

        for(int x : nums1) {
            if(x % 2 == 1 || (x - smOdd >= 1 && (x - smOdd) % 2 == 1)) {
                allOdd++;
            }
        }

        if(allOdd == nums1.length) {
            return true;
        }

        return false;
    }
}