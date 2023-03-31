class Solution {
    public void moveZeroes(int[] nums) {
        //check from left to right, put non zero to the front
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) nums[j++] = nums[i];
        }
        
        //fill the 0s
        for (int i = j; i < nums.length; i++) nums[i] = 0;
    }
}
//Time: O(n); Space: O(1)