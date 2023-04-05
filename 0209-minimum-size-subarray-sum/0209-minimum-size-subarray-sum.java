/** Sliding window **/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int sum = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }
        return res > nums.length? 0 : res;
    }
}
//TIme: O(n); Space: O(1)