class Solution {
    private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private class State {
        int x;
        int y;
        int mask;
        int energy;
        int steps;

        State(int x, int y, int mask, int energy, int steps) {
            this.x = x;
            this.y = y;
            this.mask = mask;
            this.energy = energy;
            this.steps = steps;
        }
    }

    public int minMoves(String[] classroom, int energy) {
        int r = classroom.length;
        int c = classroom[0].length();
        int[][] dp = new int[r][c];
        int sx = 0;
        int sy = 0;
        int count = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(classroom[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if(classroom[i].charAt(j) == 'L') {
                    dp[i][j] = 1 << count++;
                }
            }
        }

        int[][][] bestEnergy = new int[r][c][1 << count];

        for(int[][] arr : bestEnergy) {
            for(int[] arr2 : arr) {
                Arrays.fill(arr2, -1);
            }
        }

        bestEnergy[sx][sy][0] = 0;

        Queue<State> q = new LinkedList<>();
        q.offer(new State(sx, sy, 0, energy, 0));

        while(!q.isEmpty()) {
            State cur = q.poll();

            if(cur.mask == (1 << count) - 1) {
                return cur.steps;
            }

            if(cur.energy == 0) {
                continue;
            }

            for(int[] dir : dirs) {
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c || classroom[nx].charAt(ny) == 'X') {
                    continue;
                }

                int ne = classroom[nx].charAt(ny) == 'R' ? energy : cur.energy - 1;
                int mask = cur.mask | dp[nx][ny];

                if(ne > bestEnergy[nx][ny][mask]) {
                    bestEnergy[nx][ny][mask] = ne;
                    q.offer(new State(nx, ny, mask, ne, cur.steps + 1));
                }
            }
        }

        return -1;
    }
}