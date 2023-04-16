/** Sliding window */
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";
        
        int[] map = new int[58];
        for (char c : t.toCharArray()) map[c - 'A']++;
        
        //extend the right boundary and shrink the left boundary as needed
        int i = 0, j = 0, count = n; //sliding window [i...j]
        int start = 0, minLen = Integer.MAX_VALUE;
        while (j < m) {
            if (map[s.charAt(j) - 'A'] > 0) count--;
            map[s.charAt(j) - 'A']--;

            //shrink the window
            while (count == 0) {
               if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    start = i;
                }
                if (map[s.charAt(i) - 'A'] >= 0) count++;
                map[s.charAt(i) - 'A']++;
                i++; //move the left boundary to right by one
            }
            j++;
        }
        
        return minLen == Integer.MAX_VALUE? "" : s.substring(start, start + minLen);
        
    }
}