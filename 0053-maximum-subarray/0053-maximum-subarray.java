class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int subsum = 0; // max sub sum ending with current nums[i]
        
        for (int num : nums) {
            subsum = Math.max(subsum + num, num);
            max_sum = Math.max(max_sum, subsum);
        }
        
        return max_sum;
    }
}

//Time: O(n); Space: O(1)

