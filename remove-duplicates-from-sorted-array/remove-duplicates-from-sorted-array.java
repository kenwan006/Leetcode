class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
                count++;
            }
        }
        return count;
    }
}
//Time:O(n); Space: O(1)