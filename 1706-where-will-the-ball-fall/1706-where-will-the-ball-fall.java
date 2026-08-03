class Solution {
    public int[] findBall(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] result = new int[c];
        Arrays.fill(result, -1);

        for(int i = 0; i < c; i++) {
            int cCol = i;
            for(int j = 0; j < r; j++) {
                int nextCol = cCol + grid[j][cCol];
                if(nextCol < 0 || nextCol >= c) {
                    break;
                }
                if(grid[j][nextCol] != grid[j][cCol]) {
                    break;
                }
                cCol = nextCol;
                if(j == r - 1) {
                    result[i] = cCol;
                }
            }
        }

        return result;
    }
}