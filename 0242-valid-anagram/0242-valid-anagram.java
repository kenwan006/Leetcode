class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] count = new int[26]; // 'a' means i = 0
        for (char ch : s.toCharArray()) count[ch - 'a']++;
        for (char ch : t.toCharArray()) {
            if (--count[ch -'a'] < 0) return false;
        }
        return true;
    }
}