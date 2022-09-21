/** Dynamic progrmming + memoization 
* For a bar at index i, find the first shorter l bar at its left side and r at its right side
* The area between l and r is: heights[i] * (r - l - 1) = maxArea[i];
*/

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