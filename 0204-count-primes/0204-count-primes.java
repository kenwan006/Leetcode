class Solution {
    public int countPrimes(int n) {
        int[]dp = new int[n]; // dp[i] - 1 means i is prime, -1 means non prime
        Arrays.fill(dp, 1);
        
        for (int i = 2; i < n; i++) {
            if (dp[i] == -1) continue;
            
            //all the number 2i, 3i, 4i...are non primes
            for (int k = 2; k * i < n; k++) {
                dp[k * i] = -1;
            }
            
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (dp[i] == 1) count++;
        }
        return count;
        
    }
}

//Time complexity: O(n/2 + n/3 + n/5 + n/7 +...+ n/largest prime smaller than n) < O(n * ln(n)) 
//Space complexity: O(n)
