class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            
            if(nums[idx] < 0) {
                list.add(idx + 1);
            }

            nums[idx] = -nums[idx];
        }

        return list;
    }
}