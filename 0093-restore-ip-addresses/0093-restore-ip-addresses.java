class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        dfs(0, 0, s, "");
        return res;
    }
    
    private void dfs(int i, int dots, String s, String ip) {
        if (dots == 4) {
            if (i == s.length()) res.add(ip);
            return;
        }
        
        for (int len = 1; len <= 3 && i + len <= s.length(); len++) {
            String str = s.substring(i, i + len);
            if (str.startsWith("0") && len > 1 || Integer.parseInt(str) > 255) break;
            String newIp = ip + str;
            if (dots < 3) newIp += ".";
            dfs(i + len, dots + 1, s, newIp);
        }
    }
}
