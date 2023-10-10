class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int area = 0, maxArea = 0;
        while (i < j) {
            int w = j - i, h = 0;
            if (height[i] >= height[j]) {
                h = height[j];
                j--;
            } else {
                h = height[i];
                i++;
            }
            area = w * h;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}