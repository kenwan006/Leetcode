class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        swap(nums, 0, n - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, n - 1);
    }
    
    private void swap(int[] nums, int lo, int hi) {
        while (lo < hi) {
            int tmp = nums[lo];
            nums[lo++] = nums[hi];
            nums[hi--] = tmp;
        }
    }
}
//Time: O(n); Space: O(1)

