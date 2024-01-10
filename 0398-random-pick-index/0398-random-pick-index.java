class Solution {
    int[] nums;
    Random random;
    
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int count = 0; //nums of target.
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
        /** 
          Randomly select an int from 0 to the count
          If x equals 0, set the res as the current index. The probability is always 1/count for the latest appeared number.
          For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums). 
        **/
            if (nums[i] == target) {
                count++;
                int x = random.nextInt(count);
                res = x == 0? i : res; // the reason is prob for x==0 is always 1/count
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */