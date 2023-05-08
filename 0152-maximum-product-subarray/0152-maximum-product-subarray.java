/** dp **/
class Solution {
    public int maxProduct(int[] nums) {
        int imin = nums[0]; //min product of subarray ending with nums[i]
        int imax = nums[0]; //max product of subarray ending with nums[i]
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp_max = Math.max(nums[i], Math.max(imin * nums[i], imax * nums[i]));
            imin = Math.min(nums[i], Math.min(imin * nums[i], imax * nums[i]));
            imax = temp_max;
            
            res = Math.max(res, imax);
        }
        return res;
    }
}
//Time: O(n); Space: O(1)

