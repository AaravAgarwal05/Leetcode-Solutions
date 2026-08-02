class Solution {
    private int r;
    private int c;
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        r = heights.length;
        c = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];
        
        for(int i = 0; i < r; i++) {
            dfs(i, 0, heights, pacific);
        }

        for(int i = 0; i < c; i++) {
            dfs(0, i, heights, pacific);
        }

        for(int i = 0; i < r; i++) {
            dfs(i, c - 1, heights, atlantic);
        }

        for(int i = 0; i < c; i++) {
            dfs(r - 1, i, heights, atlantic);
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int x, int y, int[][] heights, boolean[][] ocean) {
        if(ocean[x][y]) {
            return;
        }

        ocean[x][y] = true;
        
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                continue;
            }

            if(heights[x][y] > heights[nx][ny]) {
                continue;
            }

            dfs(nx, ny, heights, ocean);
        }
    }
}