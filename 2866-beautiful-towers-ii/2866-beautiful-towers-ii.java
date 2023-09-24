class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n]; //left[i] - sum of the heights of the beautiful tower maxHeights[0..i]
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            /** Iterate over from left to right, if the height is increasing, then push its index to the stack;
            **  Otherwise, keep popping out until find the index = prev_i on the top with height  <= curr height
            **  - All the height between (prev_i, i] has to be set to curr height
            **/
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
        long[] right = new long[n]; //right[i] - sum of the heights of the beautiful tower maxHeights[i.. n-1]
        for (int i = n - 1; i >= 0; i--) {
            /** Iterate over from right to left, if the height is increasing, then push its index to the stack; Otherwise... **/
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
            long sum = left[i] + right[i] - maxHeights.get(i); //maxHeights[i] added twice
            res = Math.max(res, sum);
        }
        return res;
    }
}
//Time: O(n); Space: O(n)
