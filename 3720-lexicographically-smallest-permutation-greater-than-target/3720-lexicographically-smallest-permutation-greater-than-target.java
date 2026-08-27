import java.util.*;

class Solution {

    private String getMinString(int[] freq) {
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < freq[i]; j++) {
                res.append((char) ('a' + i));
            }
        }

        return res.toString();
    }

    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(char ch : target.toCharArray()) {
            freq[ch - 'a']--;
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            int b = target.charAt(i) - 'a';
            freq[b]++;

            if(getMinFreq(freq) < 0) {
                continue;
            }

            for(int j = b + 1; j < 26; j++) {
                if(freq[j] > 0) {
                    freq[j]--;
                    target = target.substring(0, i) + (char) ('a' + j);
                    return target + getMinString(freq);
                }
            }
        }

        return "";
    }

    private int getMinFreq(int[] freq) {
        int min = Integer.MAX_VALUE;

        for(int value : freq) {
            min = Math.min(min, value);
        }

        return min;
    }
}