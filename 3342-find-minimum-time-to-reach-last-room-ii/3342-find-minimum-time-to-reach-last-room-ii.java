class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private class Tried {
        int x;
        int y;
        int weight;

        Tried(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public int minTimeToReach(int[][] moveTime) {
        int r = moveTime.length;
        int c = moveTime[0].length;
        int[][][] minWeight = new int[r][c][2];

        for(int[][] mW1 : minWeight) {
            for(int[] mW : mW1) {
                Arrays.fill(mW, Integer.MAX_VALUE);
            }
        }

        minWeight[0][0][0] = 0;
        PriorityQueue<Tried> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Tried(0, 0, 0));

        while(!pq.isEmpty()) {
            Tried curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int weight = curr.weight;
            int p = (x + y) % 2;

            if(weight > minWeight[x][y][p]) {
                continue;
            }

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                int nP = (nx + ny) % 2;

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }

                int newWeight = Math.max(weight, moveTime[nx][ny]) + (nP == 0 ? 2 : 1);
                if(newWeight < minWeight[nx][ny][nP]) {
                    minWeight[nx][ny][nP] = newWeight;
                    pq.add(new Tried(nx, ny, newWeight));
                }
            }
        }

        return Math.min(minWeight[r - 1][c - 1][0], minWeight[r - 1][c - 1][1]);
    }
}