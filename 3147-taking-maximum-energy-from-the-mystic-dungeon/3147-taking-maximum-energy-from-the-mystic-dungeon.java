class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int res = Integer.MIN_VALUE;
        
        for (int i = n - 1; i >= n - k; i--) { //we only need to check kth num for the outer loop
            for (int j = i; j >= 0; j -= k) {
                if (j >= n - k) dp[j] = energy[j];
                else dp[j] = energy[j] + dp[j + k];
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }
}