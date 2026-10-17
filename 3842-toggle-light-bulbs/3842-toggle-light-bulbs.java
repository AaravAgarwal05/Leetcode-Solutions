class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int b : bulbs) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for(int k : map.keySet()) {
            if(map.get(k) % 2 != 0) {
                res.add(k);
            }
        }

        Collections.sort(res);
        return res;
    }
}