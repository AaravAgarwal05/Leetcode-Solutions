class Solution {
    private class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Pair> stack = new Stack<>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > stack.peek().val) {
                res[stack.peek().idx] = i - stack.pop().idx;
            }

            stack.push(new Pair(temperatures[i], i));
        }

        while(!stack.isEmpty()) {
            res[stack.pop().idx] = 0;
        }

        return res;
    }
}