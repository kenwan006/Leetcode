class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 1;
        
        //find the peak i from right to left
        while (i > 0 && nums[i - 1] >= nums[i]) i--;
        
        //if the whole nums is descendent, then just reverse it
        if(i == 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // now we have nums[0.., i - 1, i=peak, i + 1...n-1]
        // find the smallest one from nums[i..n-1] that is greater than nums[i-1], swap them
        // then reverse nums[i..n-1]
        int j = n - 1;
        while (j > i && nums[j] <= nums[i - 1]) j--;
        swap(nums, i - 1, j);
        reverse(nums, i, n - 1);
    }
    
    private void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
            
    }
    private void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp; 
    }
}