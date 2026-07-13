class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int pSum = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <= n; i++) {
            int rem = ((pSum % k) + k) % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
            
            if(i < n) {
                pSum += nums[i];
            }
        }

        for(int x : map.values()) {
            total += (x * (x - 1)) / 2;
        }
        
        return total;
    }
}