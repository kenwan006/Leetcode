class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        int i = 0;
        while (i < n) {
            int idx = nums[i] - 1; //correct position
            if (nums[i] != nums[idx]) swap(nums, idx, i); //num should be put to the correct position, idx instead of i
            else i++;
        }
        
        //find the nums not in the correct positions
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) res.add(nums[i]);
        }
        
        return res;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}