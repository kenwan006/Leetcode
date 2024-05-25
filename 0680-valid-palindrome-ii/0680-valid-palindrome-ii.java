class Solution {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        
        if (i >= j) return true; // no need to delete any char as s is arleady palindrome
        
        return isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i + 1, j + 1));
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}