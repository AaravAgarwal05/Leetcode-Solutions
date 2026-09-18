class Solution {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] ans = new int[n][m];

        for(int[] r : ans) {
            Arrays.fill(r, -1);
        }

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new Pair(i, j));
                }
            }
        }

        int height = 1;

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                Pair curr = q.poll();

                for(int[] dir : dirs) {
                    int nx = curr.x + dir[0];
                    int ny = curr.y + dir[1];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }

                    if(ans[nx][ny] != -1) {
                        continue;
                    }

                    ans[nx][ny] = height;
                    q.add(new Pair(nx, ny));
                }
            }

            height++;
        }

        return ans;
    }
}