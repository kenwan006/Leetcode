/** Two pointer **/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int m = s.length(), n = t.length();
        int i = m - 1, j = n - 1;
        int scount = 0, tcount = 0;
        
        while (i >= 0 || j >= 0) {
            //count '#' and remove chars for s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    scount++;
                } else {
                    if (scount > 0) scount--;
                    else break;
                }
                i--;
            }
            //count '#'' and remove chars for t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    tcount++;
                } else {
                    if (tcount > 0) tcount--;
                    else break;
                }
                j--;
            }
            
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            
            //when both i and j within range, compare the chars
            if (s.charAt(i) != t.charAt(j)) return false;
            i--; j--;
        }
        return true;
    }
}
//Time: O(n); Space: O(1)
