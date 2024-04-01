class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        //move all zeros to the end
        int j = 0; //spot to store non zero element
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        
        for (; j < n; j++) nums[j] = 0;
        return nums;
    }
}
//Time: O(n); Space: O(1)

