class StockSpanner {
    private class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    private Stack<Pair> stack;
    private int counter;

    public StockSpanner() {
        stack = new Stack<>();
        counter = 0;
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && price >= stack.peek().val) {
            stack.pop();
        }

        int lastIdx = stack.isEmpty() ? -1 : stack.peek().idx;
        stack.push(new Pair(price, counter));

        return Math.abs(lastIdx - counter++);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */