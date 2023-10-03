class Solution {
    public boolean backspaceCompare(String s, String t) {
        int m = s.length(), n = t.length();
        int i = m - 1, j = n - 1;
        int count1 = 0, count2 = 0;
        while (i >= 0 || j >= 0) {
            // if '#', count++; if not '#', then count-- until count == 0
            while (i >= 0 && s.charAt(i) == '#') {
                count1++;
                i--;
                while (i >= 0 && count1 > 0 && s.charAt(i) != '#') {
                    i--;
                    count1--;
                }
            }
            
            while (j >= 0 && t.charAt(j) == '#') {
                count2++;
                j--;
                while (j >= 0 && count2 > 0 && t.charAt(j) != '#') {
                    j--;
                    count2--;
                }
            }
            
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            
            //when both i and j within the bounds, compare the chars
            if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}