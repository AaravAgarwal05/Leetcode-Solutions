class Solution {
    private class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>();
        int maxDist = Integer.MIN_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        dist[k] = 0;

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int weight = time[2];
            graph.get(src).add(new Edge(dest, weight));
        }

        while(!queue.isEmpty()) {
            int curr = queue.poll();

            for(Edge e : graph.get(curr)) {
                int newDist = dist[curr] + e.weight;

                if(dist[e.to] <= newDist) {
                    continue;
                }

                dist[e.to] = newDist;
                queue.add(e.to);
            }
        }


        for(int i = 1; i <= n; i++) {
            if(i == k) {
                continue;
            }

            maxDist = Math.max(maxDist, dist[i]);
        }

        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
}