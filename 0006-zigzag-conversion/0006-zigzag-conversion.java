class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
        
        int i = 0, n= s.length();
        while (i < n) {
            //go downward
            for (int j = 0; j < numRows && i < n; j++, i++) {
                sbs[j].append(s.charAt(i));
            }
            
            //go upward
            for (int j = numRows - 2; j > 0 && i < n; j--, i++) {
                sbs[j].append(s.charAt(i));
            }
        }
        
        //covert stringbuilder to string and concatenate all string
        String res = "";
        for (StringBuilder sb : sbs) res += sb.toString();
        return res;
    }
}
//Time: O(n); Space: O(n)