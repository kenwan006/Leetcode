class Solution {
    public boolean validPalindrome(String s) {
        int m = s.length();
        int i = 0, j = m - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                if (isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j)) return true;
                else return false;
            }
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }    
}