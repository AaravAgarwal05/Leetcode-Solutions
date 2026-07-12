class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int rank = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[n];
        
        for(int x : arr) {
            pq.add(x);
        }
        
        while(!pq.isEmpty()) {
            if(!map.containsKey(pq.peek())) {
                map.put(pq.peek(), rank++);
            }
            
            pq.poll();
        }
        
        for(int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}