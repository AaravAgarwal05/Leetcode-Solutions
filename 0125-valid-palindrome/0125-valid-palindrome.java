class Solution {
    public boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int s = 0;
        int e = str.length() - 1;

        while(s <= e) {
            while(s < str.length() && !Character.isLetterOrDigit(str.charAt(s))) {
                s++;
            }

            while(e >= 0 && !Character.isLetterOrDigit(str.charAt(e))) {
                e--;
            }

            if(s <= e && str.charAt(s) != str.charAt(e)) {
                return false;
            }

            s++;
            e--;
        }

        return true;
    }
}