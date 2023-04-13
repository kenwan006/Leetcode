/** prefix *
* Calculate the prefix for each num -- product of all nums at the left side of nums[i]
* Iterate the nums reversely, let R be the product of nums at the right side of nums[i]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) { //product of nums[0] * nums[1] ..nums[i-1]
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        int R = 1;
        for (int j = n - 1; j >= 0; j--) {//keep updating R - product of all nums at right side of nums[i]
            res[j] = res[j] * R;
            R *= nums[j];
        }
        return res;
    }
}
//Time: O(n); Space: extra O(1)