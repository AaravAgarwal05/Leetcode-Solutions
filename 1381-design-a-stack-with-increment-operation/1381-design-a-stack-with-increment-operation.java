class CustomStack {
    int[] stack;
    int top;
    int size;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];   
        top = -1; 
        size = maxSize;
    }
    
    public void push(int x) {
        if(top + 1 < size) {
            stack[++top] = x;
        }
    }
    
    public int pop() {
        if(top >= 0) {
            return stack[top--];
        }

        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < k && i <= top; i++) {
            stack[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */