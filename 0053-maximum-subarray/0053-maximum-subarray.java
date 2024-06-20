class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sub = 0; //sum of a subarry ending with nums[i]
        for (int num : nums) {
            sub = Math.max(num, sub + num);
            max = Math.max(max, sub);
        }
        return max;
    }
}