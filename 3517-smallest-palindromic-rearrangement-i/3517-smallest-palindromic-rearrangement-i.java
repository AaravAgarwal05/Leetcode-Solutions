class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        char odd = ' ';
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) {
                continue;
            }

            if(freq[i] % 2 == 1) {
                odd = (char)(i + 'a');
            }

            for(int j = 0; j < freq[i] / 2; j++) {
                sb.append((char)(i + 'a'));
            }
        }

        if(odd != ' ') {
            return sb.toString() + odd + sb.reverse().toString();
        } else {
            return sb.toString() + sb.reverse().toString();
        }
    }
}