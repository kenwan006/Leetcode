class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0; // j points to the next non-zero num
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        
        //set the remaining to 0s
        for (; j < nums.length; j++) nums[j] = 0;
    }
}