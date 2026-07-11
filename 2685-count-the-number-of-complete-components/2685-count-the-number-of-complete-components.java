class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int m = edges.length;
        int components = 0;
        List<Integer>[] graph = new ArrayList[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                continue;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            visited[i] = true;

            int no = 0;
            int ed = 0;
            
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                no++;

                for(int nextNode : graph[curr]) {
                    ed++;
                    if(!visited[nextNode]) {
                        visited[nextNode] = true;
                        queue.offer(nextNode);
                    }
                }
            }

            ed = ed / 2;
            if(ed == (no * (no - 1) / 2)) {
                components++;
            }
        }

        return components;
    }
}