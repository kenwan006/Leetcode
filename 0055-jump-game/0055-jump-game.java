class Solution {
    public boolean canJump(int[] nums) {
        int farthest = nums[0]; //keep updating the farthest position one cen jump to
        for (int i = 1; i < nums.length; i++) {
            if (farthest < i) return false;
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }
}
//Time: O(n); Space: O(1)
