class Solution {
    public int[] findBall(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[] result = new int[c];
        Arrays.fill(result, -1);

        for(int i = 0; i < c; i++) {
            int currentCol = i;

            for(int j = 0; j < r; j++) {
                int nextCol = currentCol + grid[j][currentCol];

                if(nextCol < 0 || nextCol >= c) {
                    currentCol = -1;
                    break;
                }
                if(grid[j][nextCol] != grid[j][currentCol]) {
                    currentCol = -1;
                    break;
                }

                currentCol = nextCol;
            }

            result[i] = currentCol;
        }

        return result;
    }
}