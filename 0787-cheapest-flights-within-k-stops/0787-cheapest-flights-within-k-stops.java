class Solution {
    private class Duo {
        int to;
        int weight;

        Duo(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private class Trio {
        int to;
        int weight;
        int stops;

        Trio(int to, int weight, int stops) {
            this.to = to;
            this.weight = weight;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Duo>> graph = new ArrayList<>();
        int[][] dist = new int[n][k + 2];
        PriorityQueue<Trio> pq = new PriorityQueue<>((a, b) -> {
            if(a.stops == b.stops) {
                return a.weight - b.weight;
            }

            return a.stops - b.stops;
        });
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            int lsrc = flight[0];
            int ldest = flight[1];
            int lweight = flight[2];
            graph.get(lsrc).add(new Duo(ldest, lweight));
        }


        for(int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dist[src][0] = 0;
        pq.offer(new Trio(src, 0, 0));

        while(!pq.isEmpty()) {
            Trio curr = pq.poll();
            int cStops = curr.stops;
            int cWeight = curr.weight;

            if(cStops > k || cWeight > dist[curr.to][cStops]) {
                continue;
            }

            for(Duo e : graph.get(curr.to)) {
                int newDist = cWeight + e.weight;

                if(newDist >= dist[e.to][cStops + 1]) {
                    continue;
                }

                dist[e.to][cStops + 1] = newDist;
                pq.offer(new Trio(e.to, newDist, cStops + 1));
            }
        }

        for(int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, dist[dst][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}