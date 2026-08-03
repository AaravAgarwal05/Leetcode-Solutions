class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int mid = arr[((n - 1) / 2)];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a - mid) > Math.abs(b - mid)) {
                return -1;
            } else if (Math.abs(a - mid) < Math.abs(b - mid)) {
                return 1;
            } else {
                return b - a;
            }
        });
        int[] result = new int[k];

        for(int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}