class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[0] - b[0]);
        long[] dp = new long[n + 1]; //dp[i] - max earning when ending before i
        
        int j = 0, m = rides.length;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            while (j < m && rides[j][0] == i) { //we could have mutiples rides with the same start
                int start = rides[j][0], end = rides[j][1], tip = rides[j][2];
                dp[end] = Math.max(dp[end], dp[start] + end - start + tip);
                j++;
            }
        }
        return dp[n];
    }
}