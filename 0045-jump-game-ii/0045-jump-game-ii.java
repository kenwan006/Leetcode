class Solution {
    public int jump(int[] nums) {
        int curr_farthest = 0, next_farthest = 0, jump = 0;
        
        //careful: use i < nums.length -1 just in case curr_farthest = n - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            next_farthest = Math.max(next_farthest, nums[i] + i);
            if (i == curr_farthest) { 
                curr_farthest = next_farthest;
                jump++;
            }
        }
        return jump;
    }
}
//Time: O(n); Space: O(1)

