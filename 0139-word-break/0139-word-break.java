/** dp **/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1]; // dp[i] represents substring s[0..i) is breakable or not
        dp[0] = true; 
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i < len) continue;
                if(s.substring(i - len, i).equals(word) && dp[i - len]) {
                    dp[i] = true;
                    break; //once found, no need to check other words in the dict
                }
            }
        }
        return dp[n];    
    }
}
//Time: O(n * m); Space: O(n)
