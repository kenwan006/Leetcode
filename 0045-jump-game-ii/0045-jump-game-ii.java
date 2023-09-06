class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int start = 0, end = 0, farthest = 0, n = nums.length;
        while (farthest < n - 1) {
            for (int i = start; i <= end && i < n; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            jump++;
            
            //range for the next starting point
            start = end + 1;
            end = farthest;
        }
        return jump;
    }
}
//Time: O(n); Space: O(1)

