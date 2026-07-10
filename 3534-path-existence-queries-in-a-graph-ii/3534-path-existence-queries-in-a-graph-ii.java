class Solution {
    private static int[][] group = new int[100001][18];

    class Pair {
        private int value;
        private int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        int r = 0;
        Pair[] sortedNums = new Pair[n];
        int[] ans = new int[m];
        int[] pos = new int[n];

        for(int i = 0; i < n; i++) {
            sortedNums[i] = new Pair(nums[i], i);
        }

        Arrays.sort(sortedNums, (a, b) -> Integer.compare(a.value, b.value));

        for(int i = 0; i < n; i++) {
            pos[sortedNums[i].index] = i;
        }

        for(int i = 0; i < n; i++) {
            if(r < i) {
                r = i;
            }

            while(r + 1 < n && sortedNums[r + 1].value - sortedNums[i].value <= maxDiff) {
                r++;
            }

            group[i][0] = r;
        }

        for(int i = 1; i < 18; i++) {
            for(int j = 0; j < n; j++) {
                group[j][i] = group[group[j][i - 1]][i - 1];
            }
        }

        for(int i = 0; i < m; i++) {
            int u = pos[queries[i][0]];
            int v = pos[queries[i][1]];

            if(u > v) {
                u = u + v;
                v = u - v;
                u = u - v;
            }

            if(u == v) {
                ans[i] = 0;
                continue;
            }

            int curr = u;
            int steps = 0;

            for(int j = 17; j >= 0; j--) {
                if(group[curr][j] < v) {
                    curr = group[curr][j];
                    steps += (1 << j);
                }
            }

            ans[i] = (group[curr][0] >= v) ? steps + 1 : -1;
        }

        return ans;
    }
}