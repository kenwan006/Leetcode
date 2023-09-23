class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1, len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) len++;
            else len = 1;
            res = Math.max(res, len);
        }
        return res;
    }
}
//Time: O(n); Space: O(1)

