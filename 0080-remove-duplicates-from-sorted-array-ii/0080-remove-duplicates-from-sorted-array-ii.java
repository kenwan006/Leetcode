/** Two pointers
* Two pointers i and j, both starting from 0
* count - count the duplicate numbers. If nums[i] == nums[i-1], then count++, otherwise reset count to 1.
* Each element can appear at most twice, so only when count <= 2, one save this element to nums[j], and move j to the next position.
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0; //next position to store num
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) count++;
            else count = 1;
            
            //check if one should include this item to the "new" array
            if (count <= 2) nums[j++] = nums[i];
        }
        return j;
    }
}
//Time: O(n); Space: O(1)