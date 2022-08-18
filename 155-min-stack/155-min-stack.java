class MinStack {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> minStk = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stk.push(val);
        if(minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        }
    }
    
    public void pop() {
        if(minStk.peek().equals(stk.peek())) {
            minStk.pop();
        }
        stk.pop();        
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */