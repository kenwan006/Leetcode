class Solution {
    public int firstUniqChar(String s) {
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) { 
            pos[s.charAt(i) - 'a'] = i; // last position of char in the s
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (pos[c - 'a'] == i) return i;
            pos[c - 'a'] = -1;
        }
        
        return -1;
    }
}
