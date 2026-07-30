class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        
        for(char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);
        int total = 0;
        int counter = 0;

        for(int i = 25; i >= 0; i--) {
            if(freq[i] == 0) {
                continue;
            }

            total += ((counter++ / 8) + 1) * freq[i];
        }

        return total;
    }
}