class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
                k--;
            }
        }
        
        int sum = 0, min = 101;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        
        sum = k % 2 == 0? sum : sum - 2 * min;
        
        return sum;
    }
}
//Time: O(n * log(n)); Space: O(1)

