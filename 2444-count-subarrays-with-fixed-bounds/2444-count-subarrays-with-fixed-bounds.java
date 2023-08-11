/** Two Pointer 
* Iterate over nums, if nums[i] < minK || nums[i] > maxK, then it cannot be in the subarray, or say it's out of range
* lbound - the nearest position to the left of current position i and out of range [minK, maxK]
* minLoc- most current position where nums[i] = minK; maxLoc - most current position where nums[i] = maxK
* For the subarray we are looking for, it's right bound = i if nums[i] is in the range, its left bound could vary in range of [lbound+1, min{minLoc, maxLoc}]
* The number of valid subarray ending at i depends on the options of left bound of this subarray, which is min{minLoc, maxLoc} - lbound
**/
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minLoc = -1, maxLoc = -1, lbound = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lbound = i;
                continue;
            }
            
            if (nums[i] == minK) {
                minLoc = i;
            }
            
            if (nums[i] == maxK) {
                maxLoc = i;
            }
            
            //count the subarrays ending at i with fixed bound of minK and maxK
            res += Math.max(0, Math.min(minLoc, maxLoc) - lbound);
        }
        return res;
    }
}
//Time: O(n); Space: O(1)
