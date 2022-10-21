/** Two pointers
* if nums[l] + nums[r] > target, move r to left by 1;
* if nums[l] + nums[r] < target, move l to the right by 1;
* if nums[l] + nums[r] == target, return [l, r]
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum > target) r--;
            else if (sum < target) l++;
            else break; //it's given there's exaactly one solution
        }
        return new int[]{l + 1, r + 1};   
    }
}

//Time: O(n); Space: O(1);