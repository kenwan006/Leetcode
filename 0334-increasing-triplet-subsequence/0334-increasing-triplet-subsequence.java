/** Greedy
* first and second - samllest and second smallest num
* Iterate from left to right, compare each num with first and second
* If num <= first, then update first, otherwise if num <= second, update second. When num is greater than both first and second, return true;
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        
        return false;
    }
}
//Time: O(n); Space: O(1)
