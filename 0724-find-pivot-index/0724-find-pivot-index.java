class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n]; //prefix[i] - sum of nums before nums[i] - exclusively
        int[] suffix = new int[n]; //suffix[i] - sum of nums behind nums[i] - exclusively
        
        for (int i = 1; i < n; i++) prefix[i] = prefix[i - 1] + nums[i - 1];
        for (int i = n - 2; i >= 0; i--) suffix[i] = suffix[i + 1] + nums[i + 1];
        
        for (int i = 0; i < n; i++) {
            if (prefix[i] == suffix[i]) return i;
        }
        return -1;
    }
}
//Time: O(n); Space: O(n)