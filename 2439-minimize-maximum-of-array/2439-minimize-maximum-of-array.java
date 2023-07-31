/** prefix sum **/
class Solution {
    public int minimizeArrayValue(int[] nums) {
        int res = 0;
        double prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int avg = (int) Math.ceil(prefix / (i + 1)); //ceiling value of avg of subarray nums[0..i]
            res = Math.max(res, avg);
        }
        return res;
    }
}
//Time: O(n); Space: O(1)

