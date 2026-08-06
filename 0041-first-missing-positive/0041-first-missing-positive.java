class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int num : nums) {
            seen.add(num);
        }

        for(int i = 1; i <= Integer.MAX_VALUE; i++) {
            if(!seen.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}