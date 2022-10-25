/** Monotonic Stack 
* Define a monotonic deque. Iterate over the arrays, always put the index which has the current highest temperature to the front of the deque.
* When adding new item i to the deque, pop out all items x that x < i and temps[x] < temps[i] from the deque.
* Every time popping out an item x, we can say i is the first warmer day after this x
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int x = stack.pop();
                res[x] = i - x;
            }
            stack.push(i);     
        }
        
        return res;
    }
}

// Time: O(n); Space: O(n)