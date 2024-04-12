/** Sliding window **/
class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, count = 0;
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) count++;
            
            //shrink the left bound of the window if too many 0s
            while (i < j && count > 1) {
                if (nums[i] == 0) count--;
                i++;
            }
            
            res = Math.max(res, j - i);
        }
        return res;
    }
}
//Time: O(n); Space: O(1)

