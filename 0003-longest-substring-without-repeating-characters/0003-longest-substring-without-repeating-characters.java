class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[128];
        int maxSize = Integer.MIN_VALUE;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            while(seen[s.charAt(right)]) {
                seen[s.charAt(left++)] = false;
            }

            seen[s.charAt(right)] = true;
            maxSize = Math.max(maxSize, right - left + 1);
        }

        return maxSize == Integer.MIN_VALUE ? 0 : maxSize;
    }
}