/** Two pointers **/
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1, area = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                area = height[i] * (j - i);
                i++;
            } else {
                area = height[j] * (j - i);
                j--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
//Time: O(n); Space: O(1)