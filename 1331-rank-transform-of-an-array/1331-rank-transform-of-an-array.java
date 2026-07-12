class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int rank = 1;
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = Arrays.copyOf(arr, n);
        int[] result = new int[n];
        Arrays.sort(temp);
        
        for(int x : temp) {
            if(!map.containsKey(x)) {
                map.put(x, rank++);
            }
        }
        
        for(int i = 0; i < n; i++) {
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}