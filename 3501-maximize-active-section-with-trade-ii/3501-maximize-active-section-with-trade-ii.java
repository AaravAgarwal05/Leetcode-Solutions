class Solution {
     public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int ones = 0;
        List<Integer> zeroStart = new ArrayList<>();
        List<Integer> zeroEnd = new ArrayList<>();

        for(char c : s.toCharArray()) {
            if(c == '1') {
                ones++;
            }
        }


        for(int i = 0; i < n;) {
            if(s.charAt(i) == '0') {
                int j = i;
                
                while(j < n && s.charAt(j) == '0') {
                    j++;
                }

                zeroStart.add(i);
                zeroEnd.add(j - 1);
                i = j;
            } else {
                i++;
            }
        }

        int numberBlocks = zeroStart.size();
        int[] V = new int[Math.max(0, numberBlocks - 1)];

        for(int i = 0; i + 1 < numberBlocks; i++) {
            int len1 = zeroEnd.get(i) - zeroStart.get(i) + 1;
            int len2 = zeroEnd.get(i + 1) - zeroStart.get(i + 1) + 1;
            V[i] = len1 + len2;
        }

        int numberValley = V.length;
        List<int[]> sparse = new ArrayList<>();
        sparse.add(V);

        for(int half = 1; half * 2 <= numberValley; half *= 2) {
            int[] prev = sparse.get(sparse.size() - 1);
            int[] next = new int[prev.length - half];

            for(int i = 0; i + half < prev.length; i++) {
                next[i] = Math.max(prev[i], prev[i + half]);
            }

            sparse.add(next);
        }

        List<Integer> ans = new ArrayList<>();

        for(int[] q : queries) {
            ans.add(ones + gain(q[0], q[1], zeroStart, zeroEnd, V, sparse, numberBlocks));
        }

        return ans;
    }

    private int gain(int l, int r, List<Integer> zeroStart, List<Integer> zeroEnd, int[] V, List<int[]> sparse, int numberBlocks) {
        if(numberBlocks < 2) {
            return 0;
        }

        int ja = lowerBound(zeroEnd, l);
        int jb = upperBound(zeroStart, r) - 2;

        if(ja > jb) {
            return 0;
        }

        int ans = Math.max(clip(ja, l, r, zeroStart, zeroEnd, V), clip(jb, l, r, zeroStart, zeroEnd, V));

        if(jb - ja >= 2) {
            ans = Math.max(ans, rmq(ja + 1, jb - 1, sparse));
        }

        return ans;
    }

    private int clip(int j, int l, int r, List<Integer> zeroStart, List<Integer> zeroEnd, int[] V) {
        return V[j] - Math.max(0, l - zeroStart.get(j)) - Math.max(0, zeroEnd.get(j + 1) - r);
    }

    private int rmq(int lo, int hi, List<int[]> sparse) {
        int len = hi - lo + 1;
        int t = 31 - Integer.numberOfLeadingZeros(len);

        int[] row = sparse.get(t);

        return Math.max(row[lo], row[hi - (1 << t) + 1]);
    }

    private int lowerBound(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size();

        while(l < r) {
            int mid = (l + r) / 2;

            if(arr.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private int upperBound(List<Integer> arr, int target) {
        int l = 0;
        int r = arr.size();

        while(l < r) {
            int mid = (l + r) / 2;

            if(arr.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}