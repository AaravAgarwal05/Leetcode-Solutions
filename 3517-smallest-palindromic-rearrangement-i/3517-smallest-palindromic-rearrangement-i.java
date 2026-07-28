class Solution {
    public String smallestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char odd = ' ';
        StringBuilder sb = new StringBuilder();
        
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < 26; i++) {
            int freq = map.getOrDefault((char)('a' + i), 0);
            
            if(freq == 0) {
                continue;
            }

            if(freq % 2 == 1) {
                odd = (char)('a' + i);
            }

            for(int j = 0; j < freq / 2; j++) {
                sb.append((char)('a' + i));
            }
        }
        if(odd != ' ') {
            return sb.toString() + odd + sb.reverse().toString();
        } else {
            return sb.toString() + sb.reverse().toString();
        }
    }
}