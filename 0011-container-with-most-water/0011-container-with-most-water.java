class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, area = 0, maxArea = 0;
        while (i < j) {
            int w = j - i;
            if (height[i] < height[j]) {
                area = height[i++] * w;
            } else {
                area = height[j--] * w;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
//Time: O(n); Space: O(1)
