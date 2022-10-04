/** Two stacl
* Define two stack, stk and minStk. 
* When pushing an item, if it's greater than the most current min item (on the top of minStk), then only push this item to stk; if it's equal to or smaller than the current min item, then push this item to both stk and minStk.
* similar for popping
*/

class MinStack {
    private Stack<Integer> stk = new Stack<>();
    private Stack<Integer> minStk = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        }
    }
    
    public void pop() {
        if (stk.peek().equals(minStk.peek())) {
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