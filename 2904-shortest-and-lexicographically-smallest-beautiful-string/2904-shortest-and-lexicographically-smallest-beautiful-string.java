class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String res = "";
        int i = 0;
        //sliding window s[i,j]
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '1') k--;
            while (i <= j && k == 0) {
                int len = j - i + 1;
                String currStr = s.substring(i, i + len);
                
                if (res.isEmpty() || len < res.length() || (len == res.length() && currStr.compareTo(res) < 0)) {
                    res = currStr;
                }
                
                //if the left bound is 0, then i++
                //if the left bound is 1, then i++, k++, break, then move the right bound
                if (s.charAt(i++) == '1') {
                    k++;
                    break;
                }
            }
        }
        return res;
    }
}
//Time: O(n * n); Space: O(1)