class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int ops = 0;

        for(int key : map.keySet()) {
            int val = map.get(key);

            if(val < 2) {
                return -1;
            }

            if (val % 3 == 0) {
                ops += val / 3;
            } else if (val % 3 == 1) {
                ops += (val - 4) / 3 + 2;
            } else {
                ops += val / 3 + 1;
            }
        }

        return ops;
    }
}