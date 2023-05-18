/** Greedy
* find the farthest position one can jump to from nums[i]
*/
class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest == i) return false;
        }
        return farthest >= nums.length - 1;
    }
}
//Time: O(n); Space: O(1)