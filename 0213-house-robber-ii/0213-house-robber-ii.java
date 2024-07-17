class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(rob(0, n - 2, nums), rob(1, n - 1, nums));
    }
    
    private int rob(int start, int end, int[] nums) {
        int prev1 = nums[start], prev2 = 0;
        for (int i = start + 1; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1; 
            prev1 = curr;
        }
        return Math.max(prev1, prev2);
    }
}