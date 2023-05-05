/** dp **
* If 0th num robbed, then (n-1)th cannot be robbed; If 0th not robbed, then (n-1) can be robbed.
* use two dp
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        //0th num not robbed
        int[] dp1 = new int[n]; 
        dp1[0] = 0;
        dp1[1] = nums[1];
        for (int i = 2; i < n; i++) dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        
        //(n-1)th num not robbed
        int[] dp2 = new int[n];
        dp2[0] = nums[0];
        dp2[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        
        return Math.max(dp1[n - 1], dp2[n - 2]);
    }
}
//Time: O(n); Space: O(n)