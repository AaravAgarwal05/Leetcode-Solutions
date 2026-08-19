class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drunk = numBottles;
        int empty = numBottles;

        while(true) {
            if(empty >= numExchange) {
                empty -= numExchange;
                drunk++;
                empty++;
            } else {
                break;
            }
        }

        return drunk;
    }
}