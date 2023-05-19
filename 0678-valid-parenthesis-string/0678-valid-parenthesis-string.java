/** Greedy *
* Count the number of the close parenthesis ')' still needed to validate whole string.
* Since '*' may exist, the count would be in a range [cmin, cmax]. Check if cmin == 0 in the end.
* eg, s = " (*) ", cmin = -1, cmax = 1
*/
class Solution {
    public boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cmin++;
                cmax++;
            } else if (ch == ')') {
                cmin--;
                cmax--;
            } else if (ch == '*') {
                cmin--;
                cmax++;
            }
            //return false once seeing ')' more than '('
            if (cmax < 0) return false; 
            cmin = Math.max(cmin, 0);
        }
        
        return cmin == 0;
    }
}
//Time: O(n); Space: O(1)

