class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; //dp[i][j] - string s[i..j] is palindromic or not
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = j - i < 2? s.charAt(i) == s.charAt(j) : dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        
        int[] cut = new int[n]; //cut[j] - min cuts needed for a palindrome partitioning of s[0..j]
        Arrays.fill(cut, n); // at most n cuts
        cut[0] = 0;
        for (int j = 1; j < n; j++) { //j - right pointer
            //check if the substring s[0..j] is palindromic itself, no cut needed
            if (dp[0][j]) {
                cut[j] = 0;
                continue;
            }
            
            for (int i = 0; i < j; i++) { //i - left pointer - check the substring s[i..j] is palindromic
                if (dp[i + 1][j]) {
                    cut[j] = Math.min(cut[j], cut[i] + 1);
                } 
            }
        }
        return cut[n - 1];
    }
}
//Time: O(n * n); Space: O(n * n)