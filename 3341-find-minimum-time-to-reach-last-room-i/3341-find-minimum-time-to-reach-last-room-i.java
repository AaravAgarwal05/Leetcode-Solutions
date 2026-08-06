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
        int[][] minWeight = new int[r][c];

        for(int[] mW : minWeight) {
            Arrays.fill(mW, Integer.MAX_VALUE);
        }

        minWeight[0][0] = 0;
        PriorityQueue<Tried> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Tried(0, 0, 0));

        while(!pq.isEmpty()) {
            Tried curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int weight = curr.weight;

            if(weight > minWeight[x][y]) {
                continue;
            }

            for(int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    continue;
                }

                int newWeight = Math.max(weight, moveTime[nx][ny]) + 1;
                if(newWeight < minWeight[nx][ny]) {
                    minWeight[nx][ny] = newWeight;
                    pq.add(new Tried(nx, ny, newWeight));
                }
            }
        }

        return minWeight[r - 1][c - 1];
    }
}