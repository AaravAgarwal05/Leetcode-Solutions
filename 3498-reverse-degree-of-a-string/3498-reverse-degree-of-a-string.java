class Solution {
    public int reverseDegree(String s) {
        final String reversed = "zyxwvutsrqponmlkjihgfedcba";
        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            total += (i + 1) * (reversed.indexOf(s.charAt(i)) + 1);
        }

        return total;
    }
}