/** Monotonic Stack
* heights = [2, 1, 5, 6, 4, 2, 3], when i = 4, we have a stack to store the index {1, 2, 3} whose heights are monotonic {1, 5, 6}
* Since heights[i] < heights[top], top is the top index in the stack. 
* Pop out top index top = 3 whose height is 6 from the stack, and calculate the area = heights[top] * (i - top) = 6 * (4-3) = 6
* Pop out second index top = 2, whose height is 5 from the stack, and calcualte the area = heights[top] * (i - top) = 5 * (4 - 2) = 10 > 6
* Keep popping until heights[i] > heights[top],
* push i to the stack and move the pointer to i+1
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int N = heights.length;
        int maxArea = 0;
        for (int i = 0; i <= N; i++) {
            //When i = N-1 there's always a non-empty stack so we can extend the edge case to i = N, but let h = 0
            int h = i == N? 0 : heights[i];
            
            //Keep popping out the stack unitl heights[top] < heights[i]
            while (!stack.isEmpty() && h <= heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int right = i;
                int left = stack.isEmpty()? - 1 : stack.peek();
                int curArea = (right - left - 1) * curHeight;
                maxArea = Math.max(maxArea, curArea);
            }
            
            //Push the new index to the monotonic stack
            stack.push(i);        
        }
        return maxArea;
    }
}
//Time: O(n); Space: O(n);


/** Dynamic progrmming + memoization 
* For a bar at index i, find the first shorter l bar at its left side and r at its right side
* The area between l and r is: heights[i] * (r - l - 1) = maxArea[i];
*/
/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] smallFromLeft = new int[heights.length]; // index of the first bar shorter than current ith bar at the left
        int[] smallFromRight = new int[heights.length]; // index of the first bar shorter than current ith bar at the right
        smallFromLeft[0] = -1; 
        smallFromRight[heights.length - 1] = heights.length;
        
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1; //pointer left to the current position
            while (p >= 0 && heights[i] <= heights[p]) {
                p = smallFromLeft[p]; // update the pointer and continue finding the shorter height
            }
            smallFromLeft[i] = p;
        }
        
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1; 
            while (p < heights.length && heights[i] <= heights[p]) {
                p = smallFromRight[p];
            }
            smallFromRight[i] = p;
        }
        
        // calculate the max area
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int l = smallFromLeft[i];
            int r = smallFromRight[i];
            maxArea = Math.max(maxArea, (r - l - 1) * heights[i]);
        }
        return maxArea;
    }
}
//Time: O(n); Space: O(n);
*/