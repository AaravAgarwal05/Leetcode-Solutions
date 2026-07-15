class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 1; i < c; i++) {
            if(grid[0][i] == grid[0][i - 1]) {
                return false;
            }
        }

        for(int j = 0; j < c; j++) {
            for(int i = 1; i < r; i++) {
                if(grid[i][j] != grid[i - 1][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}