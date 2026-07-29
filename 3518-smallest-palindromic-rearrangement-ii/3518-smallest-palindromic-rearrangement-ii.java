class Solution {
    private final long LIMIT = (long)1e6;

    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n / 2; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        if(countWays(freq) < k) {
            return "";
        }

        for(int pos = 0; pos < n / 2; pos++) {
            for(int ch = 0; ch < 26; ch++) {
                if(freq[ch] == 0) {
                    continue;
                }

                freq[ch]--;
                long ways = countWays(freq);

                if(ways >= k) {
                    sb.append((char)(ch + 'a'));
                    break;
                }
                k -= ways;
                freq[ch]++;
            }
        }

        if(n % 2 == 1) {
            return sb.toString() + s.charAt(n / 2) + sb.reverse().toString();
        }

        return sb.toString() + sb.reverse().toString();
    }

    public long countWays(int[] freq) {
        long rem = 0;
        long ans = 1;

        for(int x : freq) {
            rem += x;
        }

        for(int x : freq) {
            if(x == 0) {
                continue;
            }

            long part = combination(rem, x);
            ans *= part;

            if(ans > LIMIT) {
                return LIMIT + 1;
            }

            rem -= x;
        }

        return ans;
    }

    public long combination(long rem, long x) {
        if(x < 0 || x > rem) {
            return 0;
        }

        x = Math.min(x, rem - x);

        if(x == 0) {
            return 1;
        }

        long res = 1;

        for(long i = 1; i <= x; i++) {
            res = res * (rem - x + i) / i;

            if(res > LIMIT) {
                return LIMIT + 1;
            }
        }

        return res;
    }
}