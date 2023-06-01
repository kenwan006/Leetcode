class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i];
        } 
        
        int R = 1;
        for (int i = n - 1; i > 0; i--) {
            res[i] = res[i - 1] * R;
            R = R * nums[i];
        }
        res[0] = R;
        return res;
    }
}
//Time: O(n); Space: extra O(1)
