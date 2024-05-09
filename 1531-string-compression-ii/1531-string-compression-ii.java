class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        /**
        * dp[i][j] - min length after deleting at most j chars from s[0..i)
        * either remove ith char, then dp[i][j] = dp[i - 1][j - 1],
        * or keep the ith char, then remove del chars before i that is != s[i], 
        * where 1 <= l <= i and del <= j (at most j chars to be romove)
        * dp[i][j] = min{dp[l][j - del]}
        */
        int[][] dp = new int[n + 1][k + 1]; 
        for (int[] i : dp) Arrays.fill(i, n);
        for (int j = 0; j <= k; j++) dp[0][j] = 0;
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                //delete the ith char
                if (j > 0) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                
                //keep the ith char
                int cnt = 0; //count of chars == s[i]
                int del = 0; //count of chars != s[i], and remove them
                char c = s.charAt(i - 1);
                for (int l = i; l >= 1; l--) {
                    if (s.charAt(l - 1) == c) cnt++;
                    else del++;
                    if (del <= j) {
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - del] + (cnt >= 100? 4 : cnt >= 10? 3 : cnt >= 2? 2 : 1));
                    }
                }
            }
        }
        return dp[n][k];
    }
}