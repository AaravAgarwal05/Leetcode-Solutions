class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;

        for(int i = 0; i < n; i++) {
            possible[i] = possible[i] == 0 ? -1 : 1;
        }

        int[] pSum = new int[n];
        int[] sSum = new int[n];
        pSum[0] = possible[0];

        for(int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + possible[i];
        }

        sSum[n - 1] = possible[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            sSum[i] = sSum[i + 1] + possible[i];
        }

        for(int i = 0; i < n - 1; i++) {
            if(pSum[i] > sSum[i + 1]) {
                return i + 1;
            }
        }

        return -1;
    }
}