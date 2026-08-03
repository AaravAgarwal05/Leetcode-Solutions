class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int tl = tasks.length;
        int sl = shifts.length;
        long[] prefixSum = new long[tl];
        prefixSum[0] = tasks[0];
        int[] result = new int[sl];

        for(int i = 1; i < tl; i++) {
            prefixSum[i] = prefixSum[i - 1] + tasks[i];
        }

        long totalTime = prefixSum[tl - 1];
        long currentCompletedWork = 0;

        for(int i = 0; i < sl; i++) {
            currentCompletedWork += shifts[i];

            if(currentCompletedWork >= totalTime) {
                result[i] = 0;
                currentCompletedWork = 0;
            } else {
                result[i] = tl - binarySearch(prefixSum, currentCompletedWork) - 1;
            }
        }

        return result;
    }

    public int binarySearch(long[] tasks, long target) {
        int s = 0;
        int e = tasks.length - 1;
        int ans = -1;

        while(s <= e) {
            int mid = s + (e - s) / 2;

            if(tasks[mid] == target) {
                return mid;
            } else if(tasks[mid] < target) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return ans;
    }
}