class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        int countOfIslands = 0;
        int r = grid.length;
        int c = grid[0].length;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j, r, c);
                    countOfIslands++;
                }
            }
        }

        return countOfIslands;
    }

    public void dfs(char[][] grid, int x, int y, int r, int c) {
        grid[x][y] = '0';

        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            if(grid[nx][ny] == '1') {
                dfs(grid, nx, ny, r, c);
            }
        }
    }
}