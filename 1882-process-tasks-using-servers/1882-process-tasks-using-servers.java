class Solution {
    private class Pair {
        int id;
        int weight;

        Pair(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }

    private class Triplet {
        int id;
        int weight;
        long time;

        Triplet(int id, int weight, long time) {
            this.id = id;
            this.weight = weight;
            this.time = time;
        }
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<Pair> free = new PriorityQueue<>((a, b) -> {
            if(a.weight == b.weight) {
                return a.id - b.id;
            }

            return a.weight - b.weight;
        });

        PriorityQueue<Triplet> used = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        long time = 0;
        int[] ans = new int[tasks.length];

        for(int i = 0; i < servers.length; i++) {
            free.add(new Pair(i, servers[i]));
        }

        for(int i = 0; i < tasks.length; i++) {            
            time = Math.max(time, i);

            if(free.isEmpty()) {
                time = Math.max(time, used.peek().time);
            }

            while(!used.isEmpty() && used.peek().time <= time) {
                free.offer(new Pair(used.peek().id, used.peek().weight));
                used.poll();
            }

            used.offer(new Triplet(free.peek().id, free.peek().weight, time + tasks[i]));
            ans[i] = free.peek().id;
            free.poll();
        }

        return ans;
    }
}