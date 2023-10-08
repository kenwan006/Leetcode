/** Gravity to Bits *
** Note that nums[i] + nums[j] = (nums[i] & nums[j]) + (nums[i] | nums[j]); this is the Principle of Inclusion Exclusion. Thus, the sum of all the elements after some operations is constant. To maximize the sum of squares, we want a few of the elements to be large while the rest are small.
** Imagine a tower of stones where gravity is off. The initial state is:

101001111011
101110111011
101110101010
101101000010
100100110011
001010110000

If we turn on gravity and let the stones fall, we get:

000000000000
101000100010
101100110010
101110111011
101111111011
101111111011
**/
class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & 1) == 1) counts[i]++;
                num = num >>> 1;
            }
        }
        
        long sum = 0, curr = 0; // current largest num
        long mod = 1000000007;
        //get the kth largest nums
        for (int j = 0; j < k; j++) {
            curr = 0;
            for (int i = 0; i < 32; i++) {
                if (counts[i] > 0) {
                    counts[i]--;
                    curr = curr + (1 << i);
                }
            }
            sum = (sum + curr * curr) % mod;
        }
        return (int) sum;
    }
}
