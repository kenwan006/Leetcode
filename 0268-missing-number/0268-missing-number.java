class Solution {
    public int missingNumber(int[] nums) {
        //a ^ b = b ^ a, a ^ b ^ c = a ^ c ^ b...
        int res = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++) res ^= i;
        for (int num : nums) res ^= num;
        
        return res;
    }
}