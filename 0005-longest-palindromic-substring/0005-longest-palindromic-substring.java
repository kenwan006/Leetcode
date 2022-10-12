/** Approach 1: expand around center
/** Approach 2: DP

/* Expand around center
* For a string s, find the longest palindrom if we choose one postion s[i] as the center/ starting point,
* two pointers l and r, and move to left and right simultaneously until s[l] != s[r].
* the length of longest panlindromic sub-string is r - l + 1.
*/
class Solution {
    private int lo, maxLen;
    
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            lengthOfPalindrome(s, i, i); //assume the substring has odd length
            lengthOfPalindrome(s, i, i + 1); // assume the substring has even length
        }
        return s.substring(lo, lo + maxLen);
    }
    
    private void lengthOfPalindrome(String s, int l, int r) {
        while(l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
            l--;
            r++;
        }
        if (r - l - 1 > maxLen) { // (r -1) - (l + 1) + 1
            maxLen = r - l - 1;
            lo = l + 1;
        }
    }
} 

/* DP
* dp(i, j) represents whether s(i ... j) can form a palindromic substring.
* dp(i, j) is true when s(i) == s(j) and s(i+1 ... j-1) is a palindromic substring.
*/
/*
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int lo = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {// put j at the outer loop
            for (int i = 0; i <= j; i++) {
                //if the length of s(i..j) is 1, 2 or 3, only check if s[i] == s[j]; otherwise dp
                dp[i][j] = j - i > 2? (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) : s.charAt(i) == s.charAt(j);
                
                if (dp[i][j] && j - i + 1 > maxLen) {
                    lo = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(lo, lo + maxLen);
    }
}

*/
