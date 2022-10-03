/** Iterative
* The first for loop, for the nums[i], calculate product of all the numbers at the left of nums[i], which is nums[0] * nums[1] *...*nums[i-1]
* The second for loop, starting from the end, for the nums[i], calculate product of all numbers at the right of nums[i]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        int R = 1; // R represents product of all nums at right of nums[i]
        for (int i = nums.length - 2; i >= 0; i--) {
            R = R * nums[i + 1];
            ans[i] = ans[i] * R; 
        }
        return ans;
    }
}