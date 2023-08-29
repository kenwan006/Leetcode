class Solution {
    List<String> res = new LinkedList<>();
   
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, "", 0);
        return res;
    }
    
    private void backtrack(String s, int start, String str, int dots) {
        //if (dots > 4) return;
        if (dots == 4) {
            if (start == s.length()) res.add(str);
            return;
        }
        
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String sec = s.substring(start, start + i);
            if ((s.charAt(start) == '0' && i > 1) || (i ==3 && Integer.parseInt(sec) > 255)) break;
            
            String newStr = str + sec;
            if (dots < 3) {
                newStr += ".";
            }
            backtrack(s, start + i, newStr, dots + 1);
        }
    }
}
    
