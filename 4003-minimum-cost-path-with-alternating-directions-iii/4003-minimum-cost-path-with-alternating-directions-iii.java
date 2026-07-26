class Solution {
    int[][] oddDir = {{1, 0}, {0, 1}};
    int[][] evenDir = {{-1, 0}, {0, -1}};

    class State {
        int x;
        int y;
        long minCost;
        int parity;

        State(int x, int y, long minCost, int parity) {
            this.x = x;
            this.y = y;
            this.minCost = minCost;
            this.parity = parity;
        }
    }
    
    public long minCost(int m, int n, int[][] penalty) {
        long INF = Long.MAX_VALUE / 4;
        long[][][] minDist = new long[m][n][2];

        for(long[][] arr : minDist) {
            for(long[] arr2 : arr) {
                Arrays.fill(arr2, INF);
            }
        }

        minDist[0][0][0] = 1;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.minCost, b.minCost));
        pq.add(new State(0, 0, 1, 0));

        while(!pq.isEmpty()) {
            State cState = pq.poll();

            if(cState.minCost != minDist[cState.x][cState.y][cState.parity]) {
                continue;
            }

            if(cState.x == m - 1 && cState.y == n - 1) {
                return cState.minCost;
            }

            int nextParity = 1 - cState.parity;
            long waitCost = cState.minCost + penalty[cState.x][cState.y];

            if(waitCost < minDist[cState.x][cState.y][nextParity]) {
                minDist[cState.x][cState.y][nextParity] = waitCost;
                pq.add(new State(cState.x, cState.y, waitCost, nextParity));
            }

            if(cState.parity == 1) {
                for(int[] dir : evenDir) {
                    int nx = cState.x + dir[0];
                    int ny = cState.y + dir[1];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }

                    if(cState.minCost + (long)(nx + 1) * (ny + 1) < minDist[nx][ny][nextParity]) {
                        minDist[nx][ny][nextParity] = cState.minCost + ((nx + 1) * (ny + 1));
                        pq.add(new State(nx, ny, minDist[nx][ny][nextParity], nextParity));
                    }
                }
                for(int[] dir : oddDir) {
                    int nx = cState.x + dir[0];
                    int ny = cState.y + dir[1];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }

                    if(cState.minCost + ((long)(nx + 1) * (ny + 1)) + penalty[cState.x][cState.y] < minDist[nx][ny][nextParity]) {
                        minDist[nx][ny][nextParity] = cState.minCost + ((nx + 1) * (ny + 1)) + penalty[cState.x][cState.y];
                        pq.add(new State(nx, ny, minDist[nx][ny][nextParity], nextParity));
                    }
                }
            } else {
                for(int[] dir : oddDir) {
                    int nx = cState.x + dir[0];
                    int ny = cState.y + dir[1];

                    if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }

                    if(cState.minCost + (long)(nx + 1) * (ny + 1) < minDist[nx][ny][nextParity]) {
                        minDist[nx][ny][nextParity] = cState.minCost + ((nx + 1) * (ny + 1));
                        pq.add(new State(nx, ny, minDist[nx][ny][nextParity], nextParity));
                    }
                }

                for(int[] dir : evenDir) {
                    int nx = cState.x + dir[0];
                    int ny = cState.y + dir[1];
                    
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }

                    if(cState.minCost + ((long)(nx + 1) * (ny + 1)) + penalty[cState.x][cState.y] < minDist[nx][ny][nextParity]) {
                        minDist[nx][ny][nextParity] = cState.minCost + ((nx + 1) * (ny + 1)) + penalty[cState.x][cState.y];
                        pq.add(new State(nx, ny, minDist[nx][ny][nextParity], nextParity));
                    }
                }
            }
        }

        return -1;
    }
}