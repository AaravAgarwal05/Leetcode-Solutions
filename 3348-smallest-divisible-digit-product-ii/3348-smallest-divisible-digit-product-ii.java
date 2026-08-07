class Solution {
    public String smallestNumber(String num, long t) {
        int n = num.length();
        long temp = t;
        long[] rem = new long[n + 1];
        rem[0] = t;
        int pos = n - 1;
        StringBuilder sb = new StringBuilder();
        sb.append(num);

        for(int i = 2; i <= 9; i++) {
            while(temp % i == 0) {
                temp /= i;
            }
        }

        if(temp > 1) {
            return "-1";
        }

        for(int i = 0; i < n; i++) {
            if(sb.charAt(i) == '0') {
                pos = i;
                break;
            }

            rem[i + 1] = rem[i] / gcd(rem[i], sb.charAt(i) - '0');
        }

        if(rem[n] == 1) {
            return num;
        }

        for(int i = pos; i >= 0; i--) {
            char ch = sb.charAt(i);

            while(++ch <= '9') {
                sb.setCharAt(i, ch);
                long tnow = rem[i] / gcd(rem[i], ch - '0');
                int k = 9;

                for(int j = n - 1; j > i; j--) {
                    while(tnow % k != 0) {
                        k--;
                    }

                    tnow /= k;
                    sb.setCharAt(j, (char)('0' + k));
                }

                if(tnow == 1) {
                    return sb.toString();
                }
            }
        }

        sb.setLength(0);
        
        for(int i = 9; i > 1; i--) {
            while(t % i == 0) {
                sb.append((char)('0' + i));
                t /= i;
            }
        }

        int count = n + 1 - sb.length();

        while(count-- > 0) {
            sb.append('1');
        }

        return sb.reverse().toString();
    }

    private long gcd(long a, long b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}