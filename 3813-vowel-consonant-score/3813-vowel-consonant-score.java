class Solution {
    public int vowelConsonantScore(String s) {
        int consts = 0;
        int vowels = 0;

        for(char ch : s.toCharArray()) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if((ch - '0' < 0 || ch - '0' > 9) && ch != ' '){ 
                consts++;
            }
        }

        if(consts == 0) {
            return 0;
        }

        return (int)Math.floor(vowels / consts);
    }
}