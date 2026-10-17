class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] dSum = new int[n];

        for(int i = 0; i < n; i++) {
            int x = nums[i];
            int sum = 0;

            while(x > 0) {
                sum += x % 10;
                x /= 10;
            }

            dSum[i] = sum;
        }

        Integer[] idx = new Integer[n];

        for(int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> {
            if(dSum[a] == dSum[b]) {
                return Integer.compare(nums[a], nums[b]);
            }

            return Integer.compare(dSum[a], dSum[b]);
        });

        int[] targetPos = new int[n];

        for(int p = 0; p < n; p++) {
            targetPos[idx[p]] = p;
        }

        boolean[] vis = new boolean[n];
        int cycles = 0;

        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                cycles++;
                int j = i;
                
                while(!vis[j]) {
                    vis[j] = true;
                    j = targetPos[j];
                }
            }
        }

        return n - cycles;
    }
}