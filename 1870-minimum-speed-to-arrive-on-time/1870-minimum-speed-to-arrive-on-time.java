class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;

        if(hour <= n - 1) {
            return -1;
        }

        int speed = 1;
        int maxi = 10000000;
        int ans = -1;

        while(speed <= maxi) {
            double time = 0;
            int mid = speed + ((maxi - speed)/2);

            for(int i = 0; i < n - 1; i++) {
                time += Math.ceil((double)dist[i] / mid);
            }

            time += (double)dist[n - 1] / mid;

            if(time <= hour) {
                ans = mid;
                maxi = mid - 1;
            } else{
                speed = mid + 1;
            }
        }

        return ans;
    }
}