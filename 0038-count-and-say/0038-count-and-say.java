class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            String encoder = encode(s);
            s = encoder;
        }
        return s;
    }
    
    private String encode(String s) {
        int i = 0, n = s.length();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            int len = 1;
            while (i + len < n && s.charAt(i + len) == s.charAt(i)) len++;
            sb.append(len).append(s.charAt(i));
            i += len;
        }
        return sb.toString();
    }
}