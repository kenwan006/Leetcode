class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, lmax = 0, rmax = 0, res = 0;
        while (left < right) {
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            if (lmax < rmax) res += (lmax - height[left++]);
            else res += (rmax - height[right--]);
        }
        return res;
    }
}