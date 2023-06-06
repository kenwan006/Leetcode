/** Sliding window **/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, res = n + 1;
        int i = 0, j = 0, sum = nums[0];
        while (i <= j && j < n) {
            if (sum < target) {
               if (++j < n) sum += nums[j];
            } else {
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
        }
        return res == (n + 1)? 0 : res;
    }
}
//Time: O(n); Space: O(1)
