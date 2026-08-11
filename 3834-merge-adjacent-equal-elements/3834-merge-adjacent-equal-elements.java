class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> stack = new Stack<>();

        for(int x : nums) {
            long t = x;

            while(!stack.isEmpty() && stack.peek() == t) {
                t += stack.pop();
            }

            stack.push(t);
        }

        return new ArrayList<>(stack);
    }
}