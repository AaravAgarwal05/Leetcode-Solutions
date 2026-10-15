class Solution {
    public int sumCounts(List<Integer> nums) {
        int total = 0;
        int l = nums.size();

        for(int i = 0; i < l; i++) {
            Set<Integer> set = new HashSet<>();

            for(int j = i; j < l; j++) {
                set.add(nums.get(j));
                int s = set.size();
                total += s * s;
            }
        }

        return total;
    }
}