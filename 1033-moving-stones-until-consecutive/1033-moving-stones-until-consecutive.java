class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] sortedArr = {a, b, c};
        Arrays.sort(sortedArr);
        int max = (sortedArr[2] - sortedArr[1] - 1) + (sortedArr[1] - sortedArr[0] - 1);
        if(sortedArr[2] - sortedArr[1] == 1 && sortedArr[1] - sortedArr[0] == 1) {
            return new int[]{0, max};
        } else {
            if(sortedArr[2] - sortedArr[1] <= 2 || sortedArr[1] - sortedArr[0] <= 2) {
                return new int[]{1, max};
            } else {
                return new int[]{2, max};
            }
        }
    }
}