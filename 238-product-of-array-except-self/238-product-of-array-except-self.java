class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i < ans.length; i++) {
            ans[i] = ans[i -1] * nums[i - 1]; // product of all elements at left of nums[i]
        }
        
        // update ans by multiply the factor R
        int R = 1; 
        for(int i = ans.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        
        return ans;
    }
}