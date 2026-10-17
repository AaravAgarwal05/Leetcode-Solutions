class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int time = 0;
        int p = processorTime.size();
        int t = tasks.size() - 1;

        for(int i = 0; i < p; i++) {
            int curr = 0;
            curr += processorTime.get(i);
            curr += tasks.get(t);
            t -= 4;
            time = Math.max(time, curr);
        }

        return time;
    }
}