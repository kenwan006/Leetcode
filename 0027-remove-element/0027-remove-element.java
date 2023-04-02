/** Two pointer */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        //find the index of first num equal to val
        while (i < nums.length && nums[i] != val) i++;
        
        //find the num not equal to val and move to the front
        int j = i + 1;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
            } else {
                 nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
//Time: O(n); Space: O(1)