class Solution {
    public boolean canJump(int[] nums) {
        int i = 1, n = nums.length;
        int start = 1, end = nums[0];
        int farthest = 0;
        while (i < n) {
            for (int j = start; j <= end && j < n; j++) {
                farthest = Math.max(farthest, j + nums[j]);
            }
            //update starting position for the next jump
            i++;
            start = end + 1;
            end = farthest;
            if (end >= n - 1) return true;
        }
        return farthest >= n - 1;
    }
}