class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int maxLength = 0;

        while(right < n) {
            while(freq[s.charAt(right) - 'a'] >= 2) {
                freq[s.charAt(left++) - 'a']--;
            }

            freq[s.charAt(right++) - 'a']++;
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }
}