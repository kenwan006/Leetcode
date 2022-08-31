class Solution {
    public void sortColors(int[] nums) {
        int lo = 0, hi = nums.length - 1, cur = 0;
        while(cur <= hi) {
            if(nums[cur] == 0) swap(nums, lo++, cur++);
            else if(nums[cur] == 2) swap(nums, cur, hi--);//Not cur++, 0 might be swapped to cur and need re-check
            else cur++; 
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}