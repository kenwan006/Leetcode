class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // the next spot to store non zero element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            nums[j++] = nums[i];
        }
        
        for (; j < nums.length; j++) nums[j] = 0; 
    }
}