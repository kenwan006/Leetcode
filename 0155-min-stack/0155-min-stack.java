/** Two stacks *
* Push item to stk, if this item < top item in minStk, then push this item to minStk;
* If this item == top item in minStk, then push this item to minStk;
* If this item > top item in minStk, then no need to push this item to minStk
*/
class MinStack {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> minStk = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        if (minStk.isEmpty() || val <= minStk.peek()) minStk.push(val);
        stk.push(val);
    }
    
    public void pop() {
        if (stk.peek().equals(minStk.peek())) minStk.pop();
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