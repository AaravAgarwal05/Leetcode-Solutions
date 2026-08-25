class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[] dpA = new long[n];
        long[] dpB = new long[n];
        dpA[0] = energyDrinkA[0];
        dpB[0] = energyDrinkB[0];

        if(n == 1) {
            return Math.max(dpA[0], dpB[0]);
        }

        dpA[1] = energyDrinkA[0] + energyDrinkA[1];
        dpB[1] = energyDrinkB[0] + energyDrinkB[1];

        for(int i = 2; i < n; i++) {
            dpA[i] = energyDrinkA[i] + Math.max(dpA[i - 1], dpB[i - 2]);
            dpB[i] = energyDrinkB[i] + Math.max(dpB[i - 1], dpA[i - 2]);
        }

        return Math.max(dpA[n - 1], dpB[n - 1]);
    }
}