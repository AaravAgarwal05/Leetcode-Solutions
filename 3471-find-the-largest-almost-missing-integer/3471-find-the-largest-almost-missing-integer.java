class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(k == 1) {
            Arrays.sort(nums);

            for(int i = nums.length - 1; i >= 0; i--) {
                if(map.get(nums[i]) == 1) {
                    return nums[i];
                }
            }

            return -1;
        }

        if(k == nums.length) {
            Arrays.sort(nums);

            return nums[nums.length - 1];
        }

        if(map.get(nums[0]) == 1 && map.get(nums[nums.length - 1]) == 1) {
            return Math.max(nums[0], nums[nums.length - 1]);
        } else if(map.get(nums[0]) == 1) {
            return nums[0];
        } else if(map.get(nums[nums.length - 1]) == 1) {
            return nums[nums.length - 1];
        }

        return -1;
    }
}