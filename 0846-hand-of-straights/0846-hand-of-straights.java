class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if(n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        for(int h : hand) {
            map.put(h, map.getOrDefault(h, 0) + 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) == 0) {
                continue;
            }

            for(int i = 1; i < groupSize; i++) {
                if(!map.containsKey(key + i) || map.get(key + i) < map.get(key)) {
                    return false;
                }

                map.put(key + i, map.get(key + i) - map.get(key));
            }
        }

        return true;
    }
}