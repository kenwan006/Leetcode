class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum < 0) sum = 0;
            sum += num;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}