class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int h = n / 2;
        int qL = 0;
        int qR = 0;
        int diff = 0;

        for(int i = 0; i < n; i++) {
            if(i < h) {
                if(num.charAt(i) == '?') {
                    qL++;
                } else {
                    diff += num.charAt(i) - '0';
                }
            } else {
                if(num.charAt(i) == '?') {
                    qR++;
                } else {
                    diff -= num.charAt(i) - '0';
                }
            }
        }

        if((qL + qR) % 2 == 1) {
            return true;
        }

        return diff != 9 * (qR - qL) / 2;
    }
}