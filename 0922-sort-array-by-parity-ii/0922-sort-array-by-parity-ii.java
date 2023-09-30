class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1; //odd position
        for (int even = 0; even < nums.length; even += 2) { 
            if (nums[even] % 2 == 1) { //even position has an odd num
                while (nums[odd] % 2 == 1) { //find an odd position that has an even num
                    odd += 2;
                }
                swap(nums, even, odd); //swap
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
//Time: O(n); Space: O(1)
