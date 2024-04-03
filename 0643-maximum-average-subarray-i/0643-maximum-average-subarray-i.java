class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        
        double max = sum;
        for (int i = 0, j = k; j < nums.length; i++, j++) { //i start from 0 not 1 !!
            sum += (nums[j] - nums[i]);
            max = Math.max(max, sum);
        }
        
        return max / k;
    }
}