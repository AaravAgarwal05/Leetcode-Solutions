import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int maxE = max(nums);
        int[] freq = new int[maxE + 1];
        long[] gcd = new long[maxE + 1];

        for(int num : nums) {
            freq[num]++;
        }

        for(int i = maxE; i >= 1; i--) {
            long count = 0;

            for(int j = i; j <= maxE; j += i) {
                count += freq[j];
            }

            gcd[i] = (count * (count - 1)) / 2;

            for(int j = 2 * i; j <= maxE; j += i) {
                gcd[i] -= gcd[j];
            }
        }

        for(int i = 1; i <= maxE; i++) {
            gcd[i] += gcd[i - 1];
        }

        for(int i = 0; i < n; i++) {
            answer[i] = upperBound(gcd, queries[i]);
        }

        return answer;
    }

    private int upperBound(long[] arr, long target) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int max(int[] nums) {
        int mx = 0;

        for(int num : nums) {
            mx = Math.max(mx, num);
        }

        return mx;
    }
}