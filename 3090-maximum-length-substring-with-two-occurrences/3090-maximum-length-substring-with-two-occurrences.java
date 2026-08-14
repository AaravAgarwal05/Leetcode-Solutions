class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {
            while(freq[s.charAt(right) - 'a'] >= 2) {
                freq[s.charAt(left++) - 'a']--;
            }

            freq[s.charAt(right) - 'a']++;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}