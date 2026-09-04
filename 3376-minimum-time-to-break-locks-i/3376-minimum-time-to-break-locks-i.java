class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size();
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), strength, res, n);
        int minTime = Integer.MAX_VALUE;

        for(List<Integer> s : res) {
            int x = 1;
            int time = 0;
            int energy = 1;
            int idx = 0;

            while(idx < n) {
                int lock = s.get(idx);

                if(energy < lock) {
                    lock += energy - 1;
                    time += lock / energy - 1;
                }
                
                x += k;
                energy = x;
                idx++;
                time++;
            }

            minTime = Math.min(minTime, time);
        }

        return minTime;
    }

    private void dfs(List<Integer> cur, List<Integer> rem, List<List<Integer>> res, int size) {
        if(cur.size() == size) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < rem.size(); i++) {
            int e = rem.get(i);
            cur.add(e);
            rem.remove(i);
            dfs(cur, rem, res, size);
            cur.remove(cur.size() - 1);
            rem.add(i, e);
        }
    }
}