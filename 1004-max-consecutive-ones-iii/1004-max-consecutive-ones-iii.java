class Solution {
    public int longestOnes(int[] nums, int k) {
        //sliding window [i, j]
        int res = 0;
        int i = 0;
        int count = 0; // count of 0
        
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) count++;
            //shrink the left bound to ensure count of 0 <= k
            while (i <= j && count > k) {
                if (nums[i] == 0) count--;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
//Time: O(n); Space: O(1)

