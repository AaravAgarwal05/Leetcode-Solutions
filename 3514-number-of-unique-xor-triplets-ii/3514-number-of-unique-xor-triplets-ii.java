class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max = 2048;
        boolean[] seen1 = new boolean[max];
        boolean[] seen2 = new boolean[max];
        boolean[] seen3 = new boolean[max];
        int count = 0;

        for(int i : nums) {
            seen1[i] = true;
        }

        for(int i = 0; i < max; i++) {
            if(!seen1[i]) {
                continue;
            }

            for(int j = 0; j < max; j++) {
                if(seen1[j]) {
                    seen2[i ^ j] = true;
                }
            }
        }

        for(int i = 0; i < max; i++) {
            if(!seen2[i]) {
                continue;
            }

            for(int j = 0; j < max; j++) {
                if(seen1[j]) {
                    seen3[i ^ j] = true;
                }
            }
        }

        for(int i = 0; i < max; i++) {
            if(seen3[i]) {
                count++;
            }
        }

        return count;
    }
}