class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = getNext(s);
        int n = s.length();
        int len = next[n - 1];
        return len > 0 && len % (n - len) == 0;
    }
    
    //KMP to get the array - next
    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        int j = 0;
        for (int i = 1; i <n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}