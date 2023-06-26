/** prefix sum + suffix sum 
* prefix[i] - refers to the sum of nums[0..i]; suffix[i] - refers to the sum of nums[i..n-1]
* leftmax[i] - refers to the max prefix sum among {prefix[0],..,prefix[i]}
* rightmax[i] - refers to the max suffix sum among {suffix[i],..,suffix[n-1]}
* Since the subarray could be circular, the max subarray is either 
* a) The normal case - just check all the subarry ending at nums[i], or
* b) The circular case - combine the max subarray before nums[i] and max subarray after nums[i],  nums[i] might be excluded!!
**/
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        
        //find the max prefix sum ealier than nums[i] - inclusive
        int[] leftmax = new int[n];
        int sum = nums[0];
        leftmax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            leftmax[i] = Math.max(leftmax[i - 1], sum);
        }
        
        //find the max suffix sum later than nums[i] - inclusive
        int[] rightmax = new int[n];
        rightmax[n - 1] = nums[n - 1];
        sum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum += nums[i];
            rightmax[i] = Math.max(rightmax[i + 1], sum);
        }
        
        //check the normal case and circular case
        sum = 0;
        int maxsum = Integer.MIN_VALUE; //normal case - subarray ending at nums[i]
        int maxcsum = Integer.MIN_VALUE; //circular case
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            maxsum = Math.max(maxsum, sum);
            if (sum < 0) sum = 0;
            if (i > 0) maxcsum = Math.max(maxcsum, leftmax[i - 1] + rightmax[i]);
        }
        
        return Math.max(maxsum, maxcsum);
    }
}
//Time: O(n); Space: O(n)
