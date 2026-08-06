class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[k] = true;
        boolean[] isFaulty = new boolean[n];
        isFaulty[k] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        boolean canReach = false;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] invo : invocations) {
            int u = invo[0];
            int v = invo[1];
            graph.get(u).add(v);
        }

        while(!q.isEmpty()) {
            int curr = q.poll();

            for(int next : graph.get(curr)) {
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    isFaulty[next] = true;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(isFaulty[i]) {
                continue;
            }

            for(int node : graph.get(i)) {
                if(isFaulty[node] == true) {
                    canReach = true;
                    break;
                }
            }
        }

        if(canReach) {
            for(int i = 0; i < n; i++) {
                result.add(i);
            }

            return result;
        }

        for(int i = 0; i < n; i++) {
            if(!isFaulty[i]) {
                result.add(i);
            }
        }

        return result;
    }
}