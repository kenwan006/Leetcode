class Solution {
    public int jump(int[] nums) {
        int start = 0, end = 0, n = nums.length;
        int farthest = 0;
        int jump = 0;
        
        while (end < n - 1) {
            for (int i = start; i <= end; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            
            jump++;
            start = end + 1;
            end = farthest;
        }
        
        return jump;
    }
}