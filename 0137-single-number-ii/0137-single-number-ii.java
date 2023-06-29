/** Each num has 32bits, for each bit, count how many 1s, and then sum % 3 will be the value of the target num at this bit position
**/
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0; 
            for (int num : nums) {
                sum += (num >> i) & 1; //count 1s at ith bit position for all nums
            }
            sum %= 3;
            
            if (sum != 0) ans = ans | sum << i;
        }
        return ans;
    }
}
//Time: O(n); Space: O(1)
