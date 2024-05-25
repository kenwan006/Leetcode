class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        int res = -1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < k) {
                res = Math.max(res, sum);
                lo++;
            } else {
                hi--;
            }
        }
        return res;
    }
}