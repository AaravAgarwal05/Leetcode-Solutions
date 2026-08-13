class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] res = new long[n];

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            
            map.get(arr[i]).add(i);
        }

        for(int key : map.keySet()) {
            List<Integer> list = map.get(key);
            int lSize = list.size();
            List<Long> pSum = new ArrayList<>();
            pSum.add((long)list.get(0));

            for(int i = 1; i < lSize; i++) {
                pSum.add(pSum.get(i - 1) + list.get(i));
            }

            for(int i = 0; i < lSize; i++) {
                long leftSize = i - 0;
                long leftPSum = 0;

                if(leftSize > 0) {
                    leftPSum = leftSize * list.get(i) - pSum.get(i - 1);
                }

                long rightSize = lSize - i - 1;
                long rightPSum = 0;

                if(rightSize > 0) {
                    rightPSum = pSum.get(pSum.size() - 1) - pSum.get(i) - rightSize * list.get(i);
                }

                res[list.get(i)] = leftPSum + rightPSum;
            }
        }

        return res;
    }
}