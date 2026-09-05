class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;

        if(n % k != 0) {
            return false;
        }
        
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums) {
            if(!map.containsKey(num)){
                continue;
            }

            for(int i = num; i < num + k; i++) {
                if(!map.containsKey(i)) {
                    return false;
                }

                map.put(i, map.get(i) - 1);

                if(map.get(i) == 0) {
                    map.remove(i);
                }

            }
        }

        return true;
    }
}