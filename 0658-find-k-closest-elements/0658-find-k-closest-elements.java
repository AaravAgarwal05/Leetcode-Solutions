class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a - x) == Math.abs(b - x)) {
                return a - b;
            }

            return Math.abs(a - x) - Math.abs(b - x);
        });

        for(int e : arr) {
            pq.add(e);
        }

        List<Integer> result = new ArrayList<>();

        while(result.size() < k) {
            result.add(pq.poll());
        }

        Collections.sort(result);

        return result;
    }
}