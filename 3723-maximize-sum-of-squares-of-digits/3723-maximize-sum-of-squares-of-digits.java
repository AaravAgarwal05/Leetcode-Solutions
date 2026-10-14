class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        
        while(sum > 9) {
            sb.append(9);
            sum -= 9;
        }

        sb.append(sum);
        
        if(sb.length() > num) {
            return "";
        }

        while(sb.length() < num) {
            sb.append(0);
        }
        
        return sb.toString();
    }
}