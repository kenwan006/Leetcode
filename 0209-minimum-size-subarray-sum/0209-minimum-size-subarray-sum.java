class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, res = n + 1;
        int l = 0, sum = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target) {//shrink window by moving left bound
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res > n? 0 : res;
    }
}