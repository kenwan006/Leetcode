class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int currHeight = maxHeights.get(i);
            while (!stack.isEmpty() && currHeight < maxHeights.get(stack.peek())) stack.pop();
            
            if (stack.isEmpty()) {
                left[i] = (long) currHeight * (i + 1);
            } else {
                int prev_i = stack.peek();
                left[i] = (long) currHeight * (i - prev_i) + left[prev_i];
            }
            stack.push(i);
        }
        
        stack.clear();
        long[] right = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int currHeight = maxHeights.get(i);
            while (!stack.isEmpty() && currHeight < maxHeights.get(stack.peek())) stack.pop();
            
            if (stack.isEmpty()) {
                right[i] = (long) currHeight * (n - i);
            } else {
                int prev_i = stack.peek();
                right[i] = (long) currHeight * (prev_i - i) + right[prev_i];
            }
            stack.push(i);
        }
        
        long res = 0;
        for (int i = 0; i < n; i++) {
            long sum = left[i] + right[i] - maxHeights.get(i); //maxHeight[i] added twice
            res = Math.max(res, sum);
        }
        return res;
    }
}