class MyStack {
    Queue<Integer> queue1 = new LinkedList<>(); // always save the most rencet item to the front of the queue
    Queue<Integer> queue2 = new LinkedList<>(); // auxiliary queue
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        //swap queue1 and queue2
        queue1 = queue2;
        queue2 = new LinkedList<>(); // reset the aux queue
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */