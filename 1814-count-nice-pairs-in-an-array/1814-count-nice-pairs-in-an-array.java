class Solution {
    public int countNicePairs(int[] nums) {
        /**
        * A + rev(B) == B + rev(A) --> A - rev(A) == B - rev(B)
        */
        int MOD = 1000000007;
        
        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            nums[i] -= rev;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            ans = (ans + map.getOrDefault(num, 0)) % MOD;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
    
    private int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}