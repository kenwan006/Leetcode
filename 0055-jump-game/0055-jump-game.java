class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest == i) return false; //after the jump, the farthest place is still the starting position
        }
        return true;
    }
}