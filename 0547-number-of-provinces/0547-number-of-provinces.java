class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> graph = new ArrayList<>();
        int provinces = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }

                if(isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }

            provinces++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while(!queue.isEmpty()) {
                int curr = queue.poll();

                for(int next : graph.get(curr)) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        return provinces;
    }
}