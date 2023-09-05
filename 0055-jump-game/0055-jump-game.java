class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int start = 0, end = 0, farthest = 0;
        for (int jump = 0; jump < n; jump++) {
            for (int i = start; i <= end && i < n; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            start = end + 1;
            end = farthest;
        }
        return farthest >= n - 1;
    }
}