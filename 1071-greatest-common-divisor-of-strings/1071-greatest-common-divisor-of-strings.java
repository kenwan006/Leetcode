class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) return gcdOfStrings(str2, str1);
        
        int n = str2.length();
        for (int k = n; k >= 1; k--) {
            if (n % k != 0) continue;
            String t = str2.substring(0, k);
            if (divisible(str1, t) && divisible(str2, t)) return t;
        }
        return "";
    }
    
    //check if t is divisor of s
    private boolean divisible(String s, String t) {
        int m = s.length(), n = t.length();
        if (m % n != 0) return false;
        for (int i = 0; i < m; i += n) {
            if (!s.substring(i, i + n).equals(t)) return false;
        }
        return true;
    }
}

//Time: O(m * n); Space: O(1)
