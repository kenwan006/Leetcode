/** Prefix sum + Hashtable *
* Two prefix sum, sum[i], sum[j], if sum[i] %k ==sum[j] %k, then (sum[j] -sum[i]) % k =0. It means subarrays nums[i,j] sums divisble by k;
* Use a hashmap to store the count of each remainder of each prefix sum. sum[i] % k --> count
* Attention: the remainder might be negative, in this case remainder = k + (sum[i] % k).
*/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, count = 0;
        int[] remainder = new int[k];
        
        //if a prefix sum[i] % k == 0, then nums[0..i] itself sums divisible by k;
        remainder[0] = 1; 
        
        for (int num : nums) {
            sum += num;
            int rem = sum % k;
            if (rem < 0) rem  += k;
            
            count += remainder[rem]; 
            remainder[rem]++;
            
        }
        return count;
    }
}
//Time: O(n); Space: O(k)

