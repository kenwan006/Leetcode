/** dp **/
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '0'? 0 : 1;
        
        for (int i = 1; i < n; i++) {
            //check if one single digit s[i] is 1 ~ 9
            if (s.charAt(i) != '0') dp[i] = dp[i - 1];
            
            //check if two digits s[i-1, i] is 10 ~ 26
            int digits = Integer.valueOf(s.substring(i - 1, i + 1));
            if (digits >= 10 && digits <= 26) {
                if (i == 1) dp[i] += 1; //when s is a two char string eg "12"
                if (i >= 2) dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }
}
//Time: O(n); Space: O(n)


