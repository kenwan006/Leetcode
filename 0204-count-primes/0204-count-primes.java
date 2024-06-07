class Solution {
    public int countPrimes(int n) {
        int[] dp = new int[n]; // dp[i] = 1 if i is prime, 0 if it's not
        Arrays.fill(dp, 1);
        
        for (int i = 2; i < n; i++) {
            if (dp[i] == 0) continue;
            
            //set k * i to 0
            for (int k = 2; k * i < n; k++) {
                dp[k * i] = 0;
            }
        }
        
        //count the prime
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i] == 1) res++;
        }
        return res;
    }
}