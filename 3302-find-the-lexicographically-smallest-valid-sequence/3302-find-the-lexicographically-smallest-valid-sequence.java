class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();  
        int m = word2.length();
        int[] lIndex = new int[m];
        Arrays.fill(lIndex, -1);
        int[] ans = new int[m];
        boolean canChange = true;

        for(int i = n - 1, j = m - 1; i >= 0 && j >= 0; i--) {
            if(word1.charAt(i) == word2.charAt(j)) {
                lIndex[j--] = i;
            }
        }

        for(int i = 0, j = 0; i < n && j < m; i++) {
            if(word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } else if (canChange && (j == m - 1 || i < lIndex[j + 1])){
                ans[j++] = i;
                canChange = false;
            }

            if(j == m) {
                return ans;
            }
        }

        return new int[]{};
    }
}