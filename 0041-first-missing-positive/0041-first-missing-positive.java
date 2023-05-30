/** Index as hash key *
* Check if 1 exists - if nums not contains 1, then the smallest positive integer is 1; otherwise need futher check
* When 1 exists, iterate over the nums and replace all negative int to 1.
* Iterate over the nums again, set let index = abs(nums[i]) and set nums[index] = -abs(nums[index]).
* Iterate over the nums again, find the first i such that nums[i] < 0.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean contains = false;
        //check if nums contains 1
        for (int num : nums) {
            if (num == 1) {
                contains = true;
                break;
            }
        }
        if (!contains) return 1; 
        
        //replace 0, negative int and large int to 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }
        
        //now all num >= 1, set nums[num] = -nums[num] representing num exist in nums
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if (index == n) nums[0] = -n; 
            else nums[index] = -Math.abs(nums[index]);
        }
        
        //find the first i such that nums[i] < 0
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return n;
        else return n + 1;
    }
}
//Time: O(n); Space: O(1)
