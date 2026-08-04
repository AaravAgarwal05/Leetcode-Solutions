class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        List<Integer> missing = new ArrayList<>();

        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] freq = new int[max - min + 1];

        for(int num : nums) {
            freq[num - min]++;
        }

        for(int i = 0; i < max - min; i++) {
            if(freq[i] == 0) {
                missing.add(i + min);
            }
        }

        return missing;
    }
}