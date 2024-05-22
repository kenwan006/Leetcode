class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        
        int count = 0;
        for (int f : freq) {
            if (f % 2 == 1) count++;
            if (count > 1) return false;
        }
        
        return true;
    }
}