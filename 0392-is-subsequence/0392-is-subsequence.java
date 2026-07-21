class Solution {
    public boolean isSubsequence(String s, String t) {
        int sL = s.length();
        int tL = t.length();
        int sP = 0;
        int tP = 0;

        while(sP < sL && tP < tL) {
            if(s.charAt(sP) == t.charAt(tP)) {
                sP++;
                tP++;

                if(sP == sL) {
                    break;
                }
            }

            while(tP < tL && t.charAt(tP) != s.charAt(sP)) {
                tP++;
            }
        }

        return sP == sL;
    }
}