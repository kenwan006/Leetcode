class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, n = nums.length;
        int sum = 0;
        
        while (k > 0 && i < n && nums[i] < 0) {
            nums[i] = -nums[i++]; //flip the smallest negative num
            k--;
        }
        
        Arrays.sort(nums); //sort again after flipping..
        
        nums[0] = k % 2 == 0? nums[0] : -nums[0];
        
        for (int num : nums) {
            sum += num;
        }
        return sum;
        
    }
}
//Time: O(n * log(n)); Space: O(1)

