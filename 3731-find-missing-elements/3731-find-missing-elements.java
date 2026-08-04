class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> seen = new HashSet<>();
        List<Integer> missing = new ArrayList<>();

        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            seen.add(num);
        }

        for(int i = min; i <= max; i++) {
            if(!seen.contains(i)) {
                missing.add(i);
            }
        }

        return missing;
    }
}