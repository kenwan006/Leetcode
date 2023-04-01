/** Reverse array
* The last k items in the nums will be rotated to the first k position.
* Reverse the entire nums, the last k items get to the first k positions and reverse them to get the original order;
* Reverse the (n - k) items too.
*/
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; 
            end--;
        }
    }
}
//Time: O(n); Space: O(1)