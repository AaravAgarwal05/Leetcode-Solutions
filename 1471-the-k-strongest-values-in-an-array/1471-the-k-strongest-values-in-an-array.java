class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int mid = arr[(n - 1) / 2];
        Integer[] nums = new Integer[arr.length];

        for(int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> {
            int da = Math.abs(a - mid);
            int db = Math.abs(b - mid);

            if (da != db) {
                return Integer.compare(db, da);
            }

            return Integer.compare(b, a);
        });
        int[] result = new int[k];

        for(int i = 0; i < k; i++) {
            result[i] = nums[i];
        }

        return result;
    }
}