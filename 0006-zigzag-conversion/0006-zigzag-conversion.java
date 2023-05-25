class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        
        int index = 0, len = s.length();
        while (index < len) {
            //go downward
            for (int k = 0; k < numRows && index < len; k++) {
                sbs[k].append(s.charAt(index++));
            }
            //go upward
            for (int k = numRows - 2; k > 0 && index < len; k--) {
                sbs[k].append(s.charAt(index++));
            }
        }
        
        String res = "";
        for (StringBuilder sb : sbs) res += sb.toString();
        return res;
    }
}
//Time: O(n); Space: O(n)