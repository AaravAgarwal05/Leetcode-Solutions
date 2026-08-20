class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> ar1 = new ArrayList<>();
        List<Integer> ar2 = new ArrayList<>();
        ar1.add(nums[0]);
        ar2.add(nums[1]);
        int counter = 0;

        for(int i = 2; i < n; i++) {
            if(ar1.get(ar1.size() - 1) > ar2.get(ar2.size() - 1)) {
                ar1.add(nums[i]);
            } else {
                ar2.add(nums[i]);
            }
        }

        for(int x : ar1) {
            nums[counter++] = x;
        }

        for(int x : ar2) {
            nums[counter++] = x;
        }

        return nums;
    }
}