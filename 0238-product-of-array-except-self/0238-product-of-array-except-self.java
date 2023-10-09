class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; //res[i] - product of nums to the left of nums[i] not including nums[i]
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        int R = 1; //product of suffix of nums[i]
        for (int i = n - 1; i >= 0; i--) {
            res[i] = res[i] * R;
            R = R * nums[i]; //update R as i moves to the left
        }
        return res;
    }
}