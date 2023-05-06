/** expand around center **/
class Solution {
    int count;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i); // length of the palindromic substring is odd
            expandAroundCenter(s, i, i + 1); //even
        }
        return count;
    }
    
    //expand around the center
    public void expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) break;
            l--;
            r++;
            count++;
        }
    }
}
//Time: O(N * n); Space: O(1)