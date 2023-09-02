/** Greedy **
** Find the peaks and troughs
**/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        Integer prev = null, curr = null; // 1 - increase; -1 - decrease; 0 - flat
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            //check the current trend
            if (nums[i] == nums[i + 1]) continue;
               
            if (nums[i] < nums[i + 1]) {
                curr = 1;
            } else {
                curr = -1;
            }
            
            //compare with previous trend
            if (prev == null || curr * prev == - 1) {
                count++;
            }
            
            prev = curr;
        }
        return count;
    }
}
//Time: O(n); Space: O(1)