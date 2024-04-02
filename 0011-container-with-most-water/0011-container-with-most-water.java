class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int res = 0;
        while (i < j) {
            int h = 0, w = j - i;
            if (height[i] < height[j]) {
                h = height[i++];
            } else {
                h = height[j--];
            }
            res = Math.max(res, h * w);
        }
        return res;
    }
}