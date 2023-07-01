class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; //dp[j] - s[0...j) can be segmented, j is exclusive
        dp[0] = true;
        for (int j = 0; j <= n; j++) {
            for (String word : wordDict) {
                if (word.length() > j) continue;
                int i = j - word.length();
                if (s.substring(i, j).equals(word) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[n];
    }
}
