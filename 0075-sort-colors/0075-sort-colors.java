class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        
        for (int num : nums) {
            if (num == 0) zeros++;
            if (num == 1) ones++;
            if (num == 2) twos++;
        }
        for (int i = 0; i < zeros; i++) nums[i] = 0;
        for (int i = zeros; i < zeros + ones; i++) nums[i] = 1;
        for (int i = zeros + ones; i < n; i++) nums[i] = 2;
    }
}