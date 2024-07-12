class Solution {
    List<String> res;
    public List<String> validStrings(int n) {
        res = new ArrayList<>();
        dfs(0, n, "");
        return res;
    }
    
    private void dfs(int i, int n, String s) {
        if (i > 1 && s.charAt(i - 1) - '0' + s.charAt(i - 2) - '0' < 1) return;
        
        if (i == n) {
            res.add(s);
            return;
        }
        
        dfs(i + 1, n, s + "0");
        dfs(i + 1, n, s + "1");
    }
}