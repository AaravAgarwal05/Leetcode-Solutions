class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int sold = 0;
        int counter = 0;
        int n = tickets.length;

        while(tickets[k] != 0) {
            if(counter == n) {
                counter = 0;
            }

            if(tickets[counter] == 0) {
                counter++;
                continue;
            }

            tickets[counter++]--;
            sold++;
        }

        return sold;
    }
}