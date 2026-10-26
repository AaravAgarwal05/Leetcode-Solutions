class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int counter = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    continue;
                }
                long sum = dfs(grid, i, j, m, n);
                if(sum % k == 0) {
                    counter++;
                }
            }
        }

        return counter;
    }

    private long dfs(int[][] grid, int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n ||grid[i][j] == 0) {
            return 0;
        }

        long sum = grid[i][j];
        grid[i][j] = 0;

        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            sum += dfs(grid, x, y, m, n);
        }

        return sum;
    }
}