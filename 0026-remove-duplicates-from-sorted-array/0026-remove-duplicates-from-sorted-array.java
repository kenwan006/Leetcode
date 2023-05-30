/** Two pointer **/
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1; //position to place next num
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) nums[j++] = nums[i];
        }
        return j;
    }
}
//Time: O(n); Space: O(1)